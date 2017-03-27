package com.yql.biz.vo;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author simple
 * @desc 商品vo
 * @date 2017/1/19 0019
 */
public class GoodItemVo {
    //产品名称
    @NotNull(message = "{com.yql.validation.goodName.notNull}")
    private String goodName;
    //头像url
    @NotNull(message = "{com.yql.validation.headImg.notNull}")
    private String headImg;
    //详情图片
    private String images;
    //产品详情
    private String info;
    //是否上架
    private boolean active = true;
    //上架时间
    private Date putTime = new Date();
    //截止日期
    private Date deadLine;
    //商品库存
    @NotNull(message = "{com.yql.validation.amount.notNull}")
    private int amount ;
    //商品销量
    private int saleNum;
    //商品单位
    private String unit;
    //分类
    private String categoryId;
    private BigDecimal price;
    //商户Code
    private String merchantCode;
    //itemNo
    private String goodItemNo;
    //商品code
    private String goodNo;

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
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

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
