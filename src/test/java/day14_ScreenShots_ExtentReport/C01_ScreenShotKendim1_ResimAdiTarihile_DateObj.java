package day14_ScreenShots_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities1.TestBase1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShotKendim1_ResimAdiTarihile_DateObj extends TestBase1 {

    @Test
    public void fullPageScreenShot() throws IOException {
        // 1.Techpro education a git ve Sayfanin goruntusunu al

        driver.get("https://www.techproeducation.com");



        // ekran goruntusu almak için olusturduk. aldiğimiz goruntuyu File türünde kaydettik.
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // resim dosyasını daha dinamik yapmak için isimlendirmeyi tarih ile yapalim.
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        System.out.println("GÜnün tarihi --->  " + currentDate);

        // aldiğim ekran goruntusunu kaydetmek için path olusturdum
        String path = System.getProperty("user.dir") + "/test-output/ScreenShots/" +currentDate + "image.png";

        // Alinan goruntuyu resim olarak kaydedelim. copyFile() methodu parametre olarak içine File ister.
        //o yuzden önce pathi bir file a atarız. Ayrıca copyFile() methodu CTE verir. o yuzden exception yapariz
        FileUtils.copyFile(goruntu,new File(path));

        ////        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
        ////        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
        ////                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path


        //2-“QA” aramasi yap
        //  driver.findElement(By.id("searchHeaderInput")).sendKeys("QA" , Keys.ENTER);

        //3.Acilan sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa

    }




}
