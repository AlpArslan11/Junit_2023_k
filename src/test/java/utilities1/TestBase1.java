package utilities1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase1 { // abstract yapmamızın sebebi obje oluşturulmasını engellemek
        //Testbase testBase = new TestBase(); --> YAPILAMAZ
        // Amacım bu sınıfı extend etmek ve içindeki methodları kullanmak


    /*
    Bunları kullanmak isteyenler extends ile bu classdaki @Before ve @After icindeki methodları kullanır.
    Dolayısıyla diger test classları bu sınıfın child'i olur ve bu class parent class olur
    TestBase classi abstract yapabiliriz. Abstract yapmakta fayda var
    Bu classtan object create edemeyiz.
    --------
    ** bu class'in amacı obje oluşturmak degildir o nedenle biz "public abstract class" yaparız. bizim amacimiz sadece
    extend edip kullanmak istiyoruz.
    ----

    ********
    Olusturduğumuz driver'ı farklı package'lerdan kullanmak için PROTECTED yaparız.
    *******


    bazı resuable methodlar konabilir
    raporlama konulabilir

     */



        protected static WebDriver driver;  // farkli packagelerdan kullanmak için protected. inhertence yaptigimiz child classlarda kullnmkicin
        //public'de yapabilriz.
        // static yazmasakta olur

        @Before
        public void setup(){

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public void tearDown(){
            driver.quit();

        }


    /*
    !!!!!!!!!!!!! *****************
    bu iki switchToWindow() methodunda OVERLOAD yaptık. parametre data tipleri farkli,isimleri aynı
    */




        //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")
        public static void switchToWindow(String targetTitle) {
            String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return;//CIK. break;
                }
            }
            driver.switchTo().window(origin);
        }

    //    windowNumber sıfır (0)'dan başlıyor.
//    index numarasini parametre olarak alir
//    ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }


    /*   HARD WAIT:   1 testte 10 defa kullanırsak 30sn gitti. cok kullanmamali
             @param : second
            */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    }
