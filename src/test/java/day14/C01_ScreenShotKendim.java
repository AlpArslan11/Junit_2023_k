package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.TestBase1;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShotKendim extends TestBase1 {

    @Test
    public void fullPageScreenShot() throws IOException {
        // 1.Techpro education a git ve Sayfanin goruntusunu al

        driver.get("https://www.techproeducation.com");



        // ekran goruntusu almak için olusturduk. aldiğimiz goruntuyu File türünde kaydettik.
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // aldiğim ekran goruntusunu kaydetmek için path olusturdum
        String path = System.getProperty("user.dir") + "/test-output/ScreenShots/image.png";

        // Alinan goruntuyu resim olarak kaydedelim. copyFile() methodu parametre olarak içine File ister.
        //o yuzden önce pathi bir file a atarız. Ayrıca copyFile() methodu CTE verir. o yuzden exception yapariz
        FileUtils.copyFile(goruntu,new File(path));

        ////        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
        ////        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
        ////                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path


        //2-“QA” aramasi yap
      driver.findElement(By.id("searchHeaderInput")).sendKeys("QA" , Keys.ENTER);

        //3.Acilan sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa



    }


}
