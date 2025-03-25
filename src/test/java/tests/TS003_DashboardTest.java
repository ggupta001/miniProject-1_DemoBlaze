package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.DashboardPage;
import pages.LoginPage;

public class TS003_DashboardTest extends ProjectSpecificMethod {

	public TS003_DashboardTest() throws IOException {
		super();
	}
	
	LoginPage loginpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	DashboardPage dashboardpg;
	
	@Test
	public void seeWelcomeUserMessage() throws IOException, InterruptedException {
		Thread.sleep(2000);
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		Thread.sleep(500);
		dashboardpg=new DashboardPage(driver);
		Thread.sleep(500);
		dashboardpg.welcomeMessage(LoginUserName);	
		Thread.sleep(500);
		dashboardpg.allMenuesList();
		Thread.sleep(500);
		dashboardpg.allCategoriesList();	
	}

}
