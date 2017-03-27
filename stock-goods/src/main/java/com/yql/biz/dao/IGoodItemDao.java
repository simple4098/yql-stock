package com.yql.biz.dao;

import com.yql.biz.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/19 0019
 */
@Repository
public interface IGoodItemDao extends JpaRepository<Item,Integer> {
    /**
     * 根据产品code、查询上架或者下架的产品
     * @param itemNo 产品code
     */
    Item findByItemNoAndActiveTrue(String itemNo);
    /**
     * 根据产品code查询 goodItem
     * @param goodItemNo 产品code
     */
    Item findByItemNo(String goodItemNo);
    /**
     * 根据商户code查询goodItem
     * @param merchantCode
     * @param active
     * @param pageable
     * @return
     */
    Page<Item> findByMerchantCodeAndActiveOrderByCreatedTime(String merchantCode, boolean active, Pageable pageable);

    List<Item> findByGoodNoAndActive(String goodNo, boolean active);


}
