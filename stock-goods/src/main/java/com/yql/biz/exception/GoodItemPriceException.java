package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class GoodItemPriceException extends MessageRuntimeException {
    public GoodItemPriceException() {
        super("com.yql.biz.exception.goodItemPrice.message");
    }
}
