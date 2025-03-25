package tests;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductDetailsPage;

public class TS004_ProductDetailsTest extends ProjectSpecificMethod {

	public TS004_ProductDetailsTest() throws IOException {
		super();
		
	}
	LoginPage loginpg;
	ProductDetailsPage productdetailspg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	String searchProduct=configProperties.getProperty("product-to-be-search");
	String productCount=configProperties.getProperty("product-count");
	int productcount = Integer.parseInt(productCount);
	@Test
	public void checkProductDetails() throws IOException, InterruptedException {

		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(2000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		productdetailspg=new ProductDetailsPage(driver);
		Thread.sleep(5000);
		productdetailspg.selectProduct(searchProduct);
		Thread.sleep(5000);
		int ProductPrice=productdetailspg.AfterProductPrice();
		Thread.sleep(2000);
		System.out.println(ProductPrice);
		String Description=productdetailspg.getAfterProductDescription();
		Thread.sleep(2000);
		Assert.assertTrue(Description.contains(searchProduct));
		Thread.sleep(1000);
		productdetailspg.addProductOnCart(productcount);
		Thread.sleep(1000);
		productdetailspg.clickOnCartTab();
		int productList=productdetailspg.productListCount();
		Assert.assertEquals(productList, productcount);
		
	}
}
