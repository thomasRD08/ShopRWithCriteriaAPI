package com.realdolmen.backend.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {UniqueUserValidator.class})
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface UniqueUser {
    String message() default "User already exists";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
