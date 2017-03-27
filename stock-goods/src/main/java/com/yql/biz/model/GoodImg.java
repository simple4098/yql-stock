package com.yql.biz.model;

import com.yql.core.model.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/18 0018
 */
@Entity
@Table(name = "good_img")
public class GoodImg extends Domain {
    @Column(name = "good_no", nullable = false)
    private String goodNo;
    @Column(name = "item_no", nullable = false)
    private String itemNo;
    @Column(name = "img_url")
    private String imgUrl;
    //商户
    @Column(name = "merchant_code", nullable = false)
    private String merchantCode;
    @Column(name = "img_name")
    private String imgName;
    @Column(name = "cos_path")
    private String cosPath;
    @Column(name = "cos_path_file")
    private String cosPathFile;
    public GoodImg() {
    }

    public GoodImg(String goodNo, String itemNo, String imgUrl, String merchantCode, String imgName, String cosPath, String cosPathFile) {
        this.goodNo = goodNo;
        this.itemNo = itemNo;
        this.imgUrl = imgUrl;
        this.merchantCode = merchantCode;
        this.imgName = imgName;
        this.cosPath = cosPath;
        this.cosPathFile = cosPathFile;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getCosPath() {
        return cosPath;
    }

    public void setCosPath(String cosPath) {
        this.cosPath = cosPath;
    }

    public String getCosPathFile() {
        return cosPathFile;
    }

    public void setCosPathFile(String cosPathFile) {
        this.cosPathFile = cosPathFile;
    }
}
