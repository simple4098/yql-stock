package com.yql.biz.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author simple
 * @desc 商品vo
 * @date 2017/1/19 0019
 */
public class GoodItemPageVo implements Serializable {
    private Integer id;
    private String itemNo;
    private String itemName;
    //库存
    private int amount;
    //商品销量
    private int saleNum;
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
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

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
