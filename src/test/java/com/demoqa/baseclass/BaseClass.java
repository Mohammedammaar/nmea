package com.demoqa.baseclass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static Select s;
public static JavascriptExecutor js;
public static WebElement ele;
public static Object value=null;
public static Object[][] twoDimArray=null;
public static void launchBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\Sel\\res\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
}
public static void launchBrowsers(String browserName) {
	WebDriverManager.chromedriver().setup();
	WebDriverManager.edgedriver().setup();
	if (browserName.equals("edge"))
	{
		driver = new EdgeDriver();
		
	}
	
	else if(browserName.equals("chrome"))
	{
		driver = new ChromeDriver();
		
	}
}
public static void url(String url) {
	driver.get(url);
}
public static  void windowsMax() {
	driver.manage().window().maximize();
}
public static void byID(String id) {
	ele=driver.findElement(By.id(id));
}
public static void byxpath(String xpath) {
	ele=driver.findElement(By.xpath( xpath));
}
public static void byTag(String tag) {
	ele=driver.findElement(By.id(tag));
}
public static WebElement sendKeys(WebElement ele,String keys) {
	ele.sendKeys(keys);
	return ele;
}

public static WebElement clk(WebElement ele) {
	ele.click();
	return ele;
}
public static void selectText(WebElement ele, String data) {
	Select s =new Select(ele);
	s.selectByVisibleText(data);
}
public static void selectindex(WebElement ele, int i) {
	Select s =new Select(ele);
	s.selectByIndex(i);
}
public static void byclass(By by) {
	ele= driver.findElement(by);
	}
public static void scroll(String scrol) {
	js=(JavascriptExecutor) driver;
	js.executeScript(scrol,ele);
	
	
}
public static String readProp(String Key) {
	String value=null;
	try {
		
		FileReader fil=new FileReader("C:\\Users\\HP\\eclipse-workspace\\Sel\\files\\data.properities");
		Properties prop=new Properties();
			prop.load(fil);
			value=prop.getProperty(Key);
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();}
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return value;
	}
	
public static String readValueForExcel(String sh,int r,int c) {
	String value=null;
	try {

		String path = "C:\\Users\\HP\\eclipse-workspace\\MavenAbs\\src\\test\\resources\\test data\\amr.xlsx";
		File f = new File(path);
		
		FileInputStream fls = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fls);
		Sheet sht =wb.getSheet(sh);
		Row rr = sht.getRow(r);
		Cell cc = rr.getCell(c);
		int cellType=cc.getCellType();
		if(cellType==1) {
			value=cc.getStringCellValue();
			}
		else {
			double num=cc.getNumericCellValue();
			long a=(long) num;
			value=String.valueOf(a);
		}
	}
		
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return value;


	
}
public static void excelWriteValue(String sh,int r,int c,String val) {
	try {
		String path="C:\\Users\\HP\\eclipse-workspace\\DemoQa\\src\\test\\resources\\Book2.xlsx";
	    File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sht =wb.createSheet(sh);
		Row rr = sht.createRow(r);
		Cell cc = rr.createCell(c);
		cc.setCellValue(val);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
				
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void excelWriteValues(String sh,int r,int c,String val) {
	try {
		String path="C:\\Users\\HP\\eclipse-workspace\\DemoQa\\src\\test\\resources\\Book2.xlsx";
	    File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sht =wb.getSheet(sh);
		Row rr = sht.createRow(r);
		Cell cc = rr.createCell(c);
		cc.setCellValue(val);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
				
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
public static void waitIMP(long a) {
	driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
}
public static String getAttribute(String id) {
	WebElement textData = driver.findElement(By.id(id));
	return textData.getAttribute("value");

}
public static String tittle() {
	String s=driver.getTitle();
	return s;
}
public static Object[][] excelreadalldataformat() throws IOException {
	
	File f = new File("C:\\Users\\HP\\eclipse-workspace\\MavenAbs\\src\\test\\resources\\test data\\amr.xlsx");
	FileInputStream fis = new FileInputStream(f);		
	Workbook wb = new XSSFWorkbook(fis);			
	Sheet sheet = wb.getSheet("Sheet1");			
	int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
	int physicalNumberOfCells=sheet.getRow(0).getPhysicalNumberOfCells();
	twoDimArray=new Object[physicalNumberOfRows-1][physicalNumberOfCells];
	for (int i = 1; i < physicalNumberOfRows; i++) {
		Row row = sheet.getRow(i);					
		for (int j = 0; j < physicalNumberOfCells; j++) {
			Cell cell = row.getCell(j);					
			int cellType = cell.getCellType();
			if (cellType == 1) 
			{
				value = cell.getStringCellValue();						
			} 
			else if (cellType == 0) 
			{
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("MMM/dd/yyyy");
					value = s.format(dateCellValue);							
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value=String.valueOf(l);							
				}						
			}		
			//System.out.println(value);
			twoDimArray[i-1][j]=value;					
		}
		
					}
	return twoDimArray;
}


}

