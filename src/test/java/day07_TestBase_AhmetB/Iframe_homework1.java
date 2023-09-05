package day07_TestBase_AhmetB;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

import java.util.List;

public class Iframe_homework1 extends TestBase1 {
    //● Bir class olusturun: IframeOdev

    @Test
    public void iframeTest() throws InterruptedException {

    //1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

    //2) sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeCount = driver.findElements(By.xpath("//iframe"));
        System.out.println("sayfadaki toplam iframe sayısı = " + iframeCount.size());

    //3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.

        String actualText = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedText = "Editor";
        Assert.assertTrue(actualText.contains(expectedText));

    //4) Paragrafdaki yaziyi silelim
        WebElement iframeElement = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframeElement);
        WebElement actualTextinParagraph = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        actualTextinParagraph.clear();

        Thread.sleep(2000);


    //5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım

        actualTextinParagraph.sendKeys("iframe içindeyim");
        Thread.sleep(2000);

    //6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        WebElement actualTextFooter = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(actualTextFooter.getText().contains("Elemental Selenium"));

    }
}
