package com.yql.biz.exception;

import com.yql.core.exception.MessageRuntimeException;

/**
 * @author wangxiaohong
 */
public class LowStockException extends MessageRuntimeException {
    public LowStockException() {
        super("com.yql.biz.exception.LowStock.message");
    }
}
