package agorafy_pkg1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package com.example.tests;

import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import agorafy_pkg1.AllVariables;

public class propertyDetails extends AllVariables {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  //ProfilesIni allProfiles = new ProfilesIni();
  //FirefoxProfile profile = allProfiles.getProfile("My_Profile");
  
  public String statusIfPublished;
  boolean imagePresent, CombinablesqftBit, isPublished;
  String Divisibility;
  String PropertyAddressAdmin, ListingAddressAdmin, TypeOfListingAdmin, isImagePresent;
  String PropertyAddressFrontend;
  boolean featuresAddedAdmin;
  int countFeatursAdmin, countFeatursFrontend;
  

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://preview.agorafy.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPropertyDetails() throws Exception {
    driver.get(baseUrl + "login");
    //driver.findElement(By.linkText(AllVariables.LOGIN_LINK)).click();
    //login in the system
    this.login();
    
    Thread.sleep(5000);
    
    //switching to admin end
    driver.findElement(By.xpath("//DIV[@id='mainHeader']/DIV[@id='mainNav']/UL/LI[4]/A")).click();
    driver.findElement(By.linkText("Switch to Admin")).click();
    driver.findElement(By.linkText(AllVariables.NAME_PROPERTIES_TAB_ADMIN)).click();
    driver.findElement(By.name(AllVariables.NAME_SEARCH_PROPERTY_STREET_ADMIN)).clear();
    driver.findElement(By.name(AllVariables.NAME_SEARCH_PROPERTY_STREET_ADMIN)).sendKeys("West 95 Street");
    driver.findElement(By.name(NAME_PROPERTY_SEARCH_BUTTON)).click();
    // look for a property having listings count >0, click edit icon next to it
   //driver.findElement(By.xpath("//table[@id='listings_table']/tbody/tr[33]/td[5]/a")).click();
  
    // property edit page at the admin end opens in new tab
    driver.get("http://preview.agorafy.com/manage/admin/property/18837");
  
    // save property address
    PropertyAddressAdmin = driver.findElement(By.cssSelector(AllVariables.CSS_PROPERTY_ADDRESS_ADMIN)).getText();
    
    // save listing address that will be seen on property detail page
    ListingAddressAdmin = driver.findElement(By.linkText(AllVariables.LISTING_ADDRESS_LINK_ADMIN)).getText();
    
    // save the type of apartment 
    TypeOfListingAdmin = driver.findElement(By.xpath(AllVariables.XPATH_LISTING_TYPE_ADMIN)).getText();
    
    // saving the status of listing from the table whether published or notin a variable
    this.statusIfPublished = driver.findElement(By.xpath(AllVariables.XPATH_STATUS_INFO_ADMIN)).getText();
    System.out.println("Listing is Published? : " +this.statusIfPublished);
    
    // save whether image is present
    isImagePresent = driver.findElement(By.xpath("//form[@id='form']/div[4]/table/tbody/tr/td[4]")).getText();
    if(isImagePresent.equals("Yes"))  
         imagePresent = true;
    
    //calculate the number of rows in the listings table at back end
    int PropertyListingsCountAdmin = (driver.findElements(By.xpath(AllVariables.XPATH_PROPERTY_LISTING_TABLE_ADMIN)).size());
    System.out.println("number of listings on property edit page: "+PropertyListingsCountAdmin);
  
    driver.findElement(By.className(AllVariables.CLASSNAME_PROPERTY_LINKFOR_WEBVIEW)).click(); //opens the public property page
    
    Iterator<String> AllWindowsOpen= driver.getWindowHandles().iterator();  //get handles of all open windows, here 2 windows will be found
    String parent = AllWindowsOpen.next();
    String child = AllWindowsOpen.next();
    driver.switchTo().window(child);
         
    //VERIFYING THE VALUES STORED WITH FRONT-END
    PropertyAddressFrontend = driver.findElement(By.cssSelector(CSS_PROPERTY_ADDRESS_FRONTEND)).getText();
    System.out.println("ADMIN END PROPERTY ADDRESS: "+PropertyAddressAdmin);
    System.out.println("FRONT END ADDRESS: "+PropertyAddressFrontend);
    boolean PropertyAddressComparisonResult = PropertyAddressAdmin.contains(PropertyAddressFrontend);
    System.out.println("result of property address comparison: "+ PropertyAddressComparisonResult);
    
