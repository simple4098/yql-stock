package com.yql.biz.support.client;

import com.yql.core.web.ResponseModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangdayin on 2016/12/7.
 */
@FeignClient(value = "image-server", fallback = ImageServerClientHystrix.class)
public interface ImageServerClient {
    @RequestMapping(value = "/delete-img", method = RequestMethod.POST)
    ResponseModel deleteImage(@RequestParam("cosPathFiles") String cosPathFiles);
}
