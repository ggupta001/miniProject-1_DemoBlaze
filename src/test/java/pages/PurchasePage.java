package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class PurchasePage extends ProjectSpecificMethod {

	public PurchasePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrderBtn;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement expMonth;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	WebElement purchaseBtn;
	
	@FindBy(xpath="(//h2)[3]")
	WebElement successmsg;
 
	public void placeOrderButton() {
		placeOrderBtn.click();
	}
	
	public void enterName(String Name) {
		name.sendKeys(Name);
	}
	public void enterCountry(String Country) {
		country.sendKeys(Country);
	}
	public void enterCity(String City) {
		city.sendKeys(City);
	}
	
	public void enterCard(String Card) {
		card.sendKeys(Card);
	}
	public void enterMonth(String month) {
		expMonth.sendKeys(month);
	}
	public void enterYear(String Year) {
		year.sendKeys(Year);
	}
	public void purchaseButton() {
		purchaseBtn.click();
	}
	public String seeSuccessMsg() {
		return successmsg.getText();
	}
}
