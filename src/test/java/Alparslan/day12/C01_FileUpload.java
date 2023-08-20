package Alparslan.day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities1.TestBase1;

public class C01_FileUpload extends TestBase1 {

    @Test
    public void fileUploadTest() throws InterruptedException {

        //1. Tests packagenin altina bir class oluşturun :
        //C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine
        driver.get("https://the-internet.herokuapp.com/upload");
        //gidelim
        //3. chooseFile butonuna basalim
        String filePath = System.getProperty("user.home") + "\\Desktop\\logo.jpg";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        Thread.sleep(3000);

        //4. Yuklemek istediginiz dosyayi secelim.

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());


    }



}
