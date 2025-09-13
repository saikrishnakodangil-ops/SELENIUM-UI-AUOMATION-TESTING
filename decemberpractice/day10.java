package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class day10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("sai",Keys.TAB,"sai@gmail.com",Keys.TAB,
	    													"9876543",Keys.TAB,"pasumarru");
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"tuesday\"]")).click();
		driver.findElement(By.xpath("//select[@class=\"form-control\"][1]")).click();
		WebElement drop=driver.findElement(By.xpath("//div[@class=\"form-group\"][5]"));
		
        Select pp=new Select(drop);
        Thread.sleep(3000);
        pp.selectByIndex(4);
        
        List<WebElement>ii= pp.getOptions();
        
               
        
	     
	    	 
	     }
			
		}
	


