package com.basefunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


 
public class GenericLib {
	public static String configfilePath=BaseClass.sdirPath+"\\config.properties";
	public static String excelpath=BaseClass.sdirPath+"\\boappdata.xlsx";
      
	
	public static String getProperties(String key){
		String svalue=null;
				try
				{
					FileInputStream file=new FileInputStream(configfilePath);
					Properties properties=new Properties();
					properties.load(file);
					svalue=properties.getProperty(key);
					}catch(Exception e){
					e.printStackTrace();
				}
				return svalue;
	}
    
	public static void hideKeypad(){
		try{
			BaseClass.driver.hideKeyboard();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*public static String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String sdata=null;
		FileInputStream file=new FileInputStream(excelpath);
		Workbook wb=(Workbook)new WorkbookFactory().create(file);
		Sheet sh=wb.getSheet("logindata");
		sdata=sh.getRow(row).getCell(cell).getStringCellValue();
		return sdata;
		
		
		
	}*/
}
