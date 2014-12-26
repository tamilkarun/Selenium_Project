package tamil.selenium.maven;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basicactioncmds {
	
	
	protected static SimpleDateFormat dfRally = new SimpleDateFormat(
			"yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
	/*
	 * Use it to log data to HTML test reports
	 * 
	 * @param s
	 *            - String to be looged in HTML reports
	 */
	public static void log(String s) {
		Reporter.log(dfRally.format(new Date()) + " :  " + s + "<br/>");
		// Reporter.log(dfRally.format(new Date()) + " :  " + s);
		System.out.println(s);
	}
	
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void beforetest(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		System.out.println(driver.getCurrentUrl());
	}
	@AfterTest(enabled = true)
	public void aftertest(){
		driver.quit();
	}
	@Test
	public void test(){
System.out.println("Executed Test1");	
	}
	@Test
	public void gettitle(){
		System.out.println(driver.getTitle());
		System.out.println("Executed Test2");
	}
	@Test
	public void JSexec(){
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
		System.out.println("Domain Name: " + CurrentURLUsingJS);
		System.out.println("Executed Test3");
	}
	@Test
	public void JSalert(){
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("alert('Test Case Execution Is started Now..');");
	}
	
	@Test
	public void SeldrpdwnVisibleTxt(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		System.out.println(driver.getCurrentUrl());
		Select mydrpdwn = new Select(driver.findElement(By.id("Carlist")));
		mydrpdwn.selectByVisibleText("Audi");
	}
	@Test
	public void SeldrpdwnByIdx() throws InterruptedException{
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		System.out.println(driver.getCurrentUrl());
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		listbox.selectByIndex(0);
		listbox.selectByIndex(3);
		driver.findElement(By.xpath("//input[@value='->']")).click();
		Thread.sleep(2000);
	}
	@Test
	public void SeldrpdwnVal(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
		System.out.println(driver.getCurrentUrl());
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		listbox.selectByValue("Italy");
		listbox.selectByValue("Mexico");
		listbox.selectByValue("Spain");
		driver.findElement(By.xpath("//input[@value='->']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("text2")));
	}
	@Test
	public void k4s(){
		
		//Maximize Window 
		driver.manage().window().maximize();

		//Goto Advance.kno.com
		driver.get("https://advance.kno.com");
		System.out.println(driver.getCurrentUrl());
		
		//Login 
		driver.findElement(By.id("email")).sendKeys("tamil");
		driver.findElement(By.id("password")).sendKeys("123456");
		//driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.cssSelector("div[class='field btn-container'] > a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("user-name")));
		
		//Check User Report & Content Report
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'User Report')]")).isDisplayed(),"Unable to find text - User Report");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Content Report')]")).isDisplayed(),"Unable to find text - Content Report");
		
		//1.Click Report to collapse
		driver.findElement(By.xpath("//a[contains(.,'Report')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".section.collapse-menu")));
		//Verify Collapse
		if( driver.findElement(By.cssSelector(".section.collapse-menu")).isDisplayed() ){
			System.out.println("REPORT is collapsed");
		}else{
			System.out.println("REPORT is not collapsed");
		}
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(.,'Manage Books')]")));
		//Check Allocate Licenses & Distribute Books
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Allocate Licenses')]")).isDisplayed(),"Unable to match text - Allocate Licenses");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Distribute Books')]")).isDisplayed(),"Unable to match text - Distribute Books");
		
		//2.Click Manage Books to Collapse
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Books')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(3)")));
		//Verify Collapse
		if( driver.findElement(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(3)")).isDisplayed() ){
			System.out.println("MANAGE BOOKs is collapsed");
		}else{
			System.out.println("MANAGE BOOKS is not collapsed");
		}
		
		//3.Click Kno Administrative to Collapse
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Set up Institution Identifier')]")).isDisplayed(),"Unable to find text - Set up Institution Identifier");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'License Code Management')]")).isDisplayed(),"Unable to find text - License Code Management");
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.xpath("//a[contains(.,'Kno Administrative')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(5)")));
		//Verify Collapse
		if (!(driver.findElement(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(5)")).isDisplayed())){
			System.out.println("KNO ADMINISTRATIVE is collapsed");
		}else{
			System.out.println("KNO ADMINISTRATIVE is not collapsed");
		}
		
		//4.Click Manage Users or Groups
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(.,'Manage Users or Groups')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Add User')]")).isDisplayed(),"Unable to find text - Add User");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Administer User')]")).isDisplayed(),"Unable to find text - Administer User");
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Users or Groups')]")).click();
		//Verify Collapse
		if( driver.findElement(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(2)")).isDisplayed() ){
			System.out.println("Manage Users or Groups is collapsed");
		}else{
			System.out.println("Manage Users or Groups is not collapsed");
		}
		
		//5.Click Setup
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(.,'Setup')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Import Devices Configuration')]")).isDisplayed(),"Unable to find text - Import Devices Configuration");
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Admin Settings')]")).isDisplayed(),"Unable to find text - Admin Settings");
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.xpath("//a[contains(.,'Setup')]")).click();
		//Verify Collapse
		if( driver.findElement(By.cssSelector(".scrollable ul li.section.collapse-menu:nth-child(4)")).isDisplayed() ){
			System.out.println("Setup is collapsed");
		}else{
			System.out.println("Setup is not collapsed");
		}
		
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.className("user-name")).click();
		driver.findElement(By.linkText("Log Out")).click();
		log("Verify Login Text");
		String login_text = driver.findElement(By.cssSelector("#login-form>hgroup>h3")).getText();
		Assert.assertTrue(login_text.equals("Login"),"Unable to find text - Login");
	}
	
	@Test
	public void k4s_loginPage(){
		
		//Maximize Window
		driver.manage().window().maximize();
		//Goto Advance.kno.com
		driver.get("https://advance.kno.com");
		System.out.println(driver.getCurrentUrl());
		log("Verify Login Text");
		String login_text = driver.findElement(By.cssSelector("#login-form>hgroup>h3")).getText();
		try {
			Assert.assertTrue(login_text.equals("Login"),"Unable to Match Login text");
			}
		catch (Exception e) {
			System.out.println("Unable to Match Login text");
		}
		log("Verify the title text");
		String title_text = driver.findElement(By.cssSelector("#login-form>hgroup>h5")).getText();
		System.out.println(title_text);
		try{
			Assert.assertTrue(title_text.equals("[ Kno for Schools - Admin ]"),"Unable to match- [ Kno for Schools - Admin ]");
		}catch (Exception e){
			System.out.println("Unable to match- [ Kno for Schools - Admin ]");
		}
		driver.findElement(By.cssSelector("div[class='field btn-container'] > a")).click();
		String Username_error = driver.findElement(By.cssSelector(".field:nth-child(2) p .error-message")).getText();
		System.out.println(Username_error);
		try{
			Assert.assertTrue(Username_error.equalsIgnoreCase("Username Required"),"Unable to match - Username Required");
		}catch (Exception e){
			System.out.println("Unable to match - Username Required");
		}
		String Password_error = driver.findElement(By.cssSelector(".field:nth-child(3) p .error-message")).getText();
		System.out.println(Password_error);
		try{
			Assert.assertTrue(Password_error.equalsIgnoreCase("Password Required"),"Unable to match - Password Required");
		}catch (Exception e){
			System.out.println("Unable to match - Password Required");
		}
		//Login 
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.linkText("Sign In")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".im-message")));
		driver.findElement(By.cssSelector(".im-message")).click();
		String Error_Notif_text = driver.findElement(By.cssSelector(".im-wr.scrollable")).getText();
		System.out.println(Error_Notif_text);
		Assert.assertTrue(Error_Notif_text.equals("Invalid sign in credentials. Please try again."));
	}
	@Test
	public void AdminUser(){
		//Maximize Window
		driver.manage().window().maximize();
		//Goto Advance.kno.com
		driver.get("https://advance.kno.com");
		System.out.println(driver.getCurrentUrl());
		
		//Login 
		driver.findElement(By.id("email")).sendKeys("tamil");
		driver.findElement(By.id("password")).sendKeys("123456");
		//driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.cssSelector("div[class='field btn-container'] > a")).click();
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("user-name")));		
		
	}
	
}
