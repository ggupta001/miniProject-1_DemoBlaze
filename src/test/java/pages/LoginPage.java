package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class LoginPage extends ProjectSpecificMethod{

	public LoginPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement userName;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginBtn;
	
	public LoginPage clickOnLoginTab() {
		boolean loginvisible=login.isDisplayed();
		Assert.assertTrue(loginvisible);
		boolean loginclickable=login.isEnabled();
		Assert.assertTrue(loginclickable);
		login.click();
		return this;
	}
	public DashboardPage clickOnLogin(String Lname, String Lpwd) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		userName.clear();
		userName.sendKeys(Lname);
		password.clear();
		password.sendKeys(Lpwd);
		loginBtn.click();
		return new DashboardPage(driver);
	}
}
