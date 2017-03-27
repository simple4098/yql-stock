package com.yql.biz.dao;

import com.yql.biz.model.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangdayin on 2017/2/6.
 */
public interface StockOperationRecordDao extends JpaRepository<StockRecord, Integer> {
}
