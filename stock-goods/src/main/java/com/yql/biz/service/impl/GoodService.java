package com.yql.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yql.biz.dao.IGoodDao;
import com.yql.biz.dao.IGoodImgDao;
import com.yql.biz.dao.IGoodItemDao;
import com.yql.biz.enums.OperationType;
import com.yql.biz.exception.GoodItemNullException;
import com.yql.biz.exception.GoodItemPriceException;
import com.yql.biz.exception.LowStockException;
import com.yql.biz.model.Good;
import com.yql.biz.model.GoodImg;
import com.yql.biz.model.Item;
import com.yql.biz.service.IGoodService;
import com.yql.biz.support.GoodGenerator;
import com.yql.biz.support.helper.GoodItemHelper;
import com.yql.biz.util.StockUtil;
import com.yql.biz.vo.GoodItemAmount;
import com.yql.biz.vo.GoodItemPageVo;
import com.yql.biz.vo.GoodItemVo;
import com.yql.biz.vo.converter.GoodItemPageVoConverter;
import com.yql.core.exception.DataObjectNotFoundException;
import com.yql.core.web.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author simple
 * @desc 描述
 * @date 2017/1/19 0019
 */
@Service
@Transactional
public class GoodService implements IGoodService {
    private static final Logger logger = LoggerFactory.getLogger(GoodService.class);
    @Resource
    private IGoodDao goodDao;
    @Resource
    private IGoodItemDao goodItemDao;
    @Resource
    private IGoodImgDao goodImgDao;
    @Resource
    private GoodGenerator goodGenerator;
    @Resource
    private GoodItemHelper goodItemHelper;
    @Resource
    private GoodItemPageVoConverter goodItemPageVoConverter;

    @Override
    public void saveUpdateGoodItem(GoodItemVo goodItemVo) {
        logger.info("保存商品:" + JSON.toJSONString(goodItemVo));
        Good good = goodGenerator.generateGood(goodItemVo);
        Item item = goodGenerator.generateItem(goodItemVo);
        Good goodFlush = goodDao.save(good);
        item.setGoodNo(goodFlush.getGoodNo());
        Item itemFlush = goodItemDao.save(item);
        //转换产品图片对象
        List<GoodImg> list = StockUtil.getGoodImg(good, itemFlush, goodItemVo.getImages());
        Optional.ofNullable(list).filter(Objects::nonNull).ifPresent(goodImgs -> goodImgDao.save(list));
        //保存库存操作记录
        this.goodItemHelper.saveStockOperationRecord(goodGenerator.generateStockOperation(goodFlush, itemFlush), OperationType.ADD);
    }

    @Override
    public void updateItemImages(String itemNo, String images) {
        Item item = this.goodItemDao.findByItemNoAndActiveTrue(itemNo);
        Optional.ofNullable(item).orElseThrow(() -> {
            throw new DataObjectNotFoundException();
        });
        Optional.ofNullable(item).filter(Objects::nonNull).ifPresent(item1 -> {
            if (StringUtils.hasText(images)) {
                List<GoodImg> goodImgs = JSONObject.parseObject(images, new TypeReference<List<GoodImg>>() {
                });
                Optional.ofNullable(goodImgs).filter(Objects::nonNull).ifPresent(goodImgs1 -> {
                    Good good = this.goodDao.findByGoodNoAndActiveTrue(item.getGoodNo());
                    goodImgs.forEach(goodImg -> {
                        goodImg.setItemNo(itemNo);
                        goodImg.setGoodNo(good.getGoodNo());
                        goodImg.setMerchantCode(good.getMerchantCode());
                    });
                });
                this.goodImgDao.save(goodImgs);
            }
        });
    }

    @Override
    public void deleteItemImage(String id, String itemNo) {
        Item item = this.goodItemDao.findByItemNoAndActiveTrue(itemNo);
        Optional.ofNullable(item).orElseThrow(() -> {
            throw new DataObjectNotFoundException();
        });
        //得到需要删除的图片list
        List<Integer> idList = Arrays.stream(StringUtils.delimitedListToStringArray(id, ",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        Optional.ofNullable(idList).ifPresent(integers -> {
            List<GoodImg> goodImgs = this.goodImgDao.findAll(integers);
            Optional.ofNullable(goodImgs).filter(Objects::nonNull).ifPresent(imgs -> {
                this.goodImgDao.delete(imgs);
                //同步删除腾讯云
                this.goodItemHelper.synchronizationDeleteImage(imgs);
            });
        });
    }

    @Override
    public GoodItemVo updateGoodItemAmount(GoodItemAmount goodItemAmount) {
        Item item = goodItemDao.findByItemNoAndActiveTrue(goodItemAmount.getGoodItemNo());
        if (item != null) {
            Good good = goodDao.findByGoodNoAndActiveTrue(item.getGoodNo());
            int amount = item.getAmount();
            int num = amount - goodItemAmount.getAmount();
            item.setAmount(num);
            item.setSaleNum(item.getSaleNum() + goodItemAmount.getAmount());
            if (num >= 0) {
                goodItemDao.save(item);
            } else {
                throw new LowStockException();
            }
            //保存库存操作记录
            this.goodItemHelper.saveStockOperationRecord(goodGenerator.generateStockOperation(good, new Item(goodItemAmount.getGoodItemNo(), goodItemAmount.getAmount())), goodItemAmount.getOperationType());
            return findGoodInfoByGoodItemNo(goodItemAmount.getGoodItemNo());
        } else {
            throw new GoodItemNullException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GoodItemVo findGoodInfoByGoodItemNo(String goodItemNo) {
        Item item = goodItemDao.findByItemNoAndActiveTrue(goodItemNo);
        if (item != null) {
            Good good = goodDao.findByGoodNoAndActiveTrue(item.getGoodNo());
            if (good != null) {
                GoodItemVo goodItemVo = new GoodItemVo();
                List<GoodImg> goodImg = goodImgDao.findByItemNo(goodItemNo);
                goodItemVo.setImages(JSON.toJSONString(goodImg));
                BeanUtils.copyProperties(item, goodItemVo);
                BeanUtils.copyProperties(good, goodItemVo);
                goodItemVo.setGoodItemNo(goodItemNo);
                return goodItemVo;
            }
        } else {
            throw new GoodItemNullException();
        }
        return null;
    }

    @Override
    public Item findByItemNoAndActiveTrue(String goodItemNo) {
        return goodItemDao.findByItemNoAndActiveTrue(goodItemNo);
    }

    @Override
    public void updateGoodItemActive(String goodItemNo) {
        Item item = goodItemDao.findByItemNo(goodItemNo);
        if (item != null) {
            boolean active = !item.isActive();
            List<Item> list = goodItemDao.findByGoodNoAndActive(item.getGoodNo(), !active);
            item.setActive(active);
            goodItemDao.save(item);
            if (!CollectionUtils.isEmpty(list) && list.size() == 1) {
                Good good = goodDao.findByGoodNo(item.getGoodNo());
                good.setActive(active);
                goodDao.save(good);
            }
        } else {
            throw new GoodItemNullException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PageModel<GoodItemPageVo> findGoodInfoListByMerchantCode(String merchantCode, boolean active, Pageable pageable) {
        Page<Item> items = goodItemDao.findByMerchantCodeAndActiveOrderByCreatedTime(merchantCode, active, pageable);
        Page<GoodItemPageVo> goodItemPageVos = items.map(goodItemPageVoConverter);
        PageModel<GoodItemPageVo> pageModel = PageModel.from(goodItemPageVos);
        return pageModel;
    }
}
