package day14_ScreenShots_ExtentReport;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities1.TestBase1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class C02_ScreenShot2 extends TestBase1 {

    @Test
    public void screenshotOfSpecificElements() throws IOException {
//        Techpro education a git
        driver.get("https://www.techproeducation.com");
//        logonun goruntusunu al

//        1. ekran goruntusunu cek
        WebElement logoTechPro=driver.findElement(By.xpath("(//*[@alt='TechPro Education'])[1]"));
        File image = logoTechPro.getScreenshotAs(OutputType.FILE);
//        2. goruntuyu kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        takeScreenshotOfElement(driver.findElement(By.cssSelector(".toolbar-sl-share")));


    }
}