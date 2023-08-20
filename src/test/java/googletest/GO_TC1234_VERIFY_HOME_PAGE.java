package googletest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
@Listeners(googletest.Listener.class)

//@Test(dataProvider="MyDataProvider",dataProviderClass=googletest.DataProvider.class)
public class GO_TC1234_VERIFY_HOME_PAGE extends BaseTest{
	

	@Test(priority=-1)
	public void verifyGooglePageOpen() throws InterruptedException, EncryptedDocumentException, IOException {
		String exp = UtilityClass.readDataFromExcel(0, 0);
		UtilityClass.waitTime(1000);
		String act = driver.getTitle();
		UtilityClass.waitTime(1000);
	
		Assert.assertEquals(exp, act , "Assert is fail");
	}
	@Test(priority=1)
	public void verifyPagename() throws InterruptedException, IOException {
		boolean act= home.VrifyLogo();
		UtilityClass.waitTime(1000);
		boolean exp = true;
		UtilityClass.waitTime(1000);
		Assert.assertEquals(act, exp, "Assert is fail");
		
	}
	
	@Test(priority=2)
	public void verifyGoogleTab() throws InterruptedException {
		boolean act= home.VrifyGoogleTabPreset();
		UtilityClass.waitTime(1000);
		boolean exp = true;
		UtilityClass.waitTime(1000);
		Assert.assertEquals(act, exp, "Assert is fail");
		
	}
	@Test(priority=3)
	public void verifyGoogleAccept() throws InterruptedException {
		String act= home.VrifyGoolgeTabAcceptValue();
		Thread.sleep(1000);
		String exp = "textarea";
		UtilityClass.waitTime(1000);
		Assert.assertEquals(act, exp, "Asssert is fail");	
	}
	@Test(priority=4)
	public void selectWord() throws InterruptedException
	{
		home.clickOnKey();
		}
	
	
		
}
