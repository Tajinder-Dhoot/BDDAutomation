package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.Instanciate;

public class OfferPageSteps {
	
	Instanciate instanciate;
	String productNameInOffersPage;
	
	public OfferPageSteps(Instanciate instanciate) {
		
		this.instanciate = instanciate;
	}
	
	public void switchToOffersPage() throws InterruptedException {
		
		if(!instanciate.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			
			Thread.sleep(1000);
			instanciate.driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();
			Thread.sleep(1000);
			Set<String> windowhandles =instanciate.driver.getWindowHandles();
			Iterator<String> i1 = windowhandles.iterator();
			String parentWindow = i1.next();
			String childWindow = i1.next();
			instanciate.driver.switchTo().window(childWindow);
			Thread.sleep(2000);
		}
	}
	
	@Then("user search short name in offers page")
	public void user_search_short_name_in_offers_page_and_verify_product_exists() throws InterruptedException {

		switchToOffersPage();
		instanciate.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("pot");
		Thread.sleep(1000);
		List<WebElement> productNamesList = instanciate.driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		for(int i = 0; i < productNamesList.size(); i++) {

			if(productNamesList.get(i).getText().trim().equalsIgnoreCase(instanciate.productNameInLandingPage)) {
				productNameInOffersPage = productNamesList.get(i).getText().trim();
			}
		}
	}
	
	@Then("Verify product exists in the list on the offers page")
	public void verify_product_exists_in_the_list_on_the_offers_page() throws InterruptedException {

		Thread.sleep(1000);
		assertEquals(instanciate.productNameInLandingPage, productNameInOffersPage);
	}

}
