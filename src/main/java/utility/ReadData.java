package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
  public static String readdata1(int rownum , int colnum) throws EncryptedDocumentException, IOException 
  {
	  FileInputStream file = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\first_project\\Clustered HR Data\\Book1.xlsx");
	  Sheet es = WorkbookFactory.create(file).getSheet("Sheet3");
	  String value = es.getRow(rownum).getCell(colnum).getStringCellValue();
	  return value ;
  }
}
	

