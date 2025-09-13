package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.Argument;

public class selemiumpracticeapplication {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("saikrishna");
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("sai@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("7842124163",Keys.TAB,"pasumarru, chilakaluripet,guntur");
		driver.findElement(By.xpath("//input[@name=\"gender\"][1]")).click();
		driver.findElement(By.xpath("//input[@id=\"monday\"]")).click();
		WebElement re=driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select yu=new Select(re);
		yu.selectByIndex(0);
		List<WebElement> option =yu.getOptions();
		System.out.println("number of options"+option.size());
		for(int i=0;i<option.size();i++) {
			Thread.sleep(2000);
			option.get(i).click();
			Thread.sleep(3000);
		}
//	Thread.sleep(3000);
//			WebElement jj=driver.findElement(By.xpath("//select[@id=\"colors\"]"));
//			Select tt =new Select(jj);
//			tt.selectByIndex(0);
//			List<WebElement>opt=tt.getOptions();
//			for(int i=0;i<opt.size();i++) {
//				opt.get(i).click();
//				Thread.sleep(1000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		//js.executeScript(Argument[], args);
//			driver.findElement(By.xpath("//option[@value=\"red\"]")).click();
//		
//			
//			
//		}
//		
//		Actions ty=new Actions(driver);
//	for( WebElement sp:opt) {
//		
//		ty.moveToElement(jj).perform();
//		jj.getText();
//		System.out.println("list of lements"+jj.getSize());
//	}
//		
//	
//
//	}
}

}
