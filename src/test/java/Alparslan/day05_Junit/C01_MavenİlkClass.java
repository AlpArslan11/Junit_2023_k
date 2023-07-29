package Alparslan.day05_Junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenİlkClass {
    public static void main(String[] args) {

    //   WebDriverManager.chromedriver().setup();
        // selenium-java 4 ile artık bonie garcia elveda dedik.
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://wwww.amazon.com");

        driver.close();





    }
}
