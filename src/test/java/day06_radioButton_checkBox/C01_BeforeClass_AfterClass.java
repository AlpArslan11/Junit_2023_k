package day06_radioButton_checkBox;

import net.bytebuddy.build.Plugin;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

    static WebDriver driver;

    //BeforeClass ve @Afterclass methodlari sadece statik methodlar için çalışır


    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://wwww.amazon.com");

    }

    @Test
    public void test02(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03(){
        driver.get("https://wwww.facebook.com");
    }



}
