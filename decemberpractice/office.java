package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class office {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("\"https://testautomationpractice.blogspot.com/\"");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("saikrishna",Keys.TAB,"saiAgmail.com",Keys.TAB,"123456789",Keys.TAB,"pasumarru",Keys.TAB,Keys.TAB);;
//       driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
//       driver.findElement(By.xpath("//div[@class=\"form-check form-check-inline\"][4]")).click();
//       WebElement hh=driver.findElement(By.xpath("//label[@for=\"country\"]"));
//       Select kk=new Select(hh);
//       kk.selectByIndex(1);
//       Thread.sleep(10);
//       List<WebElement> uu=kk.getOptions();
//       System.out.println(kk);
//}
	}
}