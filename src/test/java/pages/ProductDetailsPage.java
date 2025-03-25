package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class ProductDetailsPage extends ProjectSpecificMethod{

	public ProductDetailsPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//div[@id='tbodyid']/div//h4/a")
	List<WebElement> products;
	
	@FindBy(css="h3.price-container")
	WebElement afterClickProductPrice;
	
	@FindBy(xpath="//div[@id='more-information']/p")
	WebElement afterClickproductDescription;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement cartBtn;
	
	@FindBy(id="cartur")
	WebElement cartTab;
	
	@FindBy(xpath="//tbody[@id='tbodyid']/tr")
	List<WebElement> productCountList;
	
	
	public ProductDetailsPage selectProduct(String productToBeAdd) {
		List<WebElement> myProducts= products;
		try{
			for(WebElement myProduct:myProducts) {
			if(myProduct.getText().contains(productToBeAdd)) {
				myProduct.click();
				System.out.println(myProduct.getText());
			}
		}} catch(Exception e) {
			myProducts= products;
		}
		return this;

	}
	public int  AfterProductPrice() throws InterruptedException {
		 String Aprice = afterClickProductPrice.getText();
			Thread.sleep(1000);
		 String Apricewithout$ = Aprice.replace("$", "");
		 String Apricewithoutstring = Apricewithout$.replace(" *includes tax", "");
		 int Aprice_int = Integer.parseInt(Apricewithoutstring);
		 System.out.println(Aprice_int);
		 return Aprice_int;
	}
	public String getAfterProductDescription() {
		String afterProductdesc=afterClickproductDescription.getText();
		return afterProductdesc;
	}
	
	public ProductDetailsPage addProductOnCart(int count) throws InterruptedException {
		for(int i=1;i<=count;i++) {
			cartBtn.click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(500);
		}
		return this;
	}
	public ProductDetailsPage clickOnCartTab() {
		cartTab.click();
		return this;
	}
	
	public int productListCount() throws InterruptedException {
		List<WebElement> productList=productCountList;
		Thread.sleep(2000);
		int count=productList.size();
		return count;
	}
	
	
}
