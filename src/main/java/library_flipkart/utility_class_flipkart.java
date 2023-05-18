package library_flipkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility_class_flipkart

{
	public static String Excel_data(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\AKSHAY\\eclipse-workspace\\Maven_Project_flipkart\\Excel_data_flipkart\\Flipkart_maven.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String Excel_data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return Excel_data;  
	}
	public  static void Screenshoot_flipkart(WebDriver driver,int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\AKSHAY\\eclipse-workspace\\Maven_Project_flipkart\\Screenshot\\testNo ="+System.currentTimeMillis()+TCID+".jpg");
		FileHandler.copy(source, destination);
	}
	public static String Property_file_flipkart(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\AKSHAY\\eclipse-workspace\\Maven_Project_flipkart\\property.properties");
		Properties pro=new Properties();
		pro.load(file);
		String value = pro.getProperty(key);
		return value;
	}
}



