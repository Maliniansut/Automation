package TestNg;

import org.testng.annotations.*;

public class TestNg002 {
    @BeforeSuite
    void demo0(){
        System.out.println("Suite");
    }
    @BeforeClass
    void demo1(){
        System.out.println("Class");
    }
    @BeforeTest
    void demo2(){
        System.out.println("Test");
    }
    //Why->Reading of excel file
    //file Text,Json,Csv,Database
    //Configuration load Extra
    @BeforeMethod
    void demo4(){
        System.out.println("Before Coming to office");
    }

    //Test Cases would be written here
    @Test
    void demo5(){
        System.out.println("In the Office");
    }

    //Before and after method would run for number of test cases mentioned here.

    @Test
    void demo55(){
        System.out.println("In the Office");
    }


    //Close files here ->Write code here
    @AfterMethod
    void demo6(){
        System.out.println("After Coming from the office");
    }
}
