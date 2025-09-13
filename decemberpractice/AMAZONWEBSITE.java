package decemberpractice;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AMAZONWEBSITE {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=713930225169&hvpos=&hvnetw=g&hvrand=7912300597976680333&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9184631&hvtargid=kwd-64107830&hydadcr=14452_2402225&gad_source=1");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	List<WebElement>rr=driver.findElements(By.xpath("//div[@id=\"nav-main\"]"));
	for (int i=0;i<rr.size();i++) {
		Thread.sleep(3000);
		System.out.println("total list of elements"+rr.get(i).getText());
	
		Thread.sleep(3000);
	rr.get(0).click();
	
	 }
	 
	 
		
	
		
	}
	

}
