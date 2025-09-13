package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class sunku {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("saikrishna");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("kodangil1998@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("987654321");
		driver.findElement(By.xpath("//textarea[@id=\"textarea\"]")).sendKeys("pasumarru,palanadu");
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"thursday\"]")).click();
		WebElement ll=driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select drop=new Select(ll);
		Thread.sleep(3000);
		drop.selectByIndex(4);
		List<WebElement> option=drop.getOptions();
		System.out.println(option.size());
		
		for(int i=0;i<option.size();i++) {
			option.get(i).click();
		
			Thread.sleep(2000);
	}
			driver.findElement(By.xpath("//option[@value=\"red\"][1]")).click();	
					
			}
		
		
		
	
	

}

