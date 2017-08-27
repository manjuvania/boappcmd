package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	public AndroidDriver driver;
	public LoginPage(AndroidDriver idriver){
		this.driver=idriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="redbus.rbpdomestic.android:id/user_name")
	public WebElement LoginPageUsername_txtBox;
	
	@FindBy(id="redbus.rbpdomestic.android:id/password")
	public WebElement LoginPagePassword_txtBox;
	
	@FindBy(id="redbus.rbpdomestic.android:id/btn_login")
	public WebElement LoginPageSignin_Button;
	
	@FindBy(name="Book a Bus")
	public WebElement HomePage_BookBus_Button;
	
    @FindBy(name="Source")
    public WebElement Homepage_Source_txtBox;
    
    @FindBy(name="Enter a city")
    public WebElement EnterCityName_txtBox;
    
    @FindBy(name="Destination")
    public WebElement Homepage_Destination_txtBox;
    
    @FindBy(id="redbus.rbpdomestic.android:id/date_layout")
    public WebElement DateLayout_btn;
    
    @FindBy(id="redbus.rbpdomestic.android:id/dates_pane_tommorow")
    public WebElement SelectDate_btn;
    
    @FindBy(id="redbus.rbpdomestic.android:id/home_btn_search")
    public WebElement SearchBus_btn;
    
    
    
}
