package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Instanciate;

public class LandingPageSteps {
	
	public WebDriver driver;
	String productNameInOffersPage = "";
	Instanciate instanciate;
	
	public LandingPageSteps(Instanciate instanciate) {
		
		this.instanciate = instanciate;
	}
	
	@Given("user is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SINGH\\Downloads\\chromedriver.exe");
		instanciate.driver = new ChromeDriver();
		instanciate.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		instanciate.driver.manage().window().maximize();
	}
	
	@When("User search product shortname {string} in home page search bar and extracts actual name of product")
	public void user_search_product_shortname_in_home_page_search_bar_and_extracts_actual_name_of_product(String prod) throws InterruptedException {

		Thread.sleep(1000);
		instanciate.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(prod);
		Thread.sleep(1000);
		instanciate.productNameInLandingPage = instanciate.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().trim().split("-")[0].trim();
	}
}
