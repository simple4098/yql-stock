package com.yql.biz.support.client;

import com.yql.core.web.ResponseModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangdayin on 2016/12/7.
 */
@Component
public class ImageServerClientHystrix implements ImageServerClient {
    @Override
    public ResponseModel deleteImage(@RequestParam("cosPathFiles") String cosPathFiles) {
        return ResponseModel.ERROR();
    }
}
