package com.yql.biz.controller;

import com.yql.biz.constraint.SaleNum;
import com.yql.biz.service.IGoodService;
import com.yql.biz.vo.GoodItemAmount;
import com.yql.biz.vo.GoodItemPageVo;
import com.yql.biz.vo.GoodItemVo;
import com.yql.core.web.PageModel;
import com.yql.core.web.ResponseModel;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author simple
 * @desc 描述
 * @date 2017/2/4 0004
 */
@RestController
@RequestMapping("/stock")
@Validated
public class StockWebController{
    @Resource
    private IGoodService goodService;

    /**
     * 保存、更新 产品
     * @param goodItemVo  goodItemNo 产品code，
     */
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    public ResponseModel good(@Validated GoodItemVo goodItemVo){
        goodService.saveUpdateGoodItem(goodItemVo);
        return ResponseModel.SUCCESS();
    }
    /**
     * 商品上下架
     * @param
     * @return
     */
    @RequestMapping(value = "/goods/active",method = RequestMethod.GET)
    public ResponseModel goodActive(String goodItemNo){
        goodService.updateGoodItemActive(goodItemNo);
        return ResponseModel.SUCCESS();
    }
    /**
     * 商品上下架列表
     * @param
     * @return
     */
    @RequestMapping("/goods/list")
    public ResponseModel goodList(String merchantCode,boolean active,Pageable pageable){
        PageModel<GoodItemPageVo> page = goodService.findGoodInfoListByMerchantCode(merchantCode,active,pageable);
        return ResponseModel.SUCCESS(page);
    }

    /**
     * 商品详情
     * @param goodItemNo 产品code
     */
    @RequestMapping(value = "/goods/info",method = RequestMethod.GET)
    public ResponseModel goodInfo( String goodItemNo){
        GoodItemVo goodItemVo = goodService.findGoodInfoByGoodItemNo(goodItemNo);
        return ResponseModel.SUCCESS(goodItemVo);
    }
    /**
     * 下单减少库存
     */
    @RequestMapping(value = "/goods/amount",method = RequestMethod.GET)
    public ResponseModel amount(@SaleNum GoodItemAmount goodItemAmount){
        GoodItemVo goodItemVo = goodService.updateGoodItemAmount(goodItemAmount);
        return ResponseModel.SUCCESS(goodItemVo);
    }
    /**
     * 更新产品图片
     *
     * @param itemNo
     * @param images
     * @return
     */
    @RequestMapping(value = "/update-item-images")
    public ResponseModel updateItemImages(String itemNo, String images) {
        this.goodService.updateItemImages(itemNo, images);
        return ResponseModel.SUCCESS();
    }

    /**
     * 删除产品图片
     *
     * @param id
     * @param itemNo
     * @return
     */
    @RequestMapping(value = "/item/delete-item-img")
    public ResponseModel deleteItemImage(@RequestParam String id, @RequestParam String itemNo) {
        this.goodService.deleteItemImage(id, itemNo);
        return ResponseModel.SUCCESS();
    }
}
