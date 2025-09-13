package decemberpractice;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class friday {
public static void main(String[] args) {
	WebDriver driver =new ChromeDriver();
	driver.get("\"https://testautomationpractice.blogspot.com/\"");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
}


	
	
	
