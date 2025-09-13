package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class day3 {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("https://jqueryui.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.xpath("//a[@href=\"https://jqueryui.com/selectable/\"]")).click();
Thread.sleep(4000);
driver.switchTo().frame(0);
Thread.sleep(4000);
List <WebElement> ele=driver.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee']"));	}

}
