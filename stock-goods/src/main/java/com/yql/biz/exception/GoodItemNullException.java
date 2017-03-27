package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class GoodItemNullException extends MessageRuntimeException {
    public GoodItemNullException() {
        super("com.yql.biz.exception.notGoodItemNo.message");
    }
}
