package tamil.selenium.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mytestclass {

	
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		String i = driver.getCurrentUrl();
		System.out.println(i);
		driver.close();
	}
}
