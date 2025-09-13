package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class day8 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("sai",Keys.TAB,"sai@gamil",Keys.TAB,"9898787977",Keys.TAB,"cpt,pasumarru,palanadu",Keys.TAB);
	driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"monday\"]")).click();
	
	WebElement country =driver.findElement(By.xpath("//select[@id=\"country\"]"));
	Select oo=new Select(country);
	oo.selectByIndex(8);
	Thread.sleep(2000);
	List<WebElement>opt=oo.getOptions();
	for(int i=0;i<opt.size();i++) {
		opt.get(i).click();
		System.out.println(opt);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	List<WebElement>ll=driver.findElements(By.xpath("//div[@class=\"form-group\"][4]"));
//	Actions nn=new Actions(driver);
//	for (WebElement kk:ll) {
//		System.out.println(kk.getText());
//		Thread.sleep(3000);
//		
//	
//	String [] lk = {  "//input[@id=\"sunday\"]",
//					"//input[@id=\"monday\"]",
//					"//input[@id=\"tuesday\"]",
//					"//input[@id=\"wednesday\"]",
//					"//input[@id=\"thursday\"]",
//					"//input[@id=\"friday\"]",
//					"//input[@id=\"saturday\"]"
//					
//	};			
//	
//	for (String dd:lk) {
//		WebElement po = driver.findElement(By.xpath(dd));
//		Actions ee=new Actions(driver);
//		ee.moveToElement(po).perform();
//		Thread.sleep(3000);
//	
//	
//	}
//	
//	}

	}

}