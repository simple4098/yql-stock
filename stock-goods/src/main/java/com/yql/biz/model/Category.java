package com.yql.biz.model;

import com.yql.core.model.Domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/17 0017
 */
@Entity
@Table(name = "category")
public class Category extends Domain {
    //商户
    private String merchantNo;
    //分类名称
    private String categoryName;
    //是否删除
    private boolean deleted;


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
