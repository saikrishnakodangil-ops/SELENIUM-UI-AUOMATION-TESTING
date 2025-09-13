package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day7 {
public static void main(String[] args) throws InterruptedException {
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=12217535945164896599&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062141&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> ts=driver.findElements(By.id("nav-main"));
		Actions hi=new Actions(driver);
	
		for(WebElement yy:ts) {
			System.out.println( yy.getText());
			Thread.sleep(3000);
		}
		String [] re= {	"//a[@id=\"nav-hamburger-menu\"]	",
						"/html/body/div[1]/header/div/div[5]/div[2]/div/div/a[1]/span[1]",
						"//a[@class=\"nav-a  \"][1]",
						"//a[@class=\"nav-a  \"][2]",
						"//a[@class=\"nav-a  \"][3]"
		
		};
		for(String sai:re)
{
			WebElement jj=driver.findElement(By.xpath(sai));
			Actions hit=new Actions(driver);
			hit.moveToElement(jj);
			Thread.sleep(2000);
			}
}
}
}
