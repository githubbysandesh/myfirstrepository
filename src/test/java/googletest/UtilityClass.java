package googletest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass extends BaseTest {

	        //screenShot
	        //scrollIntoView
			//read data from excel
			//wait
			//read data from property file
		
			
				
			public static void captureScreenShot(String fileName) throws
			IOException
			{
			 
				Object screenShotSubFolderName = null;
				if(screenShotSubFolderName== null) {    //if screenShotSubFolderName is null then
				LocalDateTime myDateObj = LocalDateTime.now();//create object of local date
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HH_mm_ss");//make formate of name as per time output
		        screenShotSubFolderName= myDateObj.format(myFormatObj); //storage in variable nothing but screenShotSubFolderName
				File dir = new File("E:\\New folder2\\google\\ScreenShot\\"+screenShotSubFolderName);//pass arg. in file interface
				
				// to check weather it create or not   
				 boolean bool = dir.mkdir();  
				 if(bool){  
				 System.out.println("Folder is created successfully");  
				 }
				 else{  
				 System.out.println("Error Found!");  
				 } 
				 
				File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest= new File("E:\\New folder2\\google\\ScreenShot\\"+screenShotSubFolderName+"\\"+fileName);
				System.out.print(fileName);
				FileHandler.copy(src, dest);
				}   
				 
				}
			
			public static void scrollIntoView(WebDriver driver, WebElement element)
			{
			Reporter.log("SCrolling into view", true);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
			}
			/*
			public static void readDataFromExcel(int rowNum, int cellNum) throws IOException {
				String myFile=".\\TestData\\google.xlsx";
				FileInputStream myFile1= new FileInputStream(".\\TestData\\google.xlsx");
			
				XSSFWorkbook workbook = new XSSFWorkbook(myFile1)	;
				
				return value;
			}
			*/
			
			
			//readDataFromExcel
			public static String readDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
			{
			FileInputStream myFile= new FileInputStream("E:\\New folder2\\google\\TestData\\google.xlsx");
			String value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
			System.out.print("excel output"+value);
			return value;
			}
			
			public static void waitTime(int waitTimeSec) throws InterruptedException
			{
			Thread.sleep(waitTimeSec);
			Reporter.log("waiting for "+waitTimeSec+" milisec", true);
			}

			

}
