package jenkinsDemo1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class JenkinsDemo1Test {
	WebDriver driver;
  @Test
  public void search() {
	  driver.findElement(By.name("q")).sendKeys("manipal");
	  System.out.println(driver.getTitle());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
