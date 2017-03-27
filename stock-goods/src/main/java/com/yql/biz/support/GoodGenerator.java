package com.yql.biz.support;


import com.yql.biz.model.Good;
import com.yql.biz.model.Item;
import com.yql.biz.model.StockRecord;
import com.yql.biz.vo.GoodItemVo;

public interface GoodGenerator {

    /**
     * 生成商品对象
     */
    Good generateGood(GoodItemVo goodItemVo);

    /**
     * 生成商品详情对象
     */
    Item generateItem(GoodItemVo goodItemVo);

    /**
     * 生成库存操作记录对象
     *
     * @param goodFlush
     * @param itemFlush
     * @return
     */
    StockRecord generateStockOperation(Good goodFlush, Item itemFlush);
}
