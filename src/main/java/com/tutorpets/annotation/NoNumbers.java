package com.tutorpets.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoNumbersValidator.class)
public @interface NoNumbers {
    String message() default "The field must not contain numerical characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
