package jenkinsDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class JenkinsDemo1Test {
	WebDriver driver;
  @Test
  public void search() throws InterruptedException {
	  //driver.findElement(By.name("q")).sendKeys("manipal");
	  //System.out.println(driver.getTitle());
	  
	  System.out.println(System.getProperty("user.dir"));
		
		Properties prop = new Properties();
		    //load a properties file from class path, inside static method
		    //prop.load(Defects_4Template.class.getClassLoader().getResourceAsStream("c:\\Config\\config.properties"));
			try {
				prop.load(new FileInputStream("C:\\Config\\configdm1.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String path = prop.getProperty("path");
			//System.out.println(path);

			try {
				prop.load(new FileInputStream(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		    String att_uid = prop.getProperty("att_uid");
		    String tdp_pwd = prop.getProperty("tdp_pwd");
		    //String att_pwd = prop.getProperty("att_pwd");
		    String tdp_url = prop.getProperty("tdp_url");
		    //String ms_url = prop.getProperty("ms_url");
		    String query_unique_word = prop.getProperty("query_unique_word");
		    //String ms_unique_word = prop.getProperty("ms_unique_word");
		    
		    System.setProperty("webdriver.gecko.driver", "C:\\Users\\ms130k\\Desktop\\Selenium_ITO\\geckodriver.exe");
			
		    ProfilesIni profile = new ProfilesIni();

		    FirefoxOptions options = new FirefoxOptions();
		    options.setProfile(profile.getProfile("Automation28June2020"));

		    WebDriver driver = new FirefoxDriver(options);
		    
		    
		    //WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(tdp_url);
			//10
			//Thread.sleep(20000L);
			//Thread.sleep(8000L);
			driver.findElement(By.xpath("//*[@id=\'jazz_app_internal_LoginWidget_0_userId\']")).sendKeys(att_uid);
			driver.findElement(By.xpath("//*[@id=\'jazz_app_internal_LoginWidget_0_password\']")).sendKeys(tdp_pwd);
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/form/button")).click();
			//driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[1]/div/div[1]/div/a[2]/span[2]")).click();
			//driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div[1]/div/div[1]/div/a[2]/span[1]"));
			//- worked
			driver.findElement(By.xpath("//*[@id=\"jazz_ui_MenuPopup_3\"]")).click(); 
			//11
			//Thread.sleep(3000L);
			driver.findElement(By.xpath("//*[@id=\"jazz_ui_menu_MenuItem_1_text\"]")).click();
			//12
			//Explicit Wait
			//WebDriverWait u = new WebDriverWait(driver,20);
			//u.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(query_unique_word)));
			Thread.sleep(6000L);
			//By partialLinkText
			driver.findElement(By.partialLinkText(query_unique_word)).click();
			//13
			//Explicit Wait
			//WebDriverWait v = new WebDriverWait(driver,20);
			//v.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/table/tbody/tr[1]/td[2]/div[2]/div/div[1]/div[3]/div/div[2]/div/div[1]/div/div[1]/span[3]/div/span[4]/a/img")));
			Thread.sleep(5000L);
			driver.findElement(By.xpath("/html/body/div[1]/div/table/tbody/tr[1]/td[2]/div[2]/div/div[1]/div[3]/div/div[2]/div/div[1]/div/div[1]/span[3]/div/span[4]/a/img")).click();
			Thread.sleep(3000L);
			driver.quit();

  }
  
  

 
  }


/*
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
*/