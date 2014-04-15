/*
 * @author : Chandrani
 * This class will return the base Url for the web application under test
 */


package agorafy.test.utils;


public class BaseUrl {
    
    private static String baseUrl;
    
    public static String getBaseUrl()
    {
        baseUrl = "https://preview.agorafy.com/"; 
        return baseUrl;
    }
    
}
