package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethod;

public class CartFunctionalityPage extends ProjectSpecificMethod {

	public CartFunctionalityPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath="//tbody[@id='tbodyid']/tr/td/following-sibling::td[3]/a")
	List<WebElement> deleteProduct;
	
	@FindBy(id="cartur")
	WebElement cartTab;
	
	public void clickOncart() {
		cartTab.click();
	}
	public void deleteProductsFromCart() {
		List<WebElement> deletecount=deleteProduct;
		try{
			for(WebElement delete:deletecount) {
			delete.click();
		}
		} catch(Exception e) {
			deletecount=deleteProduct;
		}
		
	}
}
