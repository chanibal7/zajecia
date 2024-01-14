/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 23-12-2023
 *
 *****************************************************/
package com.software.dto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.software.validator.PasswordComplexityValidator;

public class UserResetPasswordDtoTest {

    @Test
    public void negativeNoSpecialCharTest() {
        // given
        final String s = "Sunday1";
        //when then
        assertFalse(s.matches(PasswordComplexityValidator.COMPLEXITY));
    }

    @Test
    public void negativeTooSmallTest() {
        // given
        final String s = "";
        //when then
        assertFalse(s.matches(PasswordComplexityValidator.COMPLEXITY));
    }

    @Test
    public void positiveTest() {
        // given
        final String s = "Sunday1!";
        //when then
        assertTrue(s.matches(PasswordComplexityValidator.COMPLEXITY));
    }

    @Test
    public void positive2Test() {
        // given
        final String s = "iL1keGIZ*";
        //when then
        assertTrue(s.matches(PasswordComplexityValidator.COMPLEXITY));
    }

    @Test
    public void positive3Test() {
        // given
        final String s = "iL1keGIZ+";
        //when then
        assertTrue(s.matches(PasswordComplexityValidator.COMPLEXITY));
    }
}
