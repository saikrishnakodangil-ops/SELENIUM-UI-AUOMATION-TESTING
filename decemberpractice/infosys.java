package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class infosys {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("https://rahulshettyacademy.com/AutomationPractice/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement (By.className("radioButton")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//input[@type=\"text\"][1]")).sendKeys("india");
WebElement drop=driver.findElement(By.xpath("//select[@id=\"dropdown-class-example\"]"));
Select down =new Select(drop);
down.selectByIndex(2);
Thread.sleep(2000);
driver.findElement(By.id("checkBoxOption1")).click();
//driver.switchTo().alert();
//driver.findElement(By.className("enter-name")).sendKeys("allow");
List<WebElement> oops=down.getOptions();
System.out.println(oops.size());

for(int i=0;i<oops.size();i++) {
	oops.get(i).click();
}
}
}

