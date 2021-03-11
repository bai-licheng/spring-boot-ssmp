package com.javakc.project.commons.utils.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Program: spring-boot-ssmp
 * @Created: 2021/3/11 14:07
 * @Author: ZhouHongGang
 * @Description: TODO
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Repeatable(value = Password.List.class)
public @interface Password {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        Password[] value();
    }

}
