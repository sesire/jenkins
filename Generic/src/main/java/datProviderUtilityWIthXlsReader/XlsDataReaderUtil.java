package datProviderUtilityWIthXlsReader;

import java.util.ArrayList;

public class XlsDataReaderUtil {

    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){

    ArrayList<Object[]> myData = new ArrayList<Object[]>();
    try {
        reader = new Xls_Reader("/Users/URMI/SantanderBank/ProjectBank/DataFile/testfile.xls");
    }
    catch (Exception e){
        e.printStackTrace();
    }
     // change only sheet name in line 19
    for (int rowNum =2; rowNum <= reader.getRowCount("Sheet1"); rowNum++){
        String email = reader.getCellData("Sheet1", "email",rowNum );
        String password = reader.getCellData("Sheet1","password", rowNum);
        //String message = reader.getCellData("Sheet1","message", rowNum);
        Object obj[] = {email,password};
        myData.add(obj);
       }

    return  myData;
   }
}
