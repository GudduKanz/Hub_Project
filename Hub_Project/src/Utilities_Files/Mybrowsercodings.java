package Utilities_Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mybrowsercodings {

	public static WebDriver driver;

	public static  WebDriver Browserfact(String browserName,String url) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\Driver\\chromedriver.exe");
      driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.get(url);
	  driver.manage().window().maximize();
		

	     return driver;
	}
}
