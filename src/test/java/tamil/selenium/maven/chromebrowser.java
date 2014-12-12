package tamil.selenium.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser {

	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinothini\\Desktop\\Tamil\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		if(driver.findElement(By.id("gbqfq")).isEnabled()){
			System.out.println("Google search text box is Enabled.");
			driver.findElement(By.id("gbqfq")).sendKeys("WebDriver Test successful");
			driver.findElement(By.id("gbqfq")).click();
			System.out.println("Google search completed.");
		}
		else{
			System.out.println("google search test box is not enabled");
		}
		
		driver.close();       
		
	}
}
