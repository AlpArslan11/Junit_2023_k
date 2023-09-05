package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C01_Actions5_interviewSoruları extends TestBase1 {



    @Test
    public void shiftTusunaBasarakYazma(){


        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK) Ve ENTER tusuna bas


        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        actions.keyDown(searchBox,Keys.SHIFT)
                .sendKeys( "iPhone X fiyatlari")
                .keyUp(Keys.SHIFT)
                .sendKeys("  cok pahali!" + Keys.ENTER )
                .build()
                .perform();

        waitFor(3);


    }

        /*
        1- Actions nedir? Actions Class nedir ?
            *Actions selenium dan gelen bir kütüphanedir. Mouse ve Keyboard islemlerini gerçekleştirmek
        icin kullandigimiz hazır bir selenium kutuphanesidir. Ornegin, sag tiklamak(contextClick),
        çift tıklamak(doubleClick), elementin uzerine gitmek(moveToElement) gibi mouse islemlerini
        gerçekleştirebiliriz. Ayni zamanda, shift, control, delete, enter gibi keyboard tuslarinada
        actions yardımıyla basabiliriz. Bu tur islemlerde sendKeys metodu kullaninir.

        2- Ne tur methodlar kullandin?
            Actions metotlari onemlidir. Ve tekrar tekrar kullanmam gerektiğinden, Actions metotlarını
        içeren Reusable metodları oluşturdum. Ve gerektiğinde bu reusable metodları kullanıyorum.
        Ornegin contextClick() methodunu bir elemente saga tiklamak icin test classimda cagira bilirim.

        3- Hangi methodlari kullandin ne ne ise yarar?
         Ornegin, sag tiklamak(contextClick), çift tıklamak(doubleClick), elementin uzerine
        gitmek(moveToElement) gibi mouse islemlerini gerçekleştirebiliriz. Ayni zamanda, shift,
        control, delete, enter gibi keyboard tuslarinada actions yardımıyla basabiliriz. Bu tur
        islemlerde sendKeys metodu kullaninir
         */








}