    if(ListingAddressAdmin.contains(driver.findElement(By.linkText("4 BR - 3.0 BA (Triplex)")).getText()));
        {
            // store type of property from AAVAILABLE LISTINGS TABLE AT FRONT END
            String listingType = driver.findElement(By.xpath("//blockquote[@id='availableListings']/table/tbody/tr/td[2]")).getText(); 
            System.out.println("listing type: "+listingType);
        }
    if(!isElementPresent(By.linkText("DETAILS")))
        System.out.println("FAILED: Details link not found");
    //Assert.assertTrue("details link not found", (driver.findElement(By.linkText("DETAILS")).getText()).equalsIgnoreCase("DETAILS"));
    if(!isElementPresent(By.linkText("TENANTS")))
        System.out.println("Failed: Link for tenants not found");
    assertTrue(isElementPresent(By.linkText("NEWS")));
    Thread.sleep(2000);
    assertTrue(isElementPresent(By.id("property-box")));
    assertTrue(isElementPresent(By.id("property-box")));
    if(imagePresent)
    {
        String imgSrc = driver.findElement(By.xpath("//DIV[@id='details']/DIV[1]/DIV/DIV[1]/DIV/DIV/UL[@id='gallery-slider']/LI/IMG")).getAttribute("src");
        if(imgSrc==null)
            System.out.println("image not seen at front end");
    }
    Thread.sleep(2000);
    if(!isElementPresent(By.id("propertyDetails")))
        System.out.println("FAILED: Property details not being seen at front end");
    if(!isElementPresent(By.id("panoramioPhotos")))
        System.out.println("FAILED: Panoramia photos not being seen at front end");
    if(isElementPresent(By.id("printProperty")))
        System.out.println("FAILED: Print property link/icon not being seen");
    
    //calculate the number of rows in the listings table at front end
    int count2 = (driver.findElements(By.id("availableListings")).size());
        System.out.println(count2);
         
    if(PropertyListingsCountAdmin==count2)
        System.out.println("rows count for listings match");  
    
    driver.close();
    driver.switchTo().window(parent);
         
