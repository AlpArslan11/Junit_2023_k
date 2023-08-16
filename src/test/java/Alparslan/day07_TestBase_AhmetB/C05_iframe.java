package Alparslan.day07_TestBase_AhmetB;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class C05_iframe extends TestBase1 {


        /*

        iframe'e geçiş için 3 yontem wardir.

            1- driver.switchTo().frame("name","id");
            2- driver.switchTo().frame("index ile");
            3- driver.switchTo().frame(frameElement/webelement)

        */





    @Test
    public void iframeTest(){
        //https://testcenter.techproeducation.com/index.php?page=iframe adresinde
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // Ana sayfadaki "An iframe with a thin black border:" metnin black border olduğunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";

        Assert.assertTrue(anaMetin.contains(expectedText));



        //iframe icersindeki "Applications lists" yazısının sayfada olduğunu test edelim
        driver.switchTo().frame(0);
        String actualIframeMetin= driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedText1 = "Applications lists";

        Assert.assertEquals(actualIframeMetin,expectedText1);

        // son olarak footer'daki "Povered By" yazısının varligini test edelim

      //  driver.switchTo().parentFrame(); --> parent frame cıkar
        driver.switchTo().defaultContent(); // default olan sayafaya cikti
        String footerText = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));





    }



}
