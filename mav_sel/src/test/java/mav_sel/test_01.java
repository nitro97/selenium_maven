package mav_sel;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_01 {



	

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\ash20\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
			WebElement sb = driver.findElement(By.id("userName"));
			sb.sendKeys("Lalitha");
			WebElement sb1 = driver.findElement(By.id("password"));
			sb1.sendKeys("Password123");
			WebElement sb2 = driver.findElement(By.name("Login"));
			sb2.click();
			//TimeUnit.SECONDS.sleep(5);		
	        driver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);
	        WebElement sb3 = driver.findElement(By.xpath("//a[text()=' SignOut']"));        
			if(driver.getTitle().equals("Home")) {			
				sb3.click();
			}
			else {			
			driver.close();
			}
			driver.close();

		}

	}



