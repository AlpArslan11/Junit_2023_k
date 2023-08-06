package utilities1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
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



    }
