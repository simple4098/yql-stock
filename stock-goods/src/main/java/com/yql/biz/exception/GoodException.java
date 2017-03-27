package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class GoodException extends MessageRuntimeException {
    public GoodException() {
        super("com.yql.biz.exception.goodNo.message");
    }
}
