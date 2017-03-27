package com.yql.biz.dao;

import com.yql.biz.model.GoodImg;
import com.yql.biz.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/19 0019
 */
@Repository
public interface IGoodImgDao extends JpaRepository<GoodImg,Integer> {

    List<GoodImg> findByItemNo(String goodItemNo);
}
