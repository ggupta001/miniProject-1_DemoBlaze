package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;
import pages.LogoutPage;

public class TS007_LogoutTest extends ProjectSpecificMethod{

	public TS007_LogoutTest() throws IOException {
		super();
	}
	LoginPage loginpg;
	LogoutPage logoutpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	@Test
	public void validateLogoutFunctionality() throws IOException, InterruptedException {
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(2000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		logoutpg=new LogoutPage(driver);
		Thread.sleep(2000);
		logoutpg.logout();
		Thread.sleep(500);
		logoutpg.seeLoginMsg();
	}
}
