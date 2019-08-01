package Page_Code;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Hubcodes {
static Logger log = Logger.getLogger( Hubcodes.class.getName());
	
	{ 
		PropertyConfigurator.configure("C:\\Users\\Guddu\\eclipse-workspace\\Hub_Project\\src\\Log4j.properties");
	}
	public static WebDriver driver;
	//private WebDriver para;

	@SuppressWarnings("static-access")
	public  Hubcodes (WebDriver idriver)
{

this.driver =idriver;

}
	@FindBy(name="identity") WebElement id;
	@FindBy(name="password") WebElement pss;
	@FindBy(xpath="//button[text()='Login' and @type='submit' and @class='btn login_btn d-sm-none d-none d-lg-inline-block']") WebElement lg;
	@FindBy(id="YT_focus_10") WebElement shuptd;
	@FindBy(name="post_title") WebElement pst;
	@FindBy(xpath="//ul[contains(@class,'select2-choices')]") WebElement tg;
	
	
	public void login(String user,String pass) {
		id.sendKeys(user);
		pss.sendKeys(pass);
		lg.click();
		
		
	
	}
	public void Shareanupdate(String Post) {
		shuptd.click();
		pst.sendKeys(Post);
		tg.click();
	   Actions actions = new Actions(driver);
        WebElement tag=driver.findElement(By.xpath("//ul[contains(@class,'select2-choices')]"));
       actions.moveToElement(tag);actions.click();actions.sendKeys("Horticulture");
       actions.build().perform(); actions.click();
		
	}
}
