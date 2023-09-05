package day07_TestBase_AhmetB;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class C03_dismissAlert extends TestBase1 {

    @Test
    public void dismisAlertTest() throws InterruptedException {
        //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");
        WebElement alertButton = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]"));

        alertButton.click();
        Thread.sleep(200);


        driver.switchTo().alert().dismiss();

        //resultmesajının “You clicked: Cancel” oldugunu test edin.

        String actualResult = driver.findElement(By.xpath("//*[contains(text(),'You clicked: Cancel')]")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals("alert metin yazisi uyuşmuyor",actualResult,expectedResult);
    }

}
