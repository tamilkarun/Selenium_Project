package tamil.selenium.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basicactioncmds {
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void beforetest(){
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		System.out.println(driver.getCurrentUrl());
	}
	@AfterTest(enabled = false)
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
		driver.manage().window().maximize();
		driver.get("https://advance.kno.com");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("tamil");
		driver.findElement(By.id("password")).sendKeys("123456");
		//driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.cssSelector("div[class='field btn-container'] > a")).click();
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("user-name")));
		driver.findElement(By.xpath("//a[contains(.,'Report')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Users or Groups')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Manage Books')]")).click();;
		driver.findElement(By.xpath("//a[contains(.,'Setup')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Kno Administrative')]")).click();
		driver.findElement(By.className("hd")).click();
		driver.findElement(By.className("user-name")).click();
		driver.findElement(By.linkText("Log Out")).click();
	}
}
