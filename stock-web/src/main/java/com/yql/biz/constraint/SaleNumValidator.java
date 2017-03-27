package com.yql.biz.constraint;

import com.yql.biz.enums.OperationType;
import com.yql.biz.exception.GoodItemPriceException;
import com.yql.biz.model.Item;
import com.yql.biz.service.IGoodService;
import com.yql.biz.vo.GoodItemAmount;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author simple
 */
public class SaleNumValidator implements ConstraintValidator<SaleNum, GoodItemAmount> {

    @Resource
    private IGoodService goodService;

    @Override
    public void initialize(SaleNum saleNum) {
    }

    @Override
    public boolean isValid(GoodItemAmount goodItemAmount, ConstraintValidatorContext constraintValidatorContext) {

        if (StringUtils.isEmpty(goodItemAmount.getGoodItemNo())){
            return false;
        }
        Item item = goodService.findByItemNoAndActiveTrue(goodItemAmount.getGoodItemNo());
        int amount = goodItemAmount.getAmount();
        if (goodItemAmount.getOperationType()!=null){
            if (OperationType.CANCEL_ORDER.equals(goodItemAmount.getOperationType())){
                goodItemAmount.setAmount(-amount);
            }else {
                if (item.getPrice().compareTo(goodItemAmount.getPrice())!=0){
                    return false;
                }
            }
        }else {
            return false;
        }
        return amount!=0;
    }
}
