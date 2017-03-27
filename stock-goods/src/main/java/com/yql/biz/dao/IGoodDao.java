package com.yql.biz.dao;

import com.yql.biz.model.Good;
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
public interface IGoodDao extends JpaRepository<Good,Integer> {

    /**
     * 根据商品code查询商品
     * @param goodNo 商品编号
     */
    Good findByGoodNoAndActiveTrue(String goodNo);

    Good findByGoodNo(String goodNo);

    /**
     * 查询商户下的 上架或者下架产品
     * @param merchantCode
     * @param active
     * @param pageable
     * @return
     */
    Page<Good> findByMerchantCodeAndActiveOrderByPutTime(String merchantCode, boolean active, Pageable pageable);
}