    this.testListingDetails();
         
   
  }
  
  //verification of values for Listing detail page Admin-end and website
  public void testListingDetails() throws Exception {
    /*driver.get(baseUrl + "about/");
    driver.findElement(By.linkText("LOG IN")).click();
    driver.findElement(By.name("_username")).clear();
    driver.findElement(By.name("_username")).sendKeys("chandrani.bhagat@cuelogic.co.in");
    
    driver.findElement(By.name("_password")).clear();
    driver.findElement(By.name("_password")).sendKeys("cuelogic77");
    driver.findElement(By.cssSelector("input.btn-blue")).click();*/
    driver.get(baseUrl + "manage/admin/listing/12983");
    Thread.sleep(2000);
    
    //admin end values FOR A LISTING being saved for future reference    
    String DisplaynameAdmin = driver.findElement(By.id("displayname")).getAttribute("value"); //this is the name of the listing that will be seen at front end
    System.out.println("ADMIN DISPLAY NAME OF LISTING: "+DisplaynameAdmin);
    
    String ListingTypeAdmin = driver.findElement(By.className("tagline")).getText(); //type of property, eg:retail for sale
    String SpaceNameAdmin = driver.findElement(By.id("spaceName")).getText(); //floor number ,suite number such are spaces
    
    //sq ft area of the space, rounding it in order to eliminate decimal
    long SpaceAreaAdmin = Math.round(Double.parseDouble(driver.findElement(By.id("spaceFootage")).getText().replaceAll("[^0-9.]", "")));
    if ((driver.findElement(By.className("spaceSubText")).getText()).contentEquals("Divisible"))//checking if the area
        Divisibility = "Yes";                                                                   //is divisible, if not divisible
    else                                                                                        //saving 'No' in the variable, will check this
        Divisibility = "No";                                                                //at front end since on website Yes/No is seen

    if((driver.findElement(By.id("combinableSF")).getAttribute("value")).equals(0)) //checking if combinable sqft has any value other than zero
        CombinablesqftBit = false;
    else     
    {                              
        CombinablesqftBit = true;   //if there is no value then this will not be seen at front end
        String CombinablesqftAdmin = driver.findElement(By.id("combinableSF")).getAttribute("value");
        System.out.println("cOMBINABLE SQFT : "+CombinablesqftAdmin);
    } 
     System.out.println(this.statusIfPublished);   
    //String statusPublished = driver.findElement(By.xpath("//DIV[@id='content_wrapper']/DIV[@id='content']/FORM[@id='listingsForm']/DIV[@id='formContainer']/DIV[3]/DIV[2]/DIV/DIV[@id='publishedDiv']/DL/DT/A/SPAN[1]")).getText();
    if(this.statusIfPublished.equalsIgnoreCase("Published"))
       Assert.assertTrue(this.isElementPresent(By.className("subscriptionsAddLink")));
    
    //get the price, round off the decimals and eliminate comma
    long lngPriceAdmin = Math.round(Double.parseDouble(driver.findElement(By.id("price")).getAttribute("value").replaceAll("[^0-9.]", "")));
    System.out.println(lngPriceAdmin);
    //get the per sq ft price, round off the decimals and eliminate comma
    long lngPricesqftAdmin = Math.round(Double.parseDouble(driver.findElement(By.id("priceSF")).getAttribute("value")));
    System.out.println(lngPricesqftAdmin);
    
    String ElectricityAdmin = driver.findElement(By.id("electricity")).getText();
    String strCeilinghtAdmin = driver.findElement(By.id("ceilingheight")).getAttribute("value");
    String strPossessionAdmin = driver.findElement(By.id("possession")).getAttribute("value");
    
    //counting the number of images uploaded for a listing at the admin end
    List<WebElement> images = driver.findElements(By.className("dropzoneThumbnail"));
    System.out.println(images.size());
    int imgCountAdmin = images.size();
    //for pdf files same logic will nopt work since even pdf belongs to the same class, separation using src will be required
    
    List<WebElement> contactList = driver.findElements(By.xpath(AllVariables.XPATH_CONTACTS_DIV_ADMIN));
    int intNoOfContactsAdmin = contactList.size();
   
    //String strFeaturesAdmin = driver.findElement(By.className("columnHeading")).getText(); 
    
    if(this.isElementPresent(By.id("featuresDiv")))
    {
        featuresAddedAdmin = true;
        List<WebElement> FeaturesAdminList = driver.findElements(By.xpath(AllVariables.FEATURES_DIV_ADMIN_LIST));
        countFeatursAdmin = FeaturesAdminList.size(); 
    }
    
    //opening new window for listing at front end
    driver.findElement(By.className("btn-icon-external")).click();
    
    Iterator<String> alwin= driver.getWindowHandles().iterator();
   
    String parent=alwin.next();
    String child= alwin.next();
   
    driver.switchTo().window(child);
   
    if(!driver.findElement(By.xpath(AllVariables.XPATH_DISPLAY_ADDRESS_FRONTEND)).getText().contains(DisplaynameAdmin))
       System.out.println("Does not match the address with admin address");
    
    //verifying price of listing 
    String ListingPriceFrontEnd = driver.findElement(By.xpath("//DIV[@id='main']/DIV[@class='section-header']/DIV[@class='header-content']/DIV[@class='price']/H2")).getText().replaceAll("^[0-9.]", "");
    //Assert.assertEquals((Long.toString(lngPriceAdmin)), ListingPriceFrontEnd);
    System.out.println(ListingPriceFrontEnd);
   
    String strListingTypeWeb = driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/h2")).getText();
    Assert.assertTrue(strListingTypeWeb.contains(ListingTypeAdmin));
  
    String spaceNameAreaWeb = driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[1]")).getText().replace(",", "");
    System.out.println(spaceNameAreaWeb);
    Assert.assertTrue(spaceNameAreaWeb.contains(SpaceNameAdmin));
    if(spaceNameAreaWeb.contains(Long.toString(SpaceAreaAdmin)))
       System.out.println("area matches");
    //Assert.assertTrue((driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[2]")).getText()).equals(Divisibility));
    System.out.println(driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[4]")).getText().replaceAll("[^0-9]", ""));
    Assert.assertTrue((driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[4]")).getText().replaceAll("[^0-9]", "")).equals(Long.toString(lngPricesqftAdmin)));
    //  Assert.assertTrue((driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[5]")).getText()).equals(ElectricityAdmin));
    if(!(driver.findElement(By.xpath("//div[@class='section-content']/div[@class='right-column']/div[@id='features']/dl/dd[6]")).getText().replaceAll("[^0-9]", "")).equals(strCeilinghtAdmin))
       System.out.println("Error: Ceiling height not seen");
  
    if(!this.isElementPresent(By.id("listingSubmitLink")))
      System.out.println("Error: Listing submit link not found");
    if(!this.isElementPresent(By.id("addToReport")))
      System.out.println("Error: Add to Report link not found");
    if(!this.isElementPresent(By.className("btn-property-details")))
      System.out.println("Error: Property details link not seen");
    if(!this.isElementPresent(By.id("printListing")))
      System.out.println("Error: Print listing link not found");
  
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void login()
  {
    driver.findElement(By.xpath(XPATH_USERNAME_FIELD)).clear();
    driver.findElement(By.xpath(AllVariables.XPATH_USERNAME_FIELD)).sendKeys("chandrani.bhagat@cuelogic.co.in");
    driver.findElement(By.xpath(AllVariables.XPATH_PASSWORD_FIELD)).clear();
    driver.findElement(By.xpath(AllVariables.XPATH_PASSWORD_FIELD)).sendKeys("cuelogic77");
    driver.findElement(By.className(AllVariables.NAME_LOGIN_BUTTON)).click();
  }
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
  
     
    /*Iterator<String> alwin= driver.getWindowHandles().iterator();
   
   String parent=alwin.next();
   String child= alwin.next();
   
   driver.switchTo().window(child);
   
   driver.close();*/
}