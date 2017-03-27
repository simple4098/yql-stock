package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class GoodItemSaleNumException extends MessageRuntimeException {
    public GoodItemSaleNumException() {
        super("com.yql.biz.exception.goodItemSaleNum.message");
    }
}
