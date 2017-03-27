package com.yql.biz.model;


import com.yql.biz.exception.LowStockException;
import com.yql.core.model.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/17 0017
 */
@Table(name = "item")
@Entity
public class Item extends Domain {
    //SKU名称
    private String itemName;
    //SKU编号
    private String itemNo;
    //库存
    private int amount ;
    //销量
    private int saleNum;
    //单价
    private BigDecimal price = BigDecimal.ZERO;
    //是否上架
    private boolean active = true;
    //商品id
    private String goodNo;
    //产品描述
    private String info;
    //商户
    private String merchantCode;

    public Item(String itemNo, int amount) {
        this.itemNo = itemNo;
        this.amount = amount;
    }

    public Item() {
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void minus(int amount) {
        if (amount > this.amount) {
            throw new LowStockException();
        }
        this.amount -= amount;
    }
}
