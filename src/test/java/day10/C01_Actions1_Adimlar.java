package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities1.TestBase1;

public class C01_Actions1_Adimlar extends TestBase1 {


        /*
        ➢ 1.Adım: Actions class’ta bir object oluşturulur.
        Actions actions= new Actions(driver);
        ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement
        öğesini bulunur.
        WebElement element = driver.findElement(locator);
        ➢ 3.Adim : perform() kullanarak bu webelement üzerinde
        action gerçekleştirilir.
        ➢ Örneğin tıklamak için.
        actions.click(element).perform( );
        NOT : 1. Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez. Ayni obje tekrar tekrar driver
        objesi gibi kullanilabilir
        2. action objesi kullanilarak baslayan her komut, calismak icin perform( ) bekler


        """"""""""""""
        1-Adım
        ---> ACTIONS objesi olustur. içine parametre olarak DRIVER yaz

        2-Adım
        ---> ELEMENTI locate et. methodlar içine parametre olarak locate'i kullan

        3-Adım
        ---> Calistirmak istedigim methodu PERFORM() ile bitir. Yoksa çalışmaz.
         */


    @Test
    public void actionsRightClickTes(){


        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        //Kutuya sag tıklayın
        WebElement kutu= driver.findElement(By.id("hot-spot"));
        actions.moveToElement(kutu).perform();
        actions.contextClick(kutu).perform();
        waitFor(2);

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();


    }
}
