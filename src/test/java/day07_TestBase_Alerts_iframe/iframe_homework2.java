package day07_TestBase_Alerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

public class iframe_homework2 extends TestBase1 {
    //● Bir class olusturun: IframeTest
    @Test
    public void iframetest02(){
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin
        WebElement iframeText = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeText.isEnabled());
        System.out.println("iframe Yazısı --> " + iframeText.getText());

    //○Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().parentFrame();
        WebElement foorterText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(foorterText.isDisplayed());
        System.out.println("footer yazısı --> " + foorterText.getText());
    }
}
