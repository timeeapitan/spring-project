package springdemo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    String[] values() default {"LUV"};

    // define default error message
    String message() default "must start with LUV";

    // define default groups
    Class<?>[] groups() default {};

    // define default
    Class<? extends Payload>[] payload() default {};
}
