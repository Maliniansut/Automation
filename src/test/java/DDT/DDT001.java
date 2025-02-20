package DDT;

import org.testng.annotations.Test;

public class DDT001 {

    //Excel-> There is no support in java to read excel file directly.
    //Apache POI Library
    //Three versions of excel -> xls,xlsx,csv(comma separated values)
    @Test(dataProvider="getData", dataProviderClass= UtilExcel.class)
    public void testLogin(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }
}
