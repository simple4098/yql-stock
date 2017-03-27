package com.yql.biz.support.helper;

import com.yql.biz.enums.OperationType;
import com.yql.biz.model.GoodImg;
import com.yql.biz.model.StockRecord;
import com.yql.biz.service.IStockOperationRecordService;
import com.yql.biz.support.client.ImageServerClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by wangdayin on 2017/2/6.
 */
@Component
public class GoodItemHelper {
    @Resource
    private IStockOperationRecordService stockOperationRecordService;
    @Resource
    private ImageServerClient imageServerClient;

    /**
     * 保存库存操作记录
     *
     * @param operationType
     * @param stockRecord
     */
    public void saveStockOperationRecord(StockRecord stockRecord, OperationType operationType) {
        Optional.ofNullable(stockRecord).filter(Objects::nonNull).ifPresent(stockRecord1 -> {
            stockRecord1.setOperationType(operationType);
            this.stockOperationRecordService.saveStockOperationRecord(stockRecord1);
        });
    }

    /**
     * 同步删除腾讯图片
     *
     * @param imgs
     */
    public void synchronizationDeleteImage(List<GoodImg> imgs) {
        String cosPathFiles = "";
        if (!CollectionUtils.isEmpty(imgs)) {
            for (GoodImg goodImg : imgs) {
                cosPathFiles = cosPathFiles + goodImg.getCosPathFile() + "||";
            }
            Optional.ofNullable(cosPathFiles).ifPresent(s -> this.imageServerClient.deleteImage(StringUtils.substring(s, 0, s.length() - 2)));
        }
    }
}
