package CodingPractice12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FeaturesPageTest2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qafeaturesect.ccbp.tech/");
        driver.manage().window().maximize();
        //Test all Heading:
        List<WebElement> el1=driver.findElements(By.cssSelector("div[class='feature-card p-3 mb-3 text-center']>h1[class^='vr-feature']"));
        String[]str1={"Easy to connect","VR Capability","Video games","Interaction","Easy to play","Awesome Experience"};
        String []ExpectedCondion=new String[el1.size()];
        for(int i=0;i<el1.size();i++){
            ExpectedCondion[i]=el1.get(i).getText();
        }
        boolean match=java.util.Arrays.equals(str1,ExpectedCondion);
        if(match){
            System.out.println("All titles are as expected");
        }else{
            System.out.println("Mismatch found in titles");
        }
        //Test all the Descriptions
        List<WebElement>el2=driver.findElements(By.cssSelector("div[class='feature-card p-3 mb-3 text-center']>p"));
        String[]str2={"Instead of viewing a screen in front of them, users are immersed and able to interact with 3D worlds.", "Virtual reality (VR) can create an environment similar to or completely different from the real world.", "Ability to recognize hand motion, evolving interactions and gameplay in VR.", "Interaction refers to the natural interaction between the user and the virtual scene.", "In 360-degree video, the locations of viewers are fixed, viewers are limited to the angles captured by the cameras.", "Virtual reality (VR) is a simulated experience that can be similar to or completely different from the real world."};
        String[]str3=new String[el2.size()];
        for(int i=0;i<el2.size();i++){
            str3[i]=el2.get(i).getText();
        }
        boolean match1=java.util.Arrays.equals(str2,str2);
        if(match1){
            System.out.println("All descriptions are as expected");
        }else{
            System.out.println("Mismatch found in Descriptions");
        }
        //Test Highlited Test:
        WebElement el5=driver.findElement(By.cssSelector("p[class='vr-features-card-description']>span[class='interaction']"));
        String Str1=el5.getText();
        String Str6="natural interaction";
        if(Str1.equals(Str6)){
            System.out.println("Highlighted text found");
        }else{
            System.out.println("Highlighted text notfound");
        }
driver.quit();
    }
    }

