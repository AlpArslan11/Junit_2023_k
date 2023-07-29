package Alparslan.day07_assertions;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_automationExercise {

    static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void automationExercise_Test() {

        //********** SITE KAPANMIŞ YAPAMADIM

        //  Bir Class olusturalim YanlisEmailTesti
        //2. http://automationpractice.com/index.php sayfasina gidelim
        //3. Sign in butonuna basalim
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    }

}
