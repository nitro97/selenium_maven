package mav_sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
@BeforeClass
public void reportgen() {
		  report = new ExtentReports("C:\\Users\\Training_b4a.01.18\\eclipse-workspace\\reports\\rep.html");
		  test = report.startTest("Demo_rep");
	  }
@BeforeMethod
public void beforeMethod() {
	  test.log(LogStatus.INFO,"Webdriver init");
	  System.setProperty("webdriver.chrome.driver", "C:\\ash20\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
}
  @Test(dataProvider = "dp")
  public void logintest(String n, String s) {
	  test.log(LogStatus.INFO, "Enter URL");
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("userName")).sendKeys(n);
	  driver.findElement(By.id("password")).sendKeys(s);
	  driver.findElement(By.name("Login")).click();
	  test.log(LogStatus.PASS, "passed");
  }


  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Lalitha", "password123" },
      new Object[] { "lalitha", "password123" },
    };
  }
  

  @AfterClass
  public void afterClass() {
	  report.endTest(test);
	  report.flush();
  }

}
