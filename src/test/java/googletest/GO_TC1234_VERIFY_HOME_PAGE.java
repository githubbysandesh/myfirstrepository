package googletest;



import org.testng.Assert;
import org.testng.annotations.Test;

public class GO_TC1234_VERIFY_HOME_PAGE extends BaseTest{
	

	@Test(priority=-1)
	public void verifyGooglePageOpen() throws InterruptedException {
		String exp = "Google";
		Thread.sleep(1000);
		String act = driver.getTitle();
		Thread.sleep(1000);
		Assert.assertEquals(exp, act , "Assert is fail");
	}
	@Test(priority=1)
	public void verifyPagename() throws InterruptedException {
		boolean act= home.VrifyLogo();
		Thread.sleep(1000);
		boolean exp = true;
		Thread.sleep(1000);
		Assert.assertEquals(act, exp, "Assert is fail");
		
	}
	
	@Test(priority=2)
	public void verifyGoogleTab() throws InterruptedException {
		boolean act= home.VrifyGoogleTabPreset();
		Thread.sleep(1000);
		boolean exp = true;
		Thread.sleep(1000);
		Assert.assertEquals(act, exp, "Assert is fail");
		
	}
	@Test(priority=3)
	public void verifyGoogleAccept() throws InterruptedException {
		String act= home.VrifyGoolgeTabAcceptValue();
		Thread.sleep(1000);
		String exp = "textarea";
		Thread.sleep(1000);
		Assert.assertEquals(act, exp, "Asssert is fail");	
	}
	@Test(priority=4)
	public void selectWord() throws InterruptedException
	{
		home.clickOnKey();
		}
		
}
