package Alparslan.day07_assertions;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuy {

       static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.bestbuy.com/ adresine gidin ffarklı test metodları olusturarak asağidaki testleri yapin
        driver.get(" https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void Url_test(){
        // sayfa URL'ninin https://www.bestbuy.com/ 'a eşit olduğunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";

        Assert.assertEquals("Sayfa URL'i dogru degil.",actualUrl,expectedUrl);

    }

    @Test
    public void title_test() {
        // title test --> sayfa başlığının "Rest" içermediğini (contains) test edin
        String actualTitle = driver.getTitle();
        String arananKelime = "Rest";

        Assert.assertFalse("actual title rest içeriyor. içermemesi gerek",actualTitle.contains("Rest"));
    }

    @Test
    public void logo_test() {
        // logo test --> BestBuy logosunun görüntülendiğini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("bestbuy logosu goruntulenmiyor",logo.isDisplayed());

    }

    @Test
    public void FrancaisLinkTest() {
        // FrancaisLinkTest --> Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLink = driver.findElement(By.xpath("//*[contains(text(),'Fran')]"));

        Assert.assertTrue("Fransizca dili linki goruntulenemiyor", fransizcaLink.isDisplayed());

    }






}
