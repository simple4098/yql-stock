package com.yql.biz.model;

import com.yql.biz.enums.OperationType;
import com.yql.core.model.Domain;

import javax.persistence.*;

/**
 * Created by wangdayin on 2017/2/6.
 * 库存操作记录对象
 */
@Entity
@Table(name = "stock_operation_record")
public class StockRecord extends Domain {
    @Column(name = "good_no", nullable = false)
    private String goodNo;
    @Column(name = "item_no", nullable = false)
    private String itemNo;
    @Column(name = "merchant_code", nullable = false)
    private String merchantCode;
    @Column(name = "operation_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OperationType operationType;
    @Column(name = "operation_amount")
    private int operationAmount;

    public StockRecord() {
    }

    public StockRecord(String goodNo, String itemNo, String merchantCode, OperationType operationType, int operationAmount) {
        this.goodNo = goodNo;
        this.itemNo = itemNo;
        this.merchantCode = merchantCode;
        this.operationType = operationType;
        this.operationAmount = operationAmount;
    }

    public StockRecord(String goodNo, String itemNo, String merchantCode, int operationAmount) {
        this.goodNo = goodNo;
        this.itemNo = itemNo;
        this.merchantCode = merchantCode;
        this.operationAmount = operationAmount;
    }


    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public int getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(int operationAmount) {
        this.operationAmount = operationAmount;
    }
}
