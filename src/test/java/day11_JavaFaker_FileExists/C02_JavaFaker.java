package day11_JavaFaker_FileExists;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    Faker faker;

    @Test
    public void javaFakerTest(){
        // https://medium.com/@nairgirish100/using-java-faker-for-test-automation-b9a99a7fd3fb

                /*
        TEST DATA : kullanicai adi, sifre, tel no, email, sehir, kredi kart no,...
        Test datalarini kimden alinir?
        1. BA-Business analyst (Acceptance Criteria lari yazar)
        2. Test Lead
        3. Manual Tester
        4. Tech Lead & Team Lead & Dev Lead
        5. Developer
        6. Database
        7. API call lar
        8. Documantasyonlar. Ognegin, API swagger documani.
        9. Java Faker da fake data almak icin kullanyoruz
        NERDEN GELMEZ : end user -kullanicidan, scrum master,
         */





        // 1. Faker objkesi oluştur
        faker = new Faker();

        // 2. Faker objesi ile fake data oluşturur.

        //first name datası
        String fName = faker.name().firstName();
        System.out.println(fName);

        // last name datası
        String lName = faker.name().lastName();
        System.out.println(lName);

        // username
        String userName = faker.name().username();
        System.out.println(userName);

        // meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        // full adress
        System.out.println(faker.address().fullAddress());

        // book
        System.out.println(faker.book().title());

        // cep telefonu numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        // email
        System.out.println(faker.internet().emailAddress());

        // rastgele 10 haneli numara
        System.out.println(faker.number().digits(15));

        // kredi kartı no
        System.out.println("kredi kart no  " + faker.finance().creditCard());
        //System.out.println(faker.finance().iban());




    }


}
