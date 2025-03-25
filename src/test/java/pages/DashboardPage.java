package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class DashboardPage  extends ProjectSpecificMethod{

	public DashboardPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(id="nameofuser")
	WebElement welcomeMsg;
	
	@FindBy(xpath="//div[@id='navbarExample']/ul/li/a")
	List<WebElement> allMenues;
	
	@FindBy(xpath="//div[@class='list-group' ]/a[@href='#']")
	List<WebElement> allCategories;
	
	@FindBy(id="nava")
	WebElement logo;
	
	public DashboardPage welcomeMessage(String msg) throws InterruptedException {
		Thread.sleep(3000);
		String message=welcomeMsg.getText();
		Assert.assertEquals("Welcome " + msg, message);
		return this;
	}
	public DashboardPage allMenuesList() {
		List<WebElement> menues=allMenues;
		for(WebElement menu:menues) {
			menu.isDisplayed();
			System.out.println(menu.getText());
		}
		return this;
	}
	public DashboardPage allCategoriesList() {
		List<WebElement> categories=allCategories;
		for(WebElement category:categories) {
			category.isDisplayed();
			System.out.println(category.getText());
		}
		return this;
	}
	public DashboardPage seeLogo() {
		boolean logoimg=logo.isDisplayed();
		Assert.assertTrue(logoimg);
		return this;
	}
}
