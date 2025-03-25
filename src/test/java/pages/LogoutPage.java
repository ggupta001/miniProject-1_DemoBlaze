package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificMethod;

public class LogoutPage extends ProjectSpecificMethod{

	public LogoutPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	@FindBy(id="login2")
	WebElement login;
	
	public void logout() {
		logout.click();
	}
	
	public void seeLoginMsg() {
		String loginTab=login.getText();
		Assert.assertTrue(loginTab.contains("Log in"));
	}
}
