//package com.example.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.thoughtworks.selenium.*;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class acct_settings_prod {
    WebDriver driver;
    String baseUrl;
    
    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();    
	baseUrl = "http://agorafy.com/";
    }
    public void testAcct_settings_prod() throws Exception {
	driver.get(baseUrl+"about/");
        driver.findElement(By.xpath("//DIV[@id='mainHeader']/DIV[@id='mainNav']/UL/LI[1]/A")).click();
        driver.findElement(By.name("_username")).sendKeys("chandrani.bhagat@cuelogic.co.in");
        driver.findElement(By.name("_password")).sendKeys("cuelogic");
	driver.get(baseUrl+"account/");	
	Thread.sleep(5000);
	Assert.assertTrue(this.isElementPresent(By.id("personalInfoLink")));
	Assert.assertTrue(this.isElementPresent(By.id("changePasswordLink")));
		assertTrue(selenium.isElementPresent("css=#userEditForm > fieldset > label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[2]/label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[3]/label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[4]/label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[5]/label"));
		assertTrue(selenium.isElementPresent("//FORM[@id=\"userEditForm\"]/FIELDSET[6]/LABEL"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[7]/label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[8]/label"));
		assertTrue(selenium.isElementPresent("//form[@id='userEditForm']/fieldset[9]/label"));
		assertTrue(selenium.isElementPresent("id=phoneNumber1Type"));
		assertTrue(selenium.isElementPresent("id=phoneNumber2Type"));
		assertTrue(selenium.isElementPresent("id=phoneNumber3Type"));
		assertTrue(selenium.isElementPresent("id=phoneNumber4Type"));
		assertEquals("Edit Account", selenium.getValue("name=submit"));
		assertFalse(selenium.isEditable("id=email"));
		assertTrue(selenium.isEditable("id=company"));
		selenium.type("id=name", "");
		selenium.click("name=submit");
		assertTrue(selenium.isElementPresent("css=div.formErrorContent"));
		selenium.type("id=name", "ChandRANI");
		selenium.click("name=submit");
		selenium.waitForPageToLoad("30000");
		String i = selenium.getValue("id=name");
		assertTrue(selenium.getText("//DIV[@id=\"mainHeader\"]/DIV[@id=\"mainNav\"]/UL/LI[4]/A").matches("^[\\s\\S]*\\$\\{i\\}[\\s\\S]*$"));
		assertTrue(selenium.isEditable("id=name"));
		// begin the password section
		selenium.click("id=changePasswordLink");
		assertTrue(selenium.isElementPresent("id=changePasswordForm"));
		selenium.click("id=passwordChangeSubmit");
		assertTrue(selenium.isElementPresent("//DIV[9]/DIV[1]"));
		assertTrue(selenium.isElementPresent("//DIV[10]/DIV[1]"));
		assertTrue(selenium.isElementPresent("//DIV[11]/DIV[1]"));
		assertEquals("Change Password", selenium.getValue("id=passwordChangeSubmit"));
		selenium.type("id=oldPassword", "cuelogic77");
		selenium.type("id=password1", "cuelogic7");
		selenium.type("id=password2", "cuelogic77");
		assertTrue(selenium.isElementPresent("css=div.formErrorContent"));
		String a = selenium.getText("css=div.formErrorContent");
		assertEquals(a, selenium.getText("css=div.formErrorContent"));
		selenium.click("id=personalInfoLink");
		assertTrue(selenium.isElementPresent("id=userEditForm"));
	}
    
    
    
    
    
    private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
