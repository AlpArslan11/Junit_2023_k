package Alparslan.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

public class WindowHandle_Homework extends TestBase1 {


    @Test
    public void windowHandleTest(){
        //● https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //● Title in ‘Windows’ oldugunu test edin
       String title = driver.getTitle();

        //● Click here a tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        String window1 = driver.getWindowHandle();

        //● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        switchToWindow("New Window");
        String window2 = driver.getTitle();
        System.out.println(window2);
        Assert.assertEquals(window2,"New Window");


    }

}
