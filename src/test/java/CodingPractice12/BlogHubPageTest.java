package CodingPractice12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlogHubPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qabloghub.ccbp.tech/");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='blogs-list']>li[class='blog-item']")));
        //Test the Number of Blog Displayed:
        List< WebElement> li=driver.findElements(By.cssSelector("li[class='blog-item']"));
        if(li.size()==10){
            System.out.println("All blogs are displayed");
        }else{
            System.out.println("Few blogs missing...");
        }
        //Test all the Blog Titles:
        List<WebElement>li1=driver.findElements(By.cssSelector("img[class='blog-item-image']+*>h1"));
        String[]str1={"React v16.9.0 and the Roadmap Update", "React v16.7: No, This Is Not the One With Hooks", "Building Great User Experiences with Concurrent Mode and Suspense", "Introducing The Problem Solver React v17.0", "What about the React v16.13.0 That we Developed", "React v16.4.2: Server-side vulnerability fix", "Introducing Zero-Bundle-Size React Server Components", "Introducing the New JSX Transform", "Introducing the New React DevTools", "Sneak Peek: Beyond React 16"};
        String []str2=new String[li1.size()];
        for(int i=0;i< li1.size();i++){
            str2[i]=li1.get(i).getText();
        }
        boolean Match=java.util.Arrays.equals(str1,str2);
        if(Match){
            System.out.println("All blog titles are as expected");
        }else{
            System.out.println("Mismatch found in blog titles");
        }
        //Test the Routing Functionality:
        WebElement wl1=driver.findElement(By.cssSelector("li>a[href='/about']"));
        wl1.click();
        String Str12= driver.getCurrentUrl();
        String Str13="https://qabloghub.ccbp.tech/about";
        if(Str12.equals(Str13)){
            System.out.println("Navigation to About Page Successful");
        }
        WebElement wl2=driver.findElement(By.cssSelector("li>a[href='/contact"));
        wl2.click();
        String Str87=driver.getCurrentUrl();
        String Str9="https://qabloghub.ccbp.tech/contact";
        if(Str87.equalsIgnoreCase(Str9)){
            System.out.println("Navigation to Contact Page Successful");
        }
        WebElement wl3=driver.findElement(By.cssSelector("li>a[href='/']"));
        wl3.click();
        String Str65=driver.getCurrentUrl();
        String Str56="https://qabloghub.ccbp.tech/";
        if(Str65.equalsIgnoreCase(Str56)){
          System.out.println("Navigation to Home Page Successful");
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='blogs-list']>li[class='blog-item']")));
     //Test the Routing Functionality for Each Blog:
        WebElement element1=driver.findElement(By.cssSelector("li>a[href='/blogs/1']"));
        element1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='blog-image']")));
        WebElement element2=driver.findElement(By.cssSelector("div[class='app-body'] h1"));
        String Tr= element2.getText();
        String Te="React v16.9.0 and the Roadmap Update";
        if(Tr.equals(Te)){
            System.out.println("Blog Hub Page working as expected");
        }else{
            System.out.println("Blog is mismatched");
        }
        WebElement element45=driver.findElement(By.cssSelector("li>a[href='/']"));
        element45.click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='blog-item']")));
        driver.quit();
    }
}
