package Alparslan.day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {



    @Test
    public void fileExistsTest(){

       String userDIR = System.getProperty("user.dir");
       System.out.println(userDIR); //C:\Users\asd\IdeaProjects\2023\com.2023_Junit_ortak

       String userHOME = System.getProperty("user.home");
       System.out.println(userHOME);  // C:\Users\asd

       //masaüstüne logo.jpg kaydedelim
       // sonra dosyanın varlığını test edelim

       String filePath = userHOME + "\\Desktop\\logo.jpg";  // Windows için \\ slash ile calisir.
        System.out.println(filePath);

        boolean isExist = Files.exists(Paths.get(filePath)); // dosya var ise TRUE toksa FALSE
        Assert.assertTrue(isExist);
        System.out.println(isExist);
    }
}
