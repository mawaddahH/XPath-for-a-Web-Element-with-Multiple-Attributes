package ass3XPathMultipleAttribute;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromWebDriver {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeTest
	public void setUp() {
		// the path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to a WebSite
		driver.navigate().to("https://learnenglish.britishcouncil.org/user/register");

		// Maximize current window
		driver.manage().window().maximize();
	}

	/**
	 * Test to check Surname field
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {

		// wait until the pop-up modal window appears.
		// references :
		// https://stackoverflow.com/questions/17465136/selenium-webdriver-how-to-close-the-first-pop-up-window-and-go-to-the-actual-p
		// https://stackoverflow.com/questions/45183797/element-not-interactable-exception-in-selenium-web-automation
		// https://stackoverflow.com/questions/71761074/the-constructor-webdriverwaitchromedriver-int-is-undefined
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")));

		// Delay execution for 3 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

		// close the pop-up modal window
		driver.findElement(By.xpath("//span[@class='custom-page-popup-modal-close spb_close']")).click();

		// Delay execution for 3 seconds
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(3000);

		// Define the web element to find it,
		// using the XPath method (multiple attributes)
		WebElement relativeXPathMethod = driver.findElement(By.
				xpath("//input[@name='field_profile_surname[0][value]'][@id='edit-field-profile-surname-0-value']"));
		
		// Enter word on web element
		relativeXPathMethod.sendKeys("Hanbali");

		// Delay execution for 5 seconds after find specific web element
		// I used it to I can see the result carefully and for a screenshot.
		Thread.sleep(5000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.quit();
	}

}
