package tamil.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ByClassName {

	WebDriver driver = new FirefoxDriver();
	
	

	@Test
	public void test(){
		driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//xpath examples
		//1. driver.findElement(By.xpath("//input[@name='fname']"));
		//2. driver.findElement(By.xpath("//input[contains(@name,'fname')]"));
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
		driver.findElement(By.cssSelector("input[name='To Hide']")).sendKeys("Hidden Name");
		driver.findElement(By.linkText("Click Here")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("18:"))); //Locate element by partial linkText. 
		driver.findElement(By.name("fname")).sendKeys("My second Name");
		String dropdown = driver.findElement(By.tagName("select")).getText();
		System.out.print("Drop down list values are as bellow :\n"+dropdown);
		String  datentime = driver.findElement(By.className("date-header")).getText();
		System.out.print("\n"+datentime);
		
		for(int i = 0; i <=60; i++){
			WebElement btn = driver.findElement(By.id("submitButton"));
			if(btn.isEnabled()){
				System.out.println("\nCongr8s... Button is enabled and webdriver is clicking on it now");
				driver.findElement(By.id("submitButton")).click();
				i=60;
			}
		
		else
		{
			System.out.println("\nSorry but Button is disabled right now..");
		}
		try{
			Thread.sleep(500);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
  }
}
