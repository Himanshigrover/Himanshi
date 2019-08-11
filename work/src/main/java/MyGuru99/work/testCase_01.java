package MyGuru99.work;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/*Test steps: 		1. go to http://live.guru99.com/index.php/: OpenBrowser Class
	2. Verify the title of the page : OpenBrowser Class  
	3. Click on 'MOBILE' Menu 
	4. Verify Title of the page
	5. In the list of all mobile, select "SORT BY'drop down as name.
	6. Verify All the products are sorted by Name.

Expected Results:
	1. Text"THIS IS DEMO SITE" showed in home page.
2. Text"Mobile Site" shown on mobile list page
3. All 3 products sorted by name
*/

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class testCase_01 extends Generic   {
	
	@FindBy(xpath = ".//*[@id='nav']/ol/li[1]/a")
	private WebElement mobileMenu;
	@FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	private WebElement SortBy;
	@FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")
	private WebElement SortByName;

	
	public testCase_01(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Run01() throws InterruptedException {
		mobileMenu.click();
		Generic.VerifyTitle("Mobile Site");
	
		//WebDriver driver = null;
		/*String mobileListPageTitle = driver.getTitle();
		System.out.println("Title of mobile listing Page = " + mobileListPageTitle);
		try {

			Assert.assertEquals(mobileListPageTitle, "Mobile Site",
					"title of home page is not as per the provided test data, Actual title is =" + mobileListPageTitle);
		} catch (Error e) {
			System.out.println(e);
		}
		Reporter.log("Navigated to the mobile page and verified fot the page title", true);*/

		WebDriver driver = null;
		Actions action = new Actions(driver);
		action.click(SortBy).perform();
		SortByName.click();

		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			// //method
			Files.copy(src, new File("D:/Error/SortedByName.png"));
			System.out.println(" Saved the screenshots");
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
		Reporter.log("Verify All the products are sorted by Name and check for the screenshot", true);
	}

}
