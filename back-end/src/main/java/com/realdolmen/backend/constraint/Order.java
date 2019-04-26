package com.realdolmen.backend.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {OrderValidator.class})
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Order {
    String message() default "Order is not valid";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
