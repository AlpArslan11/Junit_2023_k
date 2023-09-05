package day07_assertions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class C04_DropDownMenu {

    static WebDriver driver;



    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dropDown_test(){
        driver.get("https://www.amazon.com");
        //dropdowndan 1 option seçmek için 3 adim vardir
        // 1. adim. Dropdown locate et
        WebElement ddm = driver.findElement(By.cssSelector("#searchDropdownBox"));

        // 2. adim bir select objesi olusturup parametre olarak 1 önceki adimda locate ettiğimiz ddm'yi girelim
        Select select = new Select(ddm);


        //3. adim - dropdown'da varolan optionlardab istediğimiz 1 taneyi secelim
        /*
        select.selectByVisibleText();  --> görünür isimle seçer
        select.selectByIndex();  --> index ile seçer
        select.selectByValue();  --> value/değer ile seçiyor
*/
        // amazona gidip dropdown'dan books seçeneğini seçip java aratalim
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);



        // arama sonuclarinin Java içerdiğini test edin
        String aramaSonuc = driver.findElement(By.xpath("(//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')])[1]")).getText();
        Assert.assertTrue("arama sonucu Java İcermiyor",aramaSonuc.contains("Java"));

        // arama sonuclarinin 500'den fazla olduğunu test edin
        System.out.println("arama sonucu" + aramaSonuc);

        String []sonucArr = aramaSonuc.split("over");
        System.out.println(Arrays.toString(sonucArr));

        int aramaSonucSayisi = parseInt(sonucArr[1].replaceAll("\\D",""));
        System.out.println(aramaSonucSayisi);

        Assert.assertTrue("arama sonuc sayisi 500'den küçük",aramaSonucSayisi>500);

    }






}
