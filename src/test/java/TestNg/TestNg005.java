package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNg005 {
    @DataProvider
    public Object [][] getData(){
        return new Object[][]{
                new Object[]{"admin","admin","ER"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password"},
                new Object[]{"admin","password123"},
        };

    }
    @Test(dataProvider = "getData")
    public void loginTest (String username, String password, String ER){
        System.out.println(username);
        System.out.println(password);
        System.out.println(ER);
    }
}
