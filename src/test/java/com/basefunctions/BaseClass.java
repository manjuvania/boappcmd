package com.basefunctions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
   
	public DesiredCapabilities capabilities;
	public static AndroidDriver driver;
	public static String sdirPath=System.getProperty("user.dir");
	public static String apkPath=sdirPath+"\\APKFiles\\app-release.apk";
	public static String node="C:\\Program Files (x86)\\Appium\\node.exe";
	public static String appiumjs="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	public AppiumDriverLocalService server;
	
	@BeforeSuite
	public void appiumStartServer(){
		server=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File(node)).withAppiumJS(new File(appiumjs)));
	    server.start();
	}
	
	@BeforeMethod
	public void launchApp() throws MalformedURLException, InterruptedException{
	
			capabilities=new DesiredCapabilities();
			capabilities.setCapability("atomationName", GenericLib.getProperties("AUTOMATIONNAME"));
			capabilities.setCapability("platformName", GenericLib.getProperties("PLATFORMNAME"));
			capabilities.setCapability("deviceName", GenericLib.getProperties("DEVICENAME"));
			capabilities.setCapability("platformVersion", GenericLib.getProperties("PLATFORMVERSION"));
			capabilities.setCapability("app", apkPath);
			driver=new AndroidDriver(new URL(GenericLib.getProperties("URL")), capabilities);
			Thread.sleep(4000);
            NXGReports.setWebDriver(driver);
			
		
	}
	
	@AfterMethod
	public void closeDriver(){
		driver.quit();
	}
	
	@AfterSuite
	public void stopAppiumServer(){
		server.stop();
	}
	
	
}
