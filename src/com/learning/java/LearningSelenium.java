package com.learning.java;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LearningSelenium {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		OpenBrowser();
		WebPageLaunch();
		Signup();
		//System.out.println("Signup Successful");
		
		Signin();
		CloseBrowser();
		Shopping();
		Logout();
		
}
	
	
	
private static void Shopping() throws InterruptedException {
		// TODO Auto-generated method stub
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
	driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.MILLISECONDS);
	//driver.findElement(By.cssSelector("a[href*='http://automationpractice.com/index.php?id_category=5&controller=category']")).click();
	driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();
	
	WebElement link = driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
	//System.out.println("Above mousehover is been performed");
	Actions builder = new Actions(driver);
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
	driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.MILLISECONDS);
	
	System.out.println("Above mousehover is been performed 1");
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
    builder.moveToElement(link).build().perform();
    //builder.moveToElement(link, 13655, 655).build().perform();
    
    System.out.println("Above mousehover is been performed");
	
    
    driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")).click();
    
    System.out.println("Added to cart now we need to checkout");
	
    driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.MILLISECONDS);
	Thread.sleep(2000);
	
	try {
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    Assert.assertTrue(alert.getText().contains("Thanks."));
	} catch (Exception e) {
	    //exception handling
	}
	
    driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
    System.out.println("Proceede to checkout");    
    //JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	//jse.executeScript("window.scrollBy(0,900)", "");
	
    //driver.findElement(By.className("cross")).click();
	driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span")).click();
	driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button")).click();
	driver.findElement(By.xpath(".//*[@id='cgv']")).click();
	driver.findElement(By.xpath(".//*[@id='form']/p/button")).click();
	driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
	driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
	driver.findElement(By.xpath(".//*[@id='header_logo']/a/img")).click();
	
    
    
    
    
}


private static void Logout() {
		// TODO Auto-generated method stub
	System.out.println("LogOut");
	driver.findElement(By.className("logout")).click();
	}


private static void Signin() {
		// TODO Auto-generated method stub
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email")).sendKeys("harit.narke345@yahoo.com");
	driver.findElement(By.id("passwd")).sendKeys("12345");
	driver.findElement(By.id("SubmitLogin")).click();
	
	}


//Open Firefoxbrowser successfuly	
	
	private static void OpenBrowser() {
		
			System.setProperty("webdriver.gecko.driver","C:\\Users\\madhav\\Documents\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			System.out.println("All Cookies deleted");
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.MILLISECONDS);
			//driver.manage().window().maximize();
			//System.out.println("Windoe size Maximized");
			System.out.println("Chrome Browser Launched");
					
		}
	
//Locate the elements and search successfuly
	private static void WebPageLaunch() {
		
		driver.navigate().to("http://www.automationpractice.com/");
		System.out.println("Page Launched");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.className("login")).click();
		}

     private static void Signup() {
    	 	driver.findElement(By.id("email_create")).sendKeys("harit.narke345@yahoo.com");
    	 	driver.findElement(By.id("SubmitCreate")).click();
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
			driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);
			driver.findElement(By.xpath("//input[@name='id_gender' and @type='radio' and @id='id_gender1']")).click();
			driver.findElement(By.id("customer_firstname")).sendKeys("Harit");
			driver.findElement(By.id("customer_lastname")).sendKeys("Narke");
			driver.findElement(By.id("passwd")).sendKeys("12345");
			
			
			Select Days= new Select(driver.findElement(By.id("days")));
			Days.selectByValue("24");
			
			Select Months= new Select(driver.findElement(By.id("months")));
			Months.selectByValue("6");
			
			Select Years= new Select(driver.findElement(By.id("years")));
			Years.selectByValue("1990");
			
			driver.findElement(By.xpath("//input[@id='newsletter']")).click();
			driver.findElement(By.xpath("//input[@id='optin']")).click();
			driver.findElement(By.id("company")).sendKeys("Capgemini");
			driver.findElement(By.id("address1")).sendKeys("Pune 411060");
			driver.findElement(By.id("address2")).sendKeys("India");
			driver.findElement(By.id("city")).sendKeys("New York");
			
			Select id_state= new Select(driver.findElement(By.id("id_state")));
			id_state.selectByValue("2");
			
			driver.findElement(By.id("postcode")).sendKeys("00000");
			
			Select id_country= new Select(driver.findElement(By.id("id_country")));
			id_country.selectByValue("21");

			driver.findElement(By.id("other")).sendKeys("@@@@@@@");
			driver.findElement(By.id("phone_mobile")).sendKeys("8983007300");
			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys("Home");
			driver.findElement(By.id("submitAccount")).click();
			
			
     }
     
//Close the Browser
	private static void CloseBrowser() {
		// TODO Auto-generated method stub
		System.out.println("Waiting for Browser to close");
		driver.quit();
		System.out.println("Browser Closed Successfuly");
	}
	
	
}



