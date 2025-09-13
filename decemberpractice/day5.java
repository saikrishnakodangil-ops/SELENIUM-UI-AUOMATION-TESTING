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

public class day5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("krishna",Keys.TAB,"krishna@gmail.com",
				Keys.TAB,"8976578679",Keys.TAB,"cpt,pasumarru,palanadu",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id=\"male\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"monday\"]")).click();
		
		WebElement el=driver.findElement(By.xpath("//button[@id=\"PopUp\"]"));
		Actions ff=new Actions(driver);
		ff.moveToElement(el).perform();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
	WebElement drop =driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select qw=new Select(drop);
		Thread.sleep(2000);
		//qw.selectByVisibleText("Canada");
	List<WebElement>down= qw.getOptions();
		System.out.println("the no options :"+down.size());
		for(int i=0;i<down.size();i++) {
			down.get(i).click();
			Thread.sleep(2000);
		WebElement hr=driver.findElement(By.xpath("class=\"form-group\""));
		Actions yt= new Actions(driver);
		yt.moveToElement(hr).perform();
		//for(WebElement dd:hr) {
			//System.out.println("total elements"+dd.getSize());		
		yt.moveToElement(hr).perform();
		Thread.sleep(2000);	
			
			
		}
  WebElement ooo =driver.findElement(By.xpath("//select[@name=\"animals\"]"));
  Select mm =new Select(ooo);
  Thread.sleep(2000);
  mm.selectByIndex(2);
  List<WebElement>yy=mm.getOptions();
  System.out.println("total list:"+ooo.getText());
  
  
	}
	 

	}
