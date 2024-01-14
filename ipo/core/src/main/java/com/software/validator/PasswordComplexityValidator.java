/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 23-12-2023
 *
 *****************************************************/
package com.software.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.software.annotation.PasswordComplexity;

public class PasswordComplexityValidator implements ConstraintValidator<PasswordComplexity, String> {

    private Pattern pattern;

    /**
     * The password must fulfill the following requirements: <br>
     * - at least 8 characters <br>
     * - at least 1 small letter <br>
     * - at least 1 capital letter <br>
     * - at least 1 digit <br>
     * - at least one special character (^°!"§$%&/()=?`´\}][{+*~#'-.,;:_<>|)
     */
    public static final String COMPLEXITY = "(((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\^°!§$%&/()='\\\\*}\\+~#\\.,;:_<>])).{8,128})";


    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        return pattern.matcher(password).matches();
    }


    @Override
    public void initialize(final PasswordComplexity constraintAnnotation) {
        pattern = Pattern.compile(COMPLEXITY);
    }

}