package googletest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import googlepage.BasePage;
import googlepage.HomePage;

public class BaseTest extends BasePage {
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		MyFile= new FileInputStream("E:\\New folder2\\google\\MyFile.properties");
		obj.load(MyFile);
		//1. create object of ChromeOptions class
		ChromeOptions opt= new ChromeOptions();
		//2. using ChromeOptions object select desired option
		//opt.addArguments("headless");
		//opt.addArguments("incognito");
		//opt.addArguments("start-maximized");
		opt.addArguments("disable-infobars");
		//3. pass the object as a parameter in chrome driver
		
		System.setProperty(obj.getProperty("PARAMETER1"),obj.getProperty("PARAMETER2"));
		driver=new ChromeDriver(opt);
		driver.get(obj.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
	
	}
	@BeforeMethod
	public void createObjectPages() {
		home= new HomePage(driver);
	}
	/*
	@AfterMethod
	public void closing() throws InterruptedException
	{
		driver.close();
		Thread.sleep(5000);
	}
	*/
	
	
	
	
	
}
