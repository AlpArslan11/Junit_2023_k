package Alparslan.day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities1.TestBase1;

import java.time.Duration;

public class C03_FluentWait extends TestBase1 {



    @Test
    public void fluentWaitTest(){

    //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

    //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

    //Hello World! Yazının sitede oldugunu test et

        // FLUENT WAIT
        // 1- Fluent Wait  için bir obje oluştur
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // max bekleme süresi
                .pollingEvery(Duration.ofSeconds(3)) // deneme aralığı
                .withMessage("IGNORE EXCEPTION") // mesaj yazabilirim.zorun deil
                .ignoring(NoSuchMethodException.class); //Exception'ı handle et





    }




}
