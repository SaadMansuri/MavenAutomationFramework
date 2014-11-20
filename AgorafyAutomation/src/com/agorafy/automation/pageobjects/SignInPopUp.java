package com.agorafy.automation.pageobjects;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class SignInPopUp extends Page
{
          WebElement element;
          public SignInPopUp(WebDriver driver)
          {
                  super(driver);
          }
          
          public WebElement txtbx_EmailOnSignInPopUp() throws Exception
          {
                   try
                   {
                           element= driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[1]/input"));
                           AutomationLog.info("Email textbox found on Sign in PopUp");
                   }
                   catch(Exception e)
                   {
                           AutomationLog.error("Email textbox not found on Sign in PopUp");
                           throw(e);
                   }
                   return element;
          }
          
          public WebElement txtbx_PasswordOnSignInPopUP() throws Exception
          {
                   try
                   {
                           element= driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[2]/input"));
                           AutomationLog.info("Password textbox found on signin popup");
                   }
                   catch(Exception e)
                   {
                           AutomationLog.error("Password textbox not found on signin popup");
                           throw(e);
                   }
                   return element;
          }
          
          public WebElement btn_LogInToMyAccountOnSignInPopUp() throws Exception
          {
                   try
                   {
                           element=driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[3]/input"));
                           AutomationLog.info("Log In to My Account button found on login pop up");
                   }
                   catch(Exception e)
                   {
                            AutomationLog.error("Log In to My Account button not found on login pop up");
                            throw(e);
                   }
                   return element;
          }

          public WebElement label_StayLoggedIn() throws Exception
          {
                   try
                   {
                           element=driver.findElement(By.xpath(".//*[@id='upsellRememberMeLabel']"));
                           AutomationLog.info("Stay logged In Label Found");
                   }
                   catch(Exception e)
                   {
                           AutomationLog.error("Stay logged In Label not Found");
                           throw(e);
                   }
                   return element;
          }
          public WebElement checkbox_StayLoggedIn() throws Exception
          {
                   try
                   {
                           element=driver.findElement(By.xpath(".//*[@id='upsellRememberMe']"));
                           AutomationLog.info("Stay logged In checkbox Found");
                   }
                   catch(Exception e)
                   {
                           AutomationLog.error("Stay logged In checkbox not Found");
                           throw(e);
                   }
                   return element;
          }
          
          private void doLoginWithCredentials(String email,String password ) throws Exception
          {
                   try
                   {
                              txtbx_EmailOnSignInPopUp().clear();
                              txtbx_EmailOnSignInPopUp().sendKeys(email);
                              txtbx_PasswordOnSignInPopUP().clear();
                              txtbx_PasswordOnSignInPopUP().sendKeys(password);
                              btn_LogInToMyAccountOnSignInPopUp().click();
                   }
                   catch(Exception e)
                   {
                              AutomationLog.error("Not able to Login ");
                              throw(e);
                   }
          }
}
