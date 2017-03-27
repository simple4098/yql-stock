package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class GoodItemException extends MessageRuntimeException {
    public GoodItemException() {
        super("com.yql.biz.exception.goodItemNo.message");
    }
}
