package com.javakc.project.commons.utils.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Program: spring-boot-ssmp
 * @Created: 2021/3/11 14:08
 * @Author: ZhouHongGang
 * @Description: TODO
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    //数字
    public static final String NUMBER = ".*\\d+.*";
    //小写字母
    public static final String UPPERCASE = ".*[A-Z]+.*";
    //大写字母
    public static final String LOWERCASE = ".*[a-z]+.*";
    //特殊符号
    public static final String SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.hasText(value))
        {
            int count = 0;
            if (value.matches(PasswordValidator.NUMBER)) count++;
            if (value.matches(PasswordValidator.LOWERCASE)) count++;
            if (value.matches(PasswordValidator.UPPERCASE)) count++;
            if (value.matches(PasswordValidator.SYMBOL)) count++;
            if(count > 2)
                return true;
        }
        return false;
    }

}
