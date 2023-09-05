package day11_JavaFaker_FileExists;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities1.TestBase1;

public class Homework_04_FakerKutuphanesi extends TestBase1 {


    Faker faker ;
    Select select ;

    @Test
    public void fakerTest() throws InterruptedException {
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://www.facebook.com");
        //2. “create new account” butonuna basin
        WebElement createNewAccButton = driver.findElement(By.xpath("//a[.='Yeni hesap oluştur']"));
        createNewAccButton.click();

        //3. “firstName” giris kutusuna bir isim yazin
        WebElement firstNameTextBox = driver.findElement(By.name("firstname"));
        faker = new Faker();
        firstNameTextBox.sendKeys(faker.name().firstName());
        Thread.sleep(1000);

        //4. “surname” giris kutusuna bir soyisim yazin
        WebElement lastNameTextBox = driver.findElement(By.name("lastname"));
        lastNameTextBox.sendKeys(faker.name().lastName());
        Thread.sleep(1000);

        //5. “email” giris kutusuna bir email yazin
        WebElement emailTExtBox = driver.findElement(By.name("reg_email__"));
        String email = faker.internet().emailAddress();
        emailTExtBox.sendKeys(email);
        Thread.sleep(1000);

        //6. “email” onay kutusuna emaili tekrar yazin
        WebElement emailConfirmTextBox = driver.findElement(By.name("reg_email_confirmation__"));
        emailConfirmTextBox.sendKeys(email);

        //7. Bir sifre girin
        WebElement passwordTextBox = driver.findElement(By.xpath("//*[@data-type='password']"));
        passwordTextBox.sendKeys(faker.internet().password());
        Thread.sleep(1000);

        //8. Tarih icin gun secin
        WebElement dayDdm  = driver.findElement(By.id("day"));
        select = new Select(dayDdm);
        select.selectByVisibleText("8");
        Thread.sleep(1000);


        System.out.println(select.getFirstSelectedOption().getText());

        //9. Tarih icin ay secin
        WebElement monthDdm  = driver.findElement(By.id("month"));
        select = new Select(monthDdm);
        select.selectByVisibleText("May");
        Thread.sleep(1000);

        //10. Tarih icin yil secin
        WebElement yearDdm  = driver.findElement(By.id("year"));
        select = new Select(yearDdm);
        select.selectByVisibleText("2000");
        Thread.sleep(1000);

        //11. Cinsiyeti secin
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

        male.click();
        Thread.sleep(3000);
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
        //edin.
        Assert.assertTrue("Erkek secili degil",male.isSelected());
        Assert.assertFalse("Bayan secili",female.isSelected());
        Assert.assertFalse("Ozel seçili",custom.isSelected());
        //13. Sayfayi kapatin
    }






}
