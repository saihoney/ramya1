package com.ramya;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class raj {
	FirefoxDriver driver;
    @Test
    public void Setup() throws IOException
    {
    	FileOutputStream f1= new FileOutputStream("C:\\Users\\qdge\\mavenramya\\src\\test\\java\\com\\ramya\\links.xlsx");
    	XSSFWorkbook wb=new XSSFWorkbook();
    	XSSFSheet ws=wb.createSheet("Sheet1");
    	
    driver=new FirefoxDriver();
    driver.get("http://bing.com");
   WebElement block= driver.findElement(By.id("sc_hdu"));
   
    List<WebElement> list1=block.findElements(By.tagName("a"));
    System.out.println(list1.size());
    for(int i=0;i<list1.size();i++)
    {
    	System.out.println("raj1");
    	if(list1.get(i).isDisplayed())
    	{
    		System.out.println("raj2");
    		list1.get(i);
    		Row r=ws.createRow(i);
    		Cell c=r.createCell(0);
    		
    		String str=list1.get(i).getText();
    		System.out.println("raj3");
    		String acturl=list1.get(i).getAttribute("href");
    		String expurl=driver.getCurrentUrl();
    		list1.get(i).click();
    		System.out.println("raj4");
    		
    		c.setCellValue(str);
    		c=r.createCell(1);
    		c.setCellValue(acturl);
    		if(acturl.contains(expurl))
    		{
    			c=r.createCell(2);
    			c.setCellValue("passed");
    		}
    		else
    		{
    			c=r.createCell(2);
    			c.setCellValue("failed");	
    		}
    		driver.navigate().back();
    		  block= driver.findElement(By.id("sc_hdu"));
    		list1=block.findElements(By.tagName("a"));
    		
    	}
    }
    wb.write(f1);
    f1.close();
     
}
}
