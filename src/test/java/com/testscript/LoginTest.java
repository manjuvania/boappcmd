package com.testscript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.basefunctions.BaseClass;
import com.basefunctions.GenericLib;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.pom.LoginPage;

import io.appium.java_client.TouchAction;


public class LoginTest extends BaseClass{
	
	
	@Test
	public void appLogin(){
		try{
			Thread.sleep(4000);
			LoginPage login=new LoginPage(driver);
			assertTrue(login.LoginPageUsername_txtBox.isDisplayed(), "The boapp username textbox is not displayed");
			NXGReports.addStep("Entering username", LogAs.PASSED,null);
			login.LoginPageUsername_txtBox.sendKeys("test_agent13");
			Thread.sleep(1000);
		//	GenericLib.hideKeypad();
			NXGReports.addStep("Entering Password", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			login.LoginPagePassword_txtBox.sendKeys("ss");
			GenericLib.hideKeypad();
			Thread.sleep(1000);
			NXGReports.addStep("click on signin button", LogAs.PASSED,null);
            login.LoginPageSignin_Button.click();
			Thread.sleep(2000);
			login.HomePage_BookBus_Button.click();
			Thread.sleep(2000);
			login.Homepage_Source_txtBox.click();
			Thread.sleep(2000);
			login.EnterCityName_txtBox.sendKeys("Bangalore");
			Thread.sleep(2000);
			TouchAction tc=new TouchAction(driver);
			tc.tap(0,208 ).perform();
			Thread.sleep(2000);
			login.Homepage_Destination_txtBox.click();
			Thread.sleep(2000);
			login.EnterCityName_txtBox.sendKeys("Davanagere");
           Thread.sleep(2000);
			TouchAction tc1=new TouchAction(driver);
			tc1.tap(0,208 ).perform();
			Thread.sleep(2000);
			login.DateLayout_btn.click();
			Thread.sleep(2000);
            login.SelectDate_btn.click();
			Thread.sleep(2000);
            login.SearchBus_btn.click();
			Thread.sleep(5000);
			TouchAction tc2=new TouchAction(driver);
			tc2.tap(0,354).perform();
			Thread.sleep(2000);

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
