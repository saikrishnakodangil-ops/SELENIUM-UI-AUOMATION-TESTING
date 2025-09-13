package decemberpractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class day1 {

	public  static void main(String [] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("sai",Keys.TAB,"krisha@gmail.com",
				Keys.TAB,"7842124163",Keys.TAB,"gnt,cpt",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
		 driver.findElement(By.xpath("//input[@id=\"monday\"]")).click();
		 WebElement uv = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		 Select vv=new Select(uv);
		 vv.selectByIndex(6);
		 List<WebElement>opt=vv.getOptions();
		 System.out.println(" total list"+opt.size());
		 System.out.println(vv);
		 for(int j=0; j<opt.size();j++) {
			 opt.get(j).click();
			 Thread.sleep(3000);
			 
		 }
		 
		 }
				 
				 
				 
				 
				 
				 
				 

	}


