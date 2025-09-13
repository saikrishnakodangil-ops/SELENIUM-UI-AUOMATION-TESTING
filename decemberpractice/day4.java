package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day4 {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user",Keys.TAB,"secret_sauce",Keys.TAB,Keys.ENTER);
driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
List<WebElement>er=driver.findElements(By.xpath("//nav[@class=\"bm-item-list\"]"));
Actions rr=new Actions(driver);
for(WebElement name:er) {	

	System.out.println(name.getText());
	
	Thread.sleep(1000);
	rr.moveToElement(name).perform();
	Thread.sleep(1000);
}
	
	String [] kgf ={
			        "//a[@class=\"bm-item menu-item\"][1]",
		 		"//a[@class=\"bm-item menu-item\"][2]",
			 		"//a[@class=\"bm-item menu-item\"][3]",
		 		"//a[@class=\"bm-item menu-item\"][4]"
	
		
		

	};
	for(String op:kgf) {
		WebElement ww=driver.findElement(By.xpath(op));
		rr.moveToElement(ww).perform();
		
	

	}
	driver.findElement(By.xpath("//a[@id=\"about_sidebar_link\"]")).click();
	List<WebElement>tt=driver.findElements(By.xpath("//span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"]"));
	Actions ee=new Actions(driver);
	for(WebElement dd:tt) {
		System.out.println(dd.getText());
		ee.moveToElement(dd).perform();
		
	}
	Thread.sleep(20);
		String [] su= {
			         "/(/span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"])[1]",
			         "(//span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"])[2]",
			        "(//span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"])[3]",
			        "(//span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"])[4]",
			        "(//span[@class=\"MuiTypography-root MuiTypography-buttonLabelNav css-3bxbw2\"])[5]"
			
	};
	Thread.sleep(20);
	for(String nn:su) {
		Thread.sleep(20);
		WebElement pp =driver.findElement(By.xpath(nn));
	ee.moveToElement(pp).perform();
		
		
	
	driver.navigate().back();
	
	
	}	
	}
}
	




