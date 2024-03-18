package amazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Pavithra\\Downloads\\Selenium Main\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Test begin");

		// Search Product in textbox
		WebElement homepageSearch = driver.findElement(By.id("twotabsearchtextbox"));
		homepageSearch.sendKeys("Toys" + Keys.ENTER);

		// Delivery day
		WebElement deliveryDay = driver.findElement(By.xpath("//li[@id='p_90/6741118031']/span/a/div/label/i"));
		deliveryDay.click();

		// Category
		WebElement category = driver.findElement(By.xpath("//li[@id='n/1378445031']/span/a"));
		category.click();

		// Min Max Price
		WebElement minPrice = driver.findElement(By.id("low-price"));
		minPrice.sendKeys("100");
		WebElement maxPrice = driver.findElement(By.id("high-price"));
		maxPrice.sendKeys("500");
		WebElement submitButton = driver.findElement(By.className("a-button-input"));
		submitButton.click();

		// Click any Product
		WebElement product = driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div[3]/div[1]/h2/a"));
		product.click();

		// Window Handles - Product details [one window to another window]
		Set<String> allWindows = driver.getWindowHandles(); // all opened windows details are here
		Iterator<String> iteratorWindow = allWindows.iterator(); // it iterates each windows
		String allProductsWindow = iteratorWindow.next();
		String ProductWindow = iteratorWindow.next();
		
		//Switch to Child window
		driver.switchTo().window(ProductWindow);

		// Product Quantity -
		WebElement quantity = driver.findElement(By.id("quantity"));
		Select selectQuantity = new Select(quantity);
		selectQuantity.selectByValue("2");

		// Add to cart WebElement addToCart =
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();

		// Go to cart
		WebElement goToCart = driver.findElement(By.linkText("Go to Cart"));
		goToCart.click();

		// To delete the product
		/*
		 * WebElement deleteProduct =
		 * driver.findElement(By.xpath("//input[@value='Delete']"));
		 * deleteProduct.click();
		 */

		/*
		 * // To save the product WebElement saveLater =
		 * driver.findElement(By.xpath("//input[@value='Save for later']"));
		 * saveLater.click();
		 */

		/*
		 * //See more like this WebElement seeMoreLikeThis =
		 * driver.findElement(By.xpath("//input[@value='See more like this']"));
		 * seeMoreLikeThis.click();
		 */

		/*
		 * // Share product WebElement shareProduct =
		 * driver.findElement(By.xpath("//a[@title='Share']")); shareProduct.click();
		 */

		// Procced to buy
		WebElement proceedToBuy = driver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
		proceedToBuy.click();

		// Close Product Window[Child window]
		driver.close();

		//Switch to Parent Window
		driver.switchTo().window(allProductsWindow);

		driver.quit();
	}

}
