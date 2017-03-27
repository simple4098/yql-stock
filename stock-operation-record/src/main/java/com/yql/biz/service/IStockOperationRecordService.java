package com.yql.biz.service;

import com.yql.biz.model.StockRecord;

/**
 * Created by wangdayin on 2017/2/6.
 */
public interface IStockOperationRecordService {
    /**
     * 保存操作记录
     *
     * @param stockRecord
     */
    void saveStockOperationRecord(StockRecord stockRecord);
}
