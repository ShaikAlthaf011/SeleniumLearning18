package CodingPractice12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChatbotTest2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\91703\\Desktop\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qachatbot.ccbp.tech/");
        driver.manage().window().maximize();
        WebElement el1=driver.findElement(By.cssSelector("input[class='user-input']"));
        el1.sendKeys("Hi");
        WebElement el2= driver.findElement(By.cssSelector("button[class='send-msg-btn']"));
        el2.click();
        WebElement el3=driver.findElement(By.cssSelector("input[class='user-input']"));
        el1.sendKeys("Good Morning");
        WebElement el4= driver.findElement(By.cssSelector("button[class='send-msg-btn']"));
        el2.click();
        WebElement el5=driver.findElement(By.cssSelector("input[class='user-input']"));
        el1.sendKeys("Help");
        WebElement el6= driver.findElement(By.cssSelector("button[class='send-msg-btn']"));
        el2.click();
        List<WebElement> list=driver.findElements(By.cssSelector("div[id='chatContainer'] span"));
        for(WebElement w1:list){
            System.out.println(w1.getText());
        }
        driver.quit();
    }
}
