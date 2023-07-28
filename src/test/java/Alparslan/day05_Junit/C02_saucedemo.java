package Alparslan.day05_Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C02_saucedemo {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        List<WebElement> urunlerListesi = driver.findElements(By.xpath("//*[@class='inventory_list']"));
        for (WebElement e: urunlerListesi
             ) {
            System.out.println(e.getText());
        }
        urunlerListesi.get(0).click();
        WebElement ilkUrun = driver.findElement(By.id("item_4_title_link"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //6. Add to Cart butonuna basin
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin

        if (driver.findElement(By.id("item_4_title_link")).isDisplayed()){
            System.out.println("Sepet testi PASSED");
        }else   System.out.println("Sepet Testi FAILED");


        //9. Sayfayi kapatin
        driver.close();

    }



}
