package com.yql.biz.service;

import com.yql.biz.enums.OperationType;
import com.yql.biz.model.Item;
import com.yql.biz.vo.GoodItemAmount;
import com.yql.biz.vo.GoodItemPageVo;
import com.yql.biz.vo.GoodItemVo;
import com.yql.core.web.PageModel;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/19 0019
 */
public interface IGoodService {

    /**
     * 保存商品、商品信息
     * @param goodItemVo 商品信息
     */
    void saveUpdateGoodItem(GoodItemVo goodItemVo);

    /**
     * 更新goodItem 库存销量
     */
    GoodItemVo updateGoodItemAmount(GoodItemAmount goodItemAmount);

    /**
     * 查询查询信息
     * @param goodItemNo 产品No
     */
    GoodItemVo findGoodInfoByGoodItemNo(String goodItemNo);

    /**
     * 查询item
     * @param goodItemNo 产品code
     */
    Item findByItemNoAndActiveTrue(String goodItemNo);

    /**
     * 更新产品上下架状态
     * @param goodItemNo 产品code
     */
    void updateGoodItemActive(String goodItemNo);

    /**
     * 根据商户code查询商品列表
     * @param merchantCode 商户code
     * @param active 是否上下架
     */
    PageModel<GoodItemPageVo> findGoodInfoListByMerchantCode(String merchantCode, boolean active, Pageable pageable);

    void updateItemImages(String itemNo, String images);

    void deleteItemImage(String id, String itemNo);
}
