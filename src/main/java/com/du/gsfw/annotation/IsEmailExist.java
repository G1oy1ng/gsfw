package com.du.gsfw.annotation;

import com.du.gsfw.model.entity.DemoUser;
import com.du.gsfw.service.DemoUserService;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsEmailExist.IsEmailExistValidator.class})
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
public @interface IsEmailExist {

    String message() default "this email already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @AllArgsConstructor
    public class IsEmailExistValidator implements ConstraintValidator<IsEmailExist, String> {

        private final DemoUserService demoUserService;

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

            if ("".equals(value) || null == value) {
                return false;
            }else{
                DemoUser emailExist = demoUserService.findByEmail(value);
                if (null == emailExist) {
                    return true;
                }else {
                    return false;
                }
            }
        }

        @Override
        public void initialize(IsEmailExist constraintAnnotation) {

        }
    }
}
