package day06_AhmetB;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

     static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void selectByIndexTest(){

       //  Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasındayken


        // Dogum yılını 2000, ayını January ve gununu 10  seçer

        // 1- Locate dropdown element
        WebElement year = driver.findElement(By.id("year"));
        // 2- Select objesi oluştur.
        Select select =new Select(year);
        // 3- Select objesini kullanarak 3 farkı şekide seçim yapabilirm.
        select.selectByIndex(23);

        WebElement month = driver.findElement(By.id("month"));
        select = new Select(month);
        select.selectByValue("0");

        WebElement day = driver.findElement(By.id("day"));
        select = new Select(day);
        select.selectByVisibleText("10");

    }

    @Test
    public void printAll(){
        //  Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasındayken

       // Tum eyalet isimlerini consola yazdiralim
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(state);
        List<WebElement> stateList =select.getOptions();

        for (WebElement e : stateList){
            System.out.println(e.getText());
        }
        System.out.println();
        System.out.println("****** Lambda ile***** \n");
               stateList.stream().forEach(t-> System.out.println(t.getText()));


    }

    @Test
    public void getFirstSelectedOption(){
        //  Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasındayken

        //      State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select select = new Select(state);
        String varsayilanElement = select.getFirstSelectedOption().getText();
        Assert.assertEquals("varsayılan olarak Select a State secili degil",
                varsayilanElement,"Select a State");

        // State'i Arkansas seçelim

        select.selectByValue("AR");


        // Arkansas seçili olduğunu tyest edelim
        Assert.assertEquals("secili eyalet Arkansas değil",
                select.getFirstSelectedOption().getText(),"Arkansas");


        //State dropdown'daki tum elementleri yazdiralim

        List<WebElement> stateList =select.getOptions();
        for (WebElement e : stateList){
            System.out.println(e.getText());
        }

    }
        /*
    1. What is dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.

    2. How to handle dropdown elements? Dropdown nasil automate edilir?
    -dropdown i locate ederim
    -select objesi olustururum
    -select objesi ile istedigim secenegi secerim
    NOT: select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasi

    3. Tum dropdown seceneklerini nasil print ederiz?
    - tum dropdown elementlerini getOptions() methodu ile listeye koyariz
    - sonra secenekleri loop ile yazdirabilirz

    4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    Ornek: Gun olarak 10 i secdik ama ya secilmediyse?
    getFirstSelectedOption() secili olan secenegi return eder
     */



}
