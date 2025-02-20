package DDT;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class UtilExcel {
    //Workbook,Excel,row,column,cell
    //Steps to read excel file
    // Open stream -> Understand Workbook ->Sheet->Row,Column -> Cells -> Close Stream (give data to the Object[][])
    static Workbook book;
    static Sheet sheet;

    public static String FILE_NAME = "src/test/java/resource/TestData.xlsx";

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file =null;
        try{
            file= new FileInputStream(FILE_NAME);
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        try{
            book= WorkbookFactory.create(file);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        sheet= book.getSheet(sheetName);
        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i< sheet.getLastRowNum();i++){
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data [i][j]=sheet.getRow((i+1)).getCell(j).toString(); //i+1 because we want to skip the headers(column names) in excel file
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getData(){
        return getTestData("sheet1");
    }


}
