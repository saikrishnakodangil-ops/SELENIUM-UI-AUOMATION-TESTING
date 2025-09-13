package decemberpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class bhargav {
public static void main(String[] args) {
	WebDriver driver=new  ChromeDriver();
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.switchTo().frame(0);
	WebElement drag =driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
	WebElement drop =driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
	Actions rr=new Actions(driver);
	rr.dragAndDrop(drag, drop).perform();

}
} 
 