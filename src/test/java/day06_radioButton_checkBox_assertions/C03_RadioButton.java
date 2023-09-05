package day06_radioButton_checkBox_assertions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    static WebDriver driver;

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
    // 1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
   @Test
    public void test01() throws InterruptedException {


    //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
       //- Cookies’i kabul edin
       //- “Create an Account” button’una basin
       WebElement newAccount = driver.findElement(By.xpath("//*[contains(text(),'Yeni hesap oluştur')]"));
       newAccount.click();

       //- “radio buttons” elementlerini locate edin
       WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
       WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
       WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

       //- Secili degilse cinsiyet butonundan size uygun olani secin
       Thread.sleep(1000);
        if (!male.isSelected()){
            male.click();
        }
       Thread.sleep(2000);
        female.click();
       Thread.sleep(2000);
       custom.click();
       Thread.sleep(2000);
       male.click();
   }





}
