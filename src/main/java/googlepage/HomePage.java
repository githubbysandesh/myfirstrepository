package googlepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	//variable
	@FindBy(xpath="//img[@class='lnXdpd']") WebElement googleLogo;
	@FindBy(id="APjFqb") WebElement googleTab;
	@FindBy(xpath="(//div[@id='Alh6id'])//ul//li") List<WebElement> all;
	
	//contructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method
	
	public boolean VrifyLogo() throws InterruptedException {
	boolean v= googleLogo.isDisplayed();
	Thread.sleep(4000);
	return v ;
	}
	
	public boolean VrifyGoogleTabPreset() {
		boolean v= googleTab.isDisplayed();
		return v ;
		}
	
	public String VrifyGoolgeTabAcceptValue() {
		//googleTab .sendKeys("selenium download");
		String v1=googleTab.getTagName();
		return v1;
		}

	public void clickOnKey() throws InterruptedException {
		
		googleTab.sendKeys("selenium");
		System.out.print(all);
		String Expected= "selenium download";
		try {
			for(WebElement s:all) {
				String Actual = s.getText();
				Thread.sleep(1000);
				System.out.print(Actual);
				if(Expected.equalsIgnoreCase(Actual));
			    s.click();
				}
		}
		catch(StaleElementReferenceException e){
			System.out.println("Exception handle");
		}

		
		}
}
