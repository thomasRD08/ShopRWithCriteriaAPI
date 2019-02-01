package com.realdolmen.backend.constraint;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UniqueUserValidatorTest {

    private Validator validator;

    @BeforeClass
    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


}