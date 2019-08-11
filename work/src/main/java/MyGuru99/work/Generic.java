package MyGuru99.work;

import org.openqa.selenium.WebDriver;

public class Generic {

	
		public static String VerifyTitle(String Expected)
		{
			WebDriver driver = null;
			String actual = driver.getTitle();
			if(actual.equals(Expected))
			{
				return "Title of the page matches the expected, Title =" + actual;
			}
			return " Actual title is:" + actual +" Expected is : "+ Expected;
			
		}
	}


