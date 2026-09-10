package com.xworkz.Quick.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationUtil {
    private static final ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();

    private static Validator validator=validatorFactory.getValidator();

    public static Validator getValidator()
    {
        return validator;
    }

}
