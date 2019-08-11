package MyGuru99.work;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

//Open Browser and Navigate to the URL


public class openBrowser {
	WebDriver driver;
	String titleOfHomePage;

	@BeforeClass
	public void openBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://live.guru99.com/index.php/");
		// Verify the title of Landing page
		titleOfHomePage = driver.getTitle();

		System.out.println("Title of Page = " + titleOfHomePage);
		try {
			Assert.assertEquals(titleOfHomePage, "THIS IS DEMO SITE",
					"title of home page is not as per the provided test data, Actual title is" + titleOfHomePage);
		} catch (Error e) {
			System.out.println(e);
		}
		Thread.sleep(3000);
	}

	// Close browser after all the functions are performed.

	@AfterClass
	public void closeBrowser() {

	}

}
