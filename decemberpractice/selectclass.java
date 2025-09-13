package decemberpractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectclass {

	public static void main(String[] args) throws InterruptedException {
  WebDriver driver=new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//input[@class=\"form-control\"][1]")).sendKeys("sai",Keys.TAB,"sai@gmail.com",Keys.TAB,"123456789",Keys.TAB,"asdfhjklzxcvbnmwertyuxcbnertyu");
driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
driver.findElement(By.xpath("//input[@value=\"tuesday\"]")).click();
WebElement drop=driver.findElement(By.xpath("//select[@id=\"country\"]"));
Select down=new Select(drop);
down.selectByIndex(4);
Thread.sleep(2000);
List<WebElement> sai=down.getOptions();
for(int i=0;i<sai.size();i++) {
	sai.get(i).click();
}

Thread.sleep(3000);

WebElement colors =driver.findElement(By.xpath("//div[@class=\"form-group\"][6]"));
Select sc=new Select(colors);

if(sc.isMultiple());
List<WebElement>op=sc.getOptions();
for (int j=0;j<op.size();j++) {
	op.get(j).click();
	Thread.sleep(5000);
	
	if(op.size()>3) {
		sc.deselectByIndex(3);
		
	}
	else
		System.out.println("this is sai");
		
	}

}
}
