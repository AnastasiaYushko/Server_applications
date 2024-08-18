package org.example.myAnnotations.checkStatus;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StatusValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckStatus {
    String message() default "Неверный статус";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
