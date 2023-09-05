package day08_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase1 {


    @Test
    public void windowsHandle1(){
    //● Tests package’inda yeni bir class olusturun: WindowHandle
    //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";

        Assert.assertTrue(expectedText.equals(actualText));

    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);

    //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        String window1handle = driver.getWindowHandle();

    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String e : allWindowHandles){
            if (!e.equals(window1handle) ){
                driver.switchTo().window(e);   // artik driver acilan 2. sekmeye gecer.
                break;
            }
        }
        String window2title = driver.getTitle();
        Assert.assertEquals("New Window",window2title);



    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText2 = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals("New Window",actualText2);
        String window2Handle = driver.getWindowHandle();

    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın
        driver.switchTo().window(window1handle);
        String window1title = driver.getTitle();
        Assert.assertEquals("The Internet",window1title);

    // 2. windowa tekrar gecelim
        driver.switchTo().window(window2Handle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 1.window'a tekrar gecelim
        driver.switchTo().window(window1handle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
