package day07_TestBase_Alerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class C04_prompt_confirmationAlert extends TestBase1 {

    @Test
    public void confirmAlertTest() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");
        //○ 3. butona tıklayın,
        WebElement alertButton = driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]"));
        alertButton.click();

        //uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Alparslan");
        System.out.println("alert uzerindeki yazı =  " + driver.switchTo().alert().getText());
        Thread.sleep(2000);

        // OK butonuna tıklayın ve
        driver.switchTo().alert().accept();


        // result mesajında isminizin görüntülendiğini doğrulayın
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "Alparslan";

        Thread.sleep(2000);
        Assert.assertTrue("prompt alerte yazilan metin goruntulenmiyor",actualResult.contains(expectedResult));
        Thread.sleep(3000);
    }
}
