package com.yql.biz.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yql.biz.model.Good;
import com.yql.biz.model.GoodImg;
import com.yql.biz.model.Item;
import com.yql.biz.vo.GoodItemVo;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author simple
 * @desc 描述
 * @date 2017/1/20 0020
 */
public class StockUtil {

    private StockUtil() {
    }


    public static String randomNum() {
        String times = DateFormatUtils.format(Calendar.getInstance(), "mmssSSS");
        String randomCode = RandomStringUtils.randomNumeric(4);
        return randomCode + times;
    }

    /**
     * 得到产品图片对象
     *
     * @param good
     * @param item
     * @param imgs
     * @return
     */
    public static List<GoodImg> getGoodImg(Good good, Item item, String imgs) {
        if (StringUtils.hasText(good.getGoodNo()) && null != item && StringUtils.hasText(imgs)) {
            List<GoodImg> goodImgs = JSONObject.parseObject(imgs, new TypeReference<List<GoodImg>>() {
            });
            goodImgs.forEach(goodImg -> {
                goodImg.setGoodNo(good.getGoodNo());
                goodImg.setItemNo(item.getItemNo());
                goodImg.setMerchantCode(good.getMerchantCode());
            });
            return goodImgs;
        }
        return null;
    }
}
