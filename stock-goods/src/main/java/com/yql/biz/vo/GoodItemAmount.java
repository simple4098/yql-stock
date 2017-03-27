package com.yql.biz.vo;

import com.yql.biz.enums.OperationType;

import java.math.BigDecimal;

/**
 * @author simple
 * @desc 描述
 * @date 2017/2/8 0008
 */
public class GoodItemAmount {
    private String goodItemNo;
    private  int amount;
    private OperationType operationType;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getGoodItemNo() {
        return goodItemNo;
    }

    public void setGoodItemNo(String goodItemNo) {
        this.goodItemNo = goodItemNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
