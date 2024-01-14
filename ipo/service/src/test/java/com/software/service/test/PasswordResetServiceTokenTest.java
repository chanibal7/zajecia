package com.software.service.test;
//
//package com.software.service.test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.software.domain.ResetPasswordToken;
//import com.software.service.TokenServiceImpl;
//import com.software.service.UserServiceImpl;
//import com.software.service.email.PasswordResetService;
//
///**
// * Test class for service
// * {@link com.software.service.email.PasswordResetService
// * passwordResetService}
// *
// */
//@RunWith(MockitoJUnitRunner.class)
//public class PasswordResetServiceTokenTest {
//
//	@Mock
//	UserServiceImpl userService;
//
//	@Mock
//	TokenServiceImpl tokenService;
//
//	@InjectMocks
//	PasswordResetService passwordResetService = new PasswordResetService();
//
//	@Test
//	public void sendResetPasswordEmail() {
//
//		// given
//		ResetPasswordToken token = new ResetPasswordToken();
//		ResetPasswordToken token2 = new ResetPasswordToken();
//		Mockito.when(this.tokenService.createToken("oki")).thenReturn(token2);
//		// when;
//		Mockito.when(this.tokenService.findToken("oki")).thenReturn(token);
//		// then
//		assertNotNull(token);
//		assertNotNull(token2);
//	}
//
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
//}
