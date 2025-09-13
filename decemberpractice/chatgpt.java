package decemberpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class chatgpt {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Fill basic information
        driver.findElement(By.xpath("//input[@class='form-control'][1]"))
              .sendKeys("sai", Keys.TAB, "sai@gmail.com", Keys.TAB, "123456789", Keys.TAB, "asdfhjklzxcvbnmwertyuxcbnertyu");

        // Select gender radio button
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        // Select 'Tuesday' checkbox
        driver.findElement(By.xpath("//input[@value='tuesday']")).click();

        // Handle Country dropdown
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByIndex(4);

        // Print all country options
        List<WebElement> countries = countrySelect.getOptions();
        for (WebElement country : countries) {
            System.out.println("Country: " + country.getText());
        }

        // Handle multi-select dropdown (Colors)
        WebElement colorsDropdown = driver.findElement(By.id("colors"));  // ✅ Corrected line
        Select colorSelect = new Select(colorsDropdown);

        if (colorSelect.isMultiple()) {
            List<WebElement> allColors = colorSelect.getOptions();
            for (WebElement color : allColors) {
                color.click(); // Select each color
                Thread.sleep(500);
            }

            // Deselect one item (e.g., index 3) safely
            if (allColors.size() > 3) {
                colorSelect.deselectByIndex(3);
            }
        } else {
            System.out.println("Colors dropdown is not multi-select!");
        }

        Thread.sleep(3000); // Pause to see result
        driver.quit(); // Close the browser
    }
}
