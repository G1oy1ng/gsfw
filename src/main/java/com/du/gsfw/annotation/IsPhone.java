package com.du.gsfw.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsPhone.IsPhoneValidator.class})
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
public @interface IsPhone {

    String message() default "the phone number format is incorrect";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class IsPhoneValidator implements ConstraintValidator<IsPhone, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if ("".equals(value) || null == value) {
                return false;
            }else{
                return isPhone(value);
            }
        }

        public static boolean isPhone (String phone){
            String pattern  = "^1[0-9]{10}$";
            if (Pattern.matches(pattern, phone)) {
                return true;
            }else{
                return false;
            }
        }

        @Override
        public void initialize(IsPhone constraintAnnotation) {

        }
    }
}
