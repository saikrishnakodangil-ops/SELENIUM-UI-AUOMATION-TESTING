package decemberpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenders {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@href=\"https://jqueryui.com/datepicker/\"]")).click();
		WebElement year=driver.findElement(By.xpath("class=\"ui-datepicker-title\""));
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		String y_m=year.getText();
		
	}

}
