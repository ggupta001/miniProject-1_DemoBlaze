package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.CartFunctionalityPage;
import pages.LoginPage;

public class TS005_CartFunctionalityTest extends ProjectSpecificMethod{

	public TS005_CartFunctionalityTest() throws IOException {
		super();
		
	}
	LoginPage loginpg;
	CartFunctionalityPage cartpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	@Test
	public void validateCartFunctionality() throws IOException, InterruptedException {
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(2000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		cartpg=new CartFunctionalityPage(driver);
		Thread.sleep(2000);
		cartpg.clickOncart();
		cartpg.deleteProductsFromCart();
	}
	
	
}
