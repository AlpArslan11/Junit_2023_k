package day12_FileUpload_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities1.TestBase1;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase1 {


    @Test
    public void explicitWaitTest(){
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test e

     //-->   WebElement helloWorldText = driver.findElement(By.xpath("//div[@id='finish']//h4"));
     //-->   Assert.assertEquals("Hello World!",helloWorldText.getText());

        // !!!!!!!!!!!!!!!!!!!
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // IMPLICIT WAIT ile test case calismadi
        // Cozum explicit waitde


        // EXPLICIT WAIT
        // 1-> WebDriverWait objesini oluştur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 2-> Wait objesini kullanarak bekleme problemini çözmeye calis
        WebElement helloWorldELement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        String helloWorldText = helloWorldELement.getText();

        Assert.assertEquals("Hello World!",helloWorldText);



    }
}
