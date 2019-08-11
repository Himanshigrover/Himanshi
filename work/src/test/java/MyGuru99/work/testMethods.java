package MyGuru99.work;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class testMethods extends openBrowser  {
	
	@Test
	public void testMethods() throws InterruptedException{
		testCase_01 test_01 = new testCase_01(driver);
		test_01.Run01();

	}
}
