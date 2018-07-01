package com.hustar.autoTestDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;


public class TestBaiduDemo {
	
	 WebDriver driver ;
	 //数据驱动测试---数据准备
	/* @DataProvider(name="searchWords")
	 public static Object[][]  words(){
		  return new Object[][] {{"蝙蝠侠","主演","迈克尔"},{"超人","导演","唐纳"},{"生化危机","编剧","安德森"}};
	 }*/
	 
	 //https://LAPTOP-LRO7FSU4/svn/testing/autoTestDemo
	 /*起始
	 //excel数据驱动测试--数据准备
	 @DataProvider(name ="TestData")
	 public static Object [][] words() throws IOException{
		 return getTestData("d://","TestData1.xlsx","Sheet1");
		 }
	 终点*/
	 
	 
	 
	//启动浏览器
	@BeforeTest
	@Parameters(value= {"registerPage","browserType","driverPath"})
	public void browserStart(String registerPage,String browserType ,String driverPath) {
		
		
		if ("chrome".equalsIgnoreCase(browserType )) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver =new ChromeDriver();
			driver .get(registerPage);
		}
		else if ("firefox".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver=new FirefoxDriver ();
			driver .get(registerPage);
		}
		else if ("ie".equalsIgnoreCase(browserType)) {
			System .setProperty("webdriver.ie.driver", driverPath);
			driver=new InternetExplorerDriver();
			driver .get(registerPage);
		}
		else {
			System .out.println("请指定浏览器类型");
		}
		
	}
	
	//健身网站测试
	//caseOne:login		
	@Test()
	public void fitness() throws InterruptedException {
		
		driver.get("https://www.hiyd.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"btn_ouj_login\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"ologin-mobile\"]")).sendKeys("18811021064");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"ologin-pwd\"]")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"btn_login_submit\"]")).click();
		Thread.sleep(3000);     
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div/a[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div[1]/ul/li[1]/a")).click();
		
	}
	
	
	//登录页面测试用例
/*	@Test
	public void loginTest() {
		System.out .println("成功点击登录链接11111");
		driver.findElements(By.name("tj_login")).get(1).click();
		//WebDriverWait wait = new WebDriverWait(driver,60);
		String currentWindow=driver.getWindowHandle();
		Set<String>  handles =driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		while (it.hasNext()) {
			
			String handle= it.next();
			if(currentWindow.equals(handle)) continue;
			WebDriver window= driver.switchTo().window(handle);
			//System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());
		}
		//driver.switchTo().windows();
	     System.out .println("成功点击登录链接");
	     driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
	  // driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
	     //driver.findElement(By.linkText("立即注册")).click();
	    
	     
	     //执行测试用例与Excel文件结合起来
	   
		}*/
	
	/*
	@AfterTest
	public void browserClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		System.out.println("关闭浏览器成功！");
		}
	
	*/
	
	
	//数据驱动测试----执行成功
	/*@Test(dataProvider="searchWords")
	public void searchData(String word1,String word2,String word3)throws InterruptedException {
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(word1+""+word2);
		driver.findElement(By.id("stb")).click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getPageSource().contains(word3));
		Thread.sleep(6000);
	}*/
	
	
	/*起始
	//数据驱动测试----从Excel中获取数据
	@Test(dataProvider="TestData")
	public void searchData(String word1,String word2,String word3) throws InterruptedException {
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(word1+""+word2);
		driver.findElement(By.id("stb")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains(word3));
		Thread.sleep(3000);
	}
	
	终点*/
	
	
	
	
	
	/*起始
	//从Excel文件中获取测试数据的静态方法----加载poi jar包
	public static Object[][] getTestData(String filepath,String filename,String Sheetname) throws IOException {
		File file=new File(filepath+"\\"+filename);
		FileInputStream inputStream=new FileInputStream(file);
		Workbook workbook = null ;
		//获取文件扩展名
		String fileExtensionName=filename.substring(filename.indexOf("."));
		//判断是.xlsx文件还是.xls文件，并进行实例化
		if(fileExtensionName.equals(".xlsx")) {
			workbook=new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")) {
			workbook=new XSSFWorkbook(inputStream);
		}
		
	  //通过sheetname生成sheet对象
		Sheet sheet=workbook.getSheet(Sheetname);
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		List<Object[]> records = new ArrayList<Object[]>();
		for(int i=0;i<rowcount+1;i++){
		Row row=sheet.getRow(i);
        String fields[] = new String[row.getLastCellNum()];
		  for(int j=0;j<row.getLastCellNum();j++) {
                fields[j] = row.getCell(j).getStringCellValue();
                }
		records.add(fields);
		}
		Object[][] results=new Object[records.size()][];
		for(int i=0;i<records.size();i++) {
			results[i]=records.get(i);
			}
     return results;
	}
		终点*/
	

}
	
	
	
	
	
	


