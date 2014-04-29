
package agorafy.test.testcases.listings;

import agorafy.test.testcases.*;

/**
 *
 * @author : Chandrani
 * All variables that would be required for the test cases will be here
 * 
 */
public class VariableDeclarations {
    
    static String LOGIN_LINK = "LOG IN";
    public static String XPATH_USERNAME_FIELD = "//DIV[@id='main']/DIV[2]/DIV[@id='login_form']/FORM/DIV[1]/INPUT[@name='_username']";
    public static String XPATH_PASSWORD_FIELD = "//DIV[@id='main']/DIV[2]/DIV[@id='login_form']/FORM/DIV[2]/INPUT[@name='_password']";
    public static String NAME_LOGIN_BUTTON = "btn-darkGreyRound";
    public static String NAME_PROPERTIES_TAB_ADMIN = "Properties";
    static String NAME_SEARCH_PROPERTY_STREET_ADMIN = "street";
    static String NAME_PROPERTY_SEARCH_BUTTON = "search";
    static String CSS_PROPERTY_ADDRESS_ADMIN = "#addressRow27936 > td";
    static String LISTING_ADDRESS_LINK_ADMIN = "36 West 95th Street, 4 BR - 3.0 BA (Triplex)";
    static String XPATH_LISTING_TYPE_ADMIN = "//form[@id='form']/div[4]/table/tbody/tr/td[5]";
    static String XPATH_STATUS_INFO_ADMIN = "//form[@id='form']/div[4]/table/tbody/tr/td[6]";
    static String XPATH_PROPERTY_LISTING_TABLE_ADMIN = "//DIV[@id='content']/FORM[@id='form']/DIV[4]/TABLE/tbody/tr";
    static String CLASSNAME_PROPERTY_LINKFOR_WEBVIEW = "btn-icon-external";
    static String CSS_PROPERTY_ADDRESS_FRONTEND = "h2.address";
    static String ADMIN_ID_DISPLAYNAME_LISTING = "displayname";
    static String XPATH_CONTACTS_DIV_ADMIN = "//DIV[@id='contacts']/DIV[@class='contactDiv']";
    static String XPATH_CONTACTS_DIV_FRONTEND = "//div[@id='brokerInfo']/div[@class='contactDiv']";
    
    static String FEATURES_DIV_ADMIN_LIST = "//div[@id='featuresListDiv']/div[@class='btn-icon-del']";
    static String XPATH_DISPLAY_ADDRESS_FRONTEND = "//div[@id='main']/div[@class='section-header']/div[@class='header-content']/h2";
    
    
    
      //AddListing variables
    static String ADMIN_LOGOUT_ICON_XPATH = "//DIV[@id='content_wrapper']/DIV[@id='content']/FORM[@id='form']/DIV[4]/TABLE/THEAD/TR/TH[1]/INPUT[@id='checkAll']";
    static String ADMIN_ID_ADDLISTING_BUTTON = "addListingLink";
    static String ADMIN_ADDLISTING_ALERT1 = "//DIV[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/DIV[1]";
    static String ADMIN_ADDLISTING_ALERT1_RESIDENTIAL_BUTTON_ID = "residential";
    static String ADMIN_ADDLISTING_ALERT1_OFFICE_BUTTON_ID = "office";
    static String ADMIN_ADDLISTING_ALERT1_RETAIL_BUTTON_ID = "retail";
    static String ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID = "1";
    static String ADMIN_ADDLISTING_ALERT2_LEASE_BUTTON_ID = "2";
    static String ADMIN_ADDLISTING_ALERT2_SUBLEASE_BUTTON_ID = "3";
    static String ADMIN_ADDLISTING_ALERT12_BACK_XPATH = "//DIV[7]/DIV[3]/DIV/BUTTON[1]";
    static String ADMIN_ADDLISTING_ALERT12_CANCEL_XPATH = "//DIV[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/DIV[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/DIV[@class='ui-dialog-buttonset']/button[2]";
    static String ADMIN_ID_NEWLISTING_SAVE_BUTTON = "save";
    static String ADMIN_ID_CLONE_BUTTON = "clone";
    static String ADMIN_ID_EDITLISTING_BUTTON = "editListing";
    
    static String ADMIN_SPACEADD_ID = "add_Space";
    static String ADMIN_RESIDENTIAL_LISTING_SPACE_ID = "spaceName";
    static String ADMIN_RESIDENTIAL_NUMBEROFBEDS_ID = "numBeds";
    static String ADMIN_RESIDENTIAL_NUMBEROFBATHS_ID = "numBaths";
    
    //DIV[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/DIV[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/DIV[@class='ui-dialog-buttonset']/button[1]
}
