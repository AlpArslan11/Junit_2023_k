package Alparslan.day05_Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroWebApp {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //3. Login alanine “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("#pay_bills_link")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("100");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edi

        if (driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).isDisplayed()) {
            System.out.println("Test Passed");
        }else System.out.println("Test Faıled");



        driver.quit();

    }
}
