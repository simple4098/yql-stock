package com.yql.biz.vo.converter;

import com.yql.biz.model.Item;
import com.yql.biz.vo.GoodItemPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author simple
 * @desc 描述
 * @date 2017/2/7 0007
 */
@Component
public class GoodItemPageVoConverter implements Converter<Item,GoodItemPageVo> {


    @Override
    public GoodItemPageVo convert(Item item) {
        GoodItemPageVo goodItemPageVo = new GoodItemPageVo();
        BeanUtils.copyProperties(item,goodItemPageVo);
        return goodItemPageVo;
    }
}
