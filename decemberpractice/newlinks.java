package decemberpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class newlinks {
 public static void main(String[] args) throws InterruptedException {
	 
WebDriver driver=new ChromeDriver();
 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
 driver.manage().window().maximize();
 WebElement kk=driver.findElement(By.xpath("//select[@id=\"dropdown-class-example\"]"));
 Select jj=new Select(kk);
 jj.selectByIndex(2);
 Thread.sleep(2000);
List<WebElement>sai =jj.getOptions();
System.out.println(sai.size());
Thread.sleep(2000);
for(int i=0;i<sai.size();i++) {
	sai.get(i).click();
	Thread.sleep(2000);
}
driver.findElement(By.xpath("//label[@for=\"bmw\"]")).click();
Thread.sleep(1000);
 }
}
