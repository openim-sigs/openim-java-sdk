package org.ccs.openim.utils;

import lombok.extern.slf4j.Slf4j;

import javax.validation.*;
import java.util.Iterator;
import java.util.Set;

@Slf4j
public class ValidatorUtils {
    private static Validator validator = null;


    public static <T> void validate(T req) {
        if(!OpenimUtils.getOpenimConfig().isRequestParamValid()){
            return;
        }
        if (validator == null) {
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            validator = validatorFactory.getValidator();
        }
        Set<ConstraintViolation<T>> violationSet = validator.validate(req);
        if (!violationSet.isEmpty()) {
            Iterator<ConstraintViolation<T>> iterator = violationSet.iterator();
            ValidationException errorExp = null;
            while (iterator.hasNext()) {
                ConstraintViolation<T> exp = iterator.next();
                errorExp = new ValidationException(exp.getRootBeanClass().getSimpleName() + "." + exp.getPropertyPath() + ":" + exp.getMessage());
                log.warn("----validate--field={} msg={}", exp.getRootBeanClass().getSimpleName() + "." + exp.getPropertyPath(), exp.getMessage());
            }

            throw errorExp;
        }
    }
}
