package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.beust.jcommander.Strings;

public class day2 {	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@placeholder=\"UseI       rname\"]")).sendKeys("visual_user");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
		driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
		List<WebElement>rt=driver.findElements(By.xpath("//div[@class=\"bm-menu\"]"));
		Actions sa=new Actions(driver);
		for(WebElement name:rt) {	
			System.out.println(name.getText());
			sa.moveToElement(name).perform();
			Thread.sleep(10);
			String [] sai= {"//a[@class=\"bm-item menu-item\"][1]",
                            "//a[@class=\"bm-item menu-item\"][2]",
                            "//a[@class=\"bm-item menu-item\"][3]",
                            "//a[@class=\"bm-item menu-item\"][4]"
			};
			
		for(String er:sai) {
			WebElement qw=driver.findElement(By.xpath(er));
		sa.moveToElement(qw).perform();
	}
	


	}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
		driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-test=\"remove-sauce-labs-backpack\"]")).click();
		//driver.findElement(By.xpath("//button[@id=\"continue-shopping\"]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[@type=\"button\"][1]")).click();
		driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("saikrishna");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("kodangil");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("522616");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		driver.findElement(By.xpath("//button[@data-test=\"finish\"]")).click();
		
				
	}
}
