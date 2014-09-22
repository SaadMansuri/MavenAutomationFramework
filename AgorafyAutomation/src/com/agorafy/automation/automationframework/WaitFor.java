package com.agorafy.automation.automationframework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class WaitFor 
{
    public static WebElement presenceOfTheElement(WebDriver driver, final By elementIdentifier) 
    {
        // Wait time and polling time get it from global configuration.
        String globalPageTimeoutProperty = Configuration.getConfigurationValueForProperty("global-page-timeout");
        long globalPageTimeout = Long.parseLong(globalPageTimeoutProperty);

        String globalPageElementPollingTimeoutProperty = Configuration.getConfigurationValueForProperty("global-page-element-polling-timeout");
        long globalPageElementPollingTimeout = Long.parseLong(globalPageElementPollingTimeoutProperty);
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(globalPageTimeout, TimeUnit.SECONDS)
                .pollingEvery(globalPageElementPollingTimeout, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(elementIdentifier);
            }
        });
    }
}
