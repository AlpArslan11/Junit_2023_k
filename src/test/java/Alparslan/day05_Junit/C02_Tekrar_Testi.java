package Alparslan.day05_Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C02_Tekrar_Testi {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //1-C01_TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin

        //4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")){
            System.out.println("title test PASSED");
        } else System.out.println("title test FAILED");

        //5. Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Nutella", Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //6. Bulunan sonuc sayisini yazdirin
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Bulunan sonuc yazisi  --> " + sonucYazisi);

        //7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc[] = sonucYazisi.split(" ");
        String sayiStr = sonuc[1].replace(".","");
        int sayi = Integer.parseInt(sayiStr);
        System.out.println("Bulunan sonuc =" + sayi);
        if (sayi>10000000){
            System.out.println("arama sonuç sayısı testi PASSED");
        }else System.out.println("arama sonuç sayısı testi FAILED");

        //8. Sayfayi kapatin
        driver.close();


    }
}
