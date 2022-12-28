package springdemo.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefixes = courseCode.values();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code != null) {
            for (String tempPrefix : coursePrefixes) {
                if (code.startsWith(tempPrefix)) {
                    return true;
                }
            }
        }
        return false;
    }
}
