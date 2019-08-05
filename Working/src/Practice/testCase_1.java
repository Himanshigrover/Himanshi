// Test case: Verify item in mobile list page can be sorted by name

/*Test steps: 		1. go to http://live.guru99.com/index.php/
			  		2. Verify the title of the page 
			  		3. Click on 'MOBILE' Menu
              		4. Verify Title of the page
              		5. In the list of all mobile, select "SORT BY'drop down as name.
              		6. Verify All the products are sorted by Name.
              	
 Expected Results:
 					1. Text"THIS IS DEMO SITE" showed in home page.
					2. Text"Mobile Site" shown on mobile list page
					3. All 3 products sorted by name
*/

package Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.io.Files;

public class testCase_1 {

	public static void main(String[] args) {
		String titleOfHomePage;

		System.setProperty("webdriver.chrome.driver", ".//src//exe//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.guru99.com/index.php/");
		titleOfHomePage = driver.getTitle();

		System.out.println("Title of Page = " + titleOfHomePage);
		try {
			Assert.assertEquals(titleOfHomePage, "THIS IS DEMO SITE",
					"title of home page is not as per the provided test data, Actual title is" + titleOfHomePage);
		} catch (Error e) {
			System.out.println(e);
		}

		WebElement element = driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a"));
		element.click();

		String mobileListPageTitle = driver.getTitle();
		System.out.println("Title of mobile listing Page = " + mobileListPageTitle);
		try {

			Assert.assertEquals(mobileListPageTitle, "Mobile Site",
					"title of home page is not as per the provided test data, Actual title is =" + mobileListPageTitle);
		} catch (Error e) {
			System.out.println(e);
		}
		WebElement Xpath = driver.findElement(
				By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
		WebElement Xpath1 = driver.findElement(By.xpath(
				"//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]"));
		Actions action = new Actions(driver);
		action.click(Xpath).perform();
		Xpath1.click();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			// //method
			Files.copy(src, new File("D:/Error/error.png"));
			System.out.println(" Saved the screenshots");
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

	}

	}

