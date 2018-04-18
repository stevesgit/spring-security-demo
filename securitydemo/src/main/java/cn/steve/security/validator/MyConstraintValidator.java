package cn.steve.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created By SteveWoo
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        return true;
    }

    @Override
    public void initialize(MyConstraint constraintAnnotation) {

    }
}
