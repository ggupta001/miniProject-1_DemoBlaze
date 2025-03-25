package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.LoginPage;


public class TS002_LoginTest extends ProjectSpecificMethod{

	public TS002_LoginTest() throws IOException {
		super();
	}
	LoginPage loginpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");

	
	@Test
	public void LoginToDemoBlaze() throws IOException {
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		
	}
}
