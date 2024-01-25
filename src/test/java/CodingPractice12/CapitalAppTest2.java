package CodingPractice12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CapitalAppTest2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\91703\\Desktop\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qacapitalsapp.ccbp.tech/");
        driver.manage().window().maximize();
        // Find all the options of the dropdown element
        List<WebElement> optionsList = driver.findElements(By.cssSelector("select[class = 'capital-select'] > option"));

        // Find the dropdown element
        WebElement dropdownEl = driver.findElement(By.cssSelector("select[class ^= 'capital']"));

        // Find the resultant country name
        WebElement countryName = driver.findElement(By.cssSelector("div[class = 'question-container'] + p"));

        // Verify the country text with expected country name order
        String[] expectedCountry = { "India", "United Kingdom", "France", "Nepal", "Finland" };
        int i;
        for (i = 0; i < 5; i++) {
            // Get the text content of the option
            WebElement option = optionsList.get(i);
            String text = option.getText();

            // Select the option based on the text content
            Select dropdown = new Select(dropdownEl);
            dropdown.selectByVisibleText(text);

            if (!expectedCountry[i].equals(countryName.getText())) {
                System.out.println("Mismatch found in country name");
            }
        }
        if (i == 5) {
            System.out.println("Capitals App working as expected");
        }

        // Quit the WebDriver instance
        driver.quit();
    }
}


