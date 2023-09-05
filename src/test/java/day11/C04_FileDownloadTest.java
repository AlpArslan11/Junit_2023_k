package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase1 {


    @Test
    public void fileDownloadTest() throws InterruptedException {
        //1.Class : FileDownloadTest Method : downloadTestExist
        //2https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //3.b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        Thread.sleep(3000);

        //4.Dosyanın başarıyla indirilip indirilmediğini test edelim
            String filePath = System.getProperty("user.home") +"\\Downloads\\b10 all test cases, code.docx"  ;

        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue("dosya indirilmedi", isDownloaded);



    }


}
