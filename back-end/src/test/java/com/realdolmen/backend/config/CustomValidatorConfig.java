package com.realdolmen.backend.config;

import com.realdolmen.backend.constraint.UniqueUserValidator;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackageClasses = UniqueUserValidator.class)
public class CustomValidatorConfig {
}
