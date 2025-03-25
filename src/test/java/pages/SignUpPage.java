package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;
import junit.framework.Assert;

public class SignUpPage extends ProjectSpecificMethod {

	public SignUpPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(id="signin2")
	WebElement signUp;
	
	@FindBy(id="sign-username")
	WebElement userName;
	
	@FindBy(id="sign-password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signUpBtn;
	
	public LoginPage signUp(String uName, String pwd) throws InterruptedException, IOException {
		boolean signupvisible=signUp.isDisplayed();
		Assert.assertTrue(signupvisible);
		boolean signupclickable=signUp.isEnabled();
		Assert.assertTrue(signupclickable);
		signUp.click();
		userName.clear();
		userName.sendKeys(uName);
		password.clear();
		password.sendKeys(pwd);
		signUpBtn.click();
		Thread.sleep(2000);
		String signUpMsg=driver.switchTo().alert().getText();
		Assert.assertEquals("This user already exist.", signUpMsg);
		driver.switchTo().alert().accept();
		return new LoginPage(driver);
	}
	
}
