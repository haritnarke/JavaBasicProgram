package com.learning.java;

//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Clarity {

	public static String driverPath = "C:\\\\Users\\\\madhav\\\\Documents\\\\Selenium\\";
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int rownum = 1;

	public static void main() {
		try {

			BrowserLaunch();
			ClarityLogin();
			Filter();
			ClickTimeSheet();
			// LogOut();
			QuitBrowser();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Main Method");
		}
	}

	/***********************************
	 * All Methods
	 * 
	 * @throws InterruptedException
	 *******************************************************/

	private static void QuitBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	private static void ClickTimeSheet() throws InterruptedException {
		// TODO Auto-generated method stub
		// Clicking on the first link in the time sheet

		try {
			System.out.println("Row count before clicking" + rownum);
			driver.findElement(By.xpath("//a [contains(@id,'manageTimesheet')]/img[1]")).click();
			String Str = driver
					.findElement(By.xpath("//table[contains(@class,'ppm_list_layout')]/thead/tr/th [@column='7']"))
					.getText();
			System.out.println(Str);

			if (Str.substring(0, 3).equals("Sat") || Str.substring(0, 3).equals("Sun")) {
				Thread.sleep(1000);
				JavascriptExecutor jsc = (JavascriptExecutor) driver;
				jsc.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//*[@name='page']/div[4]/button[3]")));
				System.out.println("Since the week is starting from Saturday hence moving to next week");
				// need to add row by default as 1 and once we exit this if loop need to
				// increment it
				rownum++;

			}

			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].click();", driver.findElement(
					By.xpath("//td[@class='tableContent' and @role='gridcell' and @row=" + rownum + "]/a/img[1]")));
			Thread.sleep(1000);

			System.out.println("Now we are going to add timesheet for this week");

			int tablerowCount = driver.findElements(By.xpath("//tr[@class='total']")).size();
			int tablecolumnCount = driver.findElements(By.xpath("//td[@class='tableContent']")).size();

			System.out.println("row count is " + tablerowCount + " and cloumn count is " + tablecolumnCount);

			// below method is used for "Add task" button
			if (tablerowCount < 2)

			{

				try {

					Adding_the_project();
					Fill_Timesheet();
					Thread.sleep(1000);
					Save_and_Submit_Timesheet();
					rownum--;
					ClickTimeSheet();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					ErrorHandling();
				}

			}

			// First deleting the added task than adding it again
			else

			{

				try {
					JavascriptExecutor jsc1 = (JavascriptExecutor) driver;

					Thread.sleep(1000);
					System.out.println("Already project task are available so we are going to delete all the task");
					Thread.sleep(1000);
					// below code is used to select all the task and then delete all
					jsc1.executeScript("arguments[0].click();",
							driver.findElement(By.xpath("//*[@class='ppm_gridcontent']/table/thead/tr/th[1]/input")));
					Thread.sleep(1000);
					jsc1.executeScript("arguments[0].click();",
							driver.findElement(By.xpath("//*[@name='page']/div[3]/div/button[3]")));
					Thread.sleep(1000);

					jsc1.executeScript("arguments[0].click();",
							driver.findElement(By.xpath("//div[@class='ppm_button_bar']/button[1]")));

					Thread.sleep(1000);

					System.out.println("task deleted successfully");
					Thread.sleep(1000);
					Adding_the_project();
					Fill_Timesheet();

					System.out.println("Time sheet has been filled and now we are going to save and submit");
					Thread.sleep(1000);
					Save_and_Submit_Timesheet();
					rownum--;
					ClickTimeSheet();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					ErrorHandling();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorHandling();
		}

	}

	private static void ErrorHandling() throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor jsc = (JavascriptExecutor) driver;

		jsc.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//*[@id='ppm_home_go']/img[@src='ui/uitk/images/s.gif']")));
		Thread.sleep(1000);
		LogOut();

	}

	private static void Filter() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://claritymobile.fs.capgemini.com/niku/nu#action:timeadmin.timesheetBrowserReturn");

		driver.findElement(By.xpath("//*[contains(text(), 'Show All')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select dropdown1 = new Select(driver.findElement(By.name("ff_status")));
		dropdown1.selectByValue("open");
		Thread.sleep(1000);

		// Filter applied for "Open"
		driver.findElement(By.xpath("//*[contains(text(), 'Filter')]")).click();
		System.out.println("Filter applied");

	}

	private static void ClarityLogin() {
		// TODO Auto-generated method stub
		driver.get("https://claritymobile.fs.capgemini.com/niku/nu#action:homeActionId");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("ppm_login_username")).sendKeys("hnarke");
		driver.findElement(By.id("ppm_login_password")).sendKeys("H@ri1712");
		driver.findElement(By.id("ppm_login_button")).click();

	}

	private static void BrowserLaunch() {
		// TODO Auto-generated method stub
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox", "--ignore-certificate-errors", "--homepage=about:blank", "--no-first-run",
				"chrome.switches", "--disable-extensions");
		options.addArguments("disable-infobars");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();

	}

	public static void Adding_the_project() throws InterruptedException {

		try {
			JavascriptExecutor jsc = (JavascriptExecutor) driver;

			jsc.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//div[@class='ppm_button_bar']/button[1]")));
			Thread.sleep(1000);

			jsc.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@title='QAPM_IWM_SS_18']")));

			Thread.sleep(1000);

			System.out.println("Check box selected for task name QAPM_IWM_SS_17");

			// jsc.executeScript("arguments[0].click();",
			// driver.findElement(By.xpath("//td[@class='tableContent']/input[@class='checkbox']")));
			jsc.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//img[@src='ui/uitk/images/s.gif'and @title='Add']")));

			Thread.sleep(1000);
			jsc.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//td[@class='tableContent']/input[@class='checkbox']")));
			// jsc.executeScript("arguments[0].click();",
			// driver.findElement(By.xpath("//td[@class='tableContent' and @row='2' and
			// @column='6']")));
			System.out.println("Check box selected for split");

			Thread.sleep(1000);
			jsc.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//img[@src='ui/uitk/images/s.gif' and @title='Split']")));

			Thread.sleep(1000);
			System.out.println("Splitting done");

			Thread.sleep(1000);
			Select dropdown1 = new Select(driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3' and @column='13']/table/tbody/tr/td/select[@name='timeentry_tc']")));
			dropdown1.selectByVisibleText("Non Billable");
			System.out.println("Non Billable option has been selected");

			// String =driver.findElements(By.xpath("")).getText();

			// String col_name=
			// driver.findElement(By.xpath("//div[@class='ppm_gridcontent']/table/thead/tr/th[8]")).getText();

			// td[@class='tableContent' and @row='2']/input[@type='text' and
			// @title[contains(.,'Tue')]]
			// td[@class='tableContent' and @row='3']/input[@type='text' and
			// @title[contains(.,'Tue')]]
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("There is some error in Adding Project Logic");
		}

	}

	public static void Save_and_Submit_Timesheet() throws InterruptedException {
		try {
			System.out.println("We are in save and submit method");
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].click();",
					driver.findElement(By.xpath("//*[@name='page']/div[4]/button[2]")));
			System.out.println("save and submit method executed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("save and submit method have some error");
		}
	}

	public static void Fill_Timesheet() throws InterruptedException {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(1000);
			int col_Count = driver.findElements(By.xpath("//div[@class='ppm_gridcontent']/table/thead/tr/th")).size();

			for (int i = 8; i <= col_Count; i++) {
				String col_name = driver
						.findElement(By.xpath("//div[@class='ppm_gridcontent']/table/thead/tr/th[" + i + "]"))
						.getText();
				Thread.sleep(1000);
				if (col_name.substring(0, 3).equals("Mon")) {

					Mon();
				}

				if (col_name.substring(0, 3).equals("Tue")) {

					Tue();
				}

				if (col_name.substring(0, 3).equals("Wed")) {

					Wed();
				}
				if (col_name.substring(0, 3).equals("Thu")) {

					Thu();
				}
				if (col_name.substring(0, 3).equals("Fri")) {

					Fri();
				}

			}

			// jsc.executeScript("arguments[0].value=1;",
			// driver.findElement(By.xpath("//td[@class='tableContent' and
			// @row='3']/input[@type='text' and @title[contains(.,'Thu')]]")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" Exception in Fill time sheet");
		}

	}

	public static void Fri() throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].value=8;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='2']/input[@type='text' and @title[contains(.,'Fri')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			Thread.sleep(1000);
			jsc.executeScript("arguments[0].value=1;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3']/input[@type='text' and @title[contains(.,'Fri')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Friday is Holiday or Planned leave");
		}

	}

	public static void Thu() throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].value=8;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='2']/input[@type='text' and @title[contains(.,'Thu')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			Thread.sleep(1000);
			jsc.executeScript("arguments[0].value=1;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3']/input[@type='text' and @title[contains(.,'Thu')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thursday is Holiday or Planned leave");
		}

	}

	public static void Wed() throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].value=8;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='2']/input[@type='text' and @title[contains(.,'Wed')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			Thread.sleep(1000);
			jsc.executeScript("arguments[0].value=1;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3']/input[@type='text' and @title[contains(.,'Wed')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Wednesday is Holiday or Planned leave");
		}

	}

	public static void Tue() throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].value=8;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='2']/input[@type='text' and @title[contains(.,'Tue')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			Thread.sleep(1000);
			jsc.executeScript("arguments[0].value=1;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3']/input[@type='text' and @title[contains(.,'Tue')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Tuesday is Holiday or Planned leave");
		}

	}

	public static void Mon() throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].value=8;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='2']/input[@type='text' and @title[contains(.,'Mon')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			Thread.sleep(1000);
			jsc.executeScript("arguments[0].value=1;", driver.findElement(By.xpath(
					"//td[@class='tableContent' and @row='3']/input[@type='text' and @title[contains(.,'Mon')] and not(contains(@class,'ppm_res_cal_non_working'))]")));
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Monday is Holiday or Planned leave");
		}

	}

	private static void LogOut() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Your Time sheet has been submitted and logout clarity successfully");
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'Logout')]")));

	}

}