package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class day6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=713930225169&hvpos=&hvnetw=g&hvrand=7912300597976680333&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9184631&hvtargid=kwd-64107830&hydadcr=14452_2402225&gad_source=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[@class=\"hm-icon-label\"]")).click();
//	List<WebElement>re=driver.findElements(By.xpath("//ul[@data-menu-id=\"1\"]"));
//		Actions tu =new Actions(driver);
//		for(WebElement tr:re) {
//			System.out.println("print total list"+tr.getText());
//			tu.moveToElement(tr).perform();
//			Thread.sleep(3000);
//		}
//		
//			//driver.findElement(By.xpath("//div[@id=\"hmenu-close-icon\"]")).click();
//			List<WebElement>gh=driver.findElements(By.xpath("//div[@id=\"nav-xshop\"]"));
//			Actions ll=new Actions(driver);
//			for(WebElement gst:gh) {
//				System.out.println("list of all"+gst.getText());
//				ll.moveToElement(gst).perform();
//				Thread.sleep(3000);
//			}
//			
		
//		List<WebElement>ni=driver.findElements(By.xpath("//div[@id=\"nav-xshop\"]"));
//		Actions lk=new Actions(driver);
//		for(WebElement pp:ni) {
//			System.out.println("print list"+pp.getText());
//			lk.moveToElement(pp).perform();
//			Thread.sleep(3000);
		
	WebElement kk = driver.findElement(By.xpath("//div[@class=\"nav-search-facade\"]"));
	Select gg=new Select(kk);
	Thread.sleep(2000);
	System.out.println("list all elements"+kk.getText());

	
		

	
	
	}
	}


