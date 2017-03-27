package com.yql.biz.service.impl;

import com.yql.biz.dao.StockOperationRecordDao;
import com.yql.biz.model.StockRecord;
import com.yql.biz.service.IStockOperationRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by wangdayin on 2017/2/6.
 */
@Service
@Transactional
public class StockOperationServiceImpl implements IStockOperationRecordService {

    @Resource
    private StockOperationRecordDao stockOperationRecordDao;

    @Override
    public void saveStockOperationRecord(StockRecord stockRecord) {
        this.stockOperationRecordDao.save(stockRecord);
    }
}
