package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class uuyuy {
 public static void main(String[] args) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://testautomationpractice.blogspot.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.findElement((By.xpath("//input[@id=\"name\"]"))).sendKeys("sai",Keys.TAB,"sai@gmail.com",Keys.TAB,"12345678",Keys.TAB,"pasumarru,chilakaluripet gubur",Keys.ENTER);
	 driver.findElement(By.xpath("//div[@class=\"form-check form-check-inline\"][1]")).click();
     driver.findElement(By.xpath("//input[@id=\"thursday\"]")).click();
     WebElement drop= driver.findElement(By.id("//select[@id=\"country\"]"));
    Select hh=new Select(drop);
    hh.selectByIndex(5);
    List<WebElement>yt=hh.getOptions();
    Thread.sleep(3000);
    for(WebElement op:yt) {
        System.out.println(op.getText());
    }
	 
}
}
