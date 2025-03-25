package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import pages.CartFunctionalityPage;
import pages.LoginPage;
import pages.PurchasePage;

public class TS006_PurchaseTest extends ProjectSpecificMethod{

	public TS006_PurchaseTest() throws IOException {
		super();
		
	}
	LoginPage loginpg;
	CartFunctionalityPage cartpg;
	PurchasePage purchasepg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	String name=configProperties.getProperty("name");
	String country=configProperties.getProperty("country");
	String city=configProperties.getProperty("city");
	String card=configProperties.getProperty("card");
	String month=configProperties.getProperty("month");
	String year=configProperties.getProperty("year");
	
	@Test
	public void purchaseFunctionality() throws IOException, InterruptedException {
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(2000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		cartpg=new CartFunctionalityPage(driver);
		Thread.sleep(2000);
		cartpg.clickOncart();
		purchasepg=new PurchasePage(driver);
		Thread.sleep(2000);
		purchasepg.placeOrderButton();
		Thread.sleep(500);
		purchasepg.enterName(name);
		Thread.sleep(500);
		purchasepg.enterCountry(country);
		Thread.sleep(500);
		purchasepg.enterCity(city);
		Thread.sleep(500);
		purchasepg.enterCard(card);
		Thread.sleep(500);
		purchasepg.enterMonth(month);
		Thread.sleep(500);
		purchasepg.enterYear(year);
		Thread.sleep(500);
		purchasepg.purchaseButton();
		Thread.sleep(500);
		String msg=purchasepg.seeSuccessMsg();
		Assert.assertTrue(msg.contains("Thank you for your purchase"));
	}
}
