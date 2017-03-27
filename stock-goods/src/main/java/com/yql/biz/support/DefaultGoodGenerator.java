package com.yql.biz.support;


import com.yql.biz.dao.IGoodDao;
import com.yql.biz.dao.IGoodItemDao;
import com.yql.biz.exception.GoodException;
import com.yql.biz.exception.GoodItemException;
import com.yql.biz.model.Good;
import com.yql.biz.model.Item;
import com.yql.biz.model.StockRecord;
import com.yql.biz.util.StockUtil;
import com.yql.biz.vo.GoodItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Component("goodGenerator")
public class DefaultGoodGenerator implements GoodGenerator {

    @Resource
    private IGoodItemDao goodItemDao;
    @Resource
    private IGoodDao goodDao;

    @Override
    public Good generateGood(GoodItemVo goodItemVo) {
        Good good = new Good();
        String goodItemNo = goodItemVo.getGoodItemNo();
        if (StringUtils.hasText(goodItemNo)){
            Item item = goodItemDao.findByItemNoAndActiveTrue(goodItemNo);
            if (item!=null){
                good = goodDao.findByGoodNoAndActiveTrue(item.getGoodNo());
            }
        }else {
            String randomNum = StockUtil.randomNum();
            good.setGoodNo(randomNum);
            Good byGoodNo = goodDao.findByGoodNoAndActiveTrue(randomNum);
            if (byGoodNo!=null){
                throw new GoodException();
            }
        }
        BeanUtils.copyProperties(goodItemVo,good);
        return good;
    }

    @Override
    public Item generateItem(GoodItemVo goodItemVo) {
        Item item = new Item();
        String goodItemNo = goodItemVo.getGoodItemNo();
        if (StringUtils.hasText(goodItemNo)){
             item =  goodItemDao.findByItemNoAndActiveTrue(goodItemNo);
        }else {
            String randomCode = StockUtil.randomNum();
            item.setItemNo(randomCode);
            item.setItemName(goodItemVo.getGoodName());
            Item byItemNo = goodItemDao.findByItemNoAndActiveTrue(randomCode);
            if (byItemNo!=null){
                throw new GoodItemException();
            }
        }
        BeanUtils.copyProperties(goodItemVo,item);
        return  item;
    }

    @Override
    public StockRecord generateStockOperation(Good goodFlush, Item itemFlush) {
        return new StockRecord(goodFlush.getGoodNo(), itemFlush.getItemNo(), goodFlush.getMerchantCode(), itemFlush.getAmount());
    }
}
