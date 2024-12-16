package com.du.gsfw.annotation;

import com.du.gsfw.model.dto.request.DemoUserAddRequestDTO;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordEqual.PasswordUserValidator.class})
@Target(ElementType.TYPE)
public @interface PasswordEqual {

    String message() default "密码不一致";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class PasswordUserValidator implements ConstraintValidator<PasswordEqual, DemoUserAddRequestDTO> {

        @Override
        public boolean isValid(DemoUserAddRequestDTO changePasswordDto, ConstraintValidatorContext constraintValidatorContext) {
            String newPassword = changePasswordDto.getPassword();
            String confirmPassword = changePasswordDto.getConfirmPassword();
            return newPassword.equals(confirmPassword);
        }

        @Override
        public void initialize(PasswordEqual constraintAnnotation) {
        }
    }
}
