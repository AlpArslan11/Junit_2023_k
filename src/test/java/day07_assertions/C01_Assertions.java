package day07_assertions;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    static WebDriver driver ;

    @BeforeClass
    public static void setUP(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    @Test
    public void test01() {


        // 3 farklı test methodu oluşturarak aşağıdaki görevleri yapın
        // 1- url'nin amazon içerdiğini test edin
        String arananKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue("aranan Kelime yok", actualUrl.contains(arananKelime));
    }

    @Test
    public void test02() {
            //2- title'in facebook içermediğini test edin
        String arananKelime = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse("aranan kelimeyi iceriyor. hata",actualTitle.contains(arananKelime));
        }


    @Test
    public void test03() {

        //3- sol ust köşede amazon logosunun gorundugunu test edin.
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue("logo görüntülenmiyor",amazonLogo.isDisplayed());
    }










}
