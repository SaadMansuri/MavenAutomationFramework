package com.agorafy.automation.pageobjects.footer.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Feedback extends Page
{
    private WebElement element = null;
    public Feedback(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement pageHeadingSection() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-column")).findElement(By.className("page-desc"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Page Heading Section");
            throw(e);
        }
        return element;
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = pageHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("Feedback Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback Page Heading Not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public WebElement form_Feedback() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("feedback_form"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find feedback form");
            throw(e);
        }
        return element;
    }

    public WebElement textBox_Name() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("name"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Name Text Field on Feedback form");
            throw(e);
        }
        return element;
    }

    public void setName(String name) throws Exception
    {
        try
        {
            textBox_Name().sendKeys(name);
            AutomationLog.info("name is set to:"+name);
        }
        catch(Exception e)
        {
            AutomationLog.error("name is failed to set to:"+name);
            throw(e);
        }
    }
    
    String textBox_NameValue() throws Exception
    {
        String name = "";
        try
        {
            textBox_Name().getAttribute("value");
            AutomationLog.info("Name found in Name text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find name in name field");
            throw(e);
        }
        return name;
    }

    public WebElement textBox_Email() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("exampleInputEmail1"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Email Text Field on Feedback form");
            throw(e);
        }
        return element;
    }

    public void setEmail(String email) throws Exception
    {
        try
        {
            textBox_Email().sendKeys(email);
            AutomationLog.info("email is set to:"+email);
        }
        catch(Exception e)
        {
            AutomationLog.error("email is failed to set to:"+email);
            throw(e);
        }
    }
    
    String textBox_EmailValue() throws Exception
    {
        String email = "";
        try
        {
            textBox_Email().getAttribute("value");
            AutomationLog.info("Email found in email text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find email in Email field");
            throw(e);
        }
        return email;
    }

    WebElement dropdown_Subject() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("subject"));
            AutomationLog.info("Subject Dropdown found on Feedback form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Subject dropdown on feedback form");
        }
        return element;
    }
    public void selectDropdownSubject(String subject) throws Exception
    {
        Select select;
        try
        {
            select = new Select(dropdown_Subject());
            select.selectByVisibleText(subject);
            AutomationLog.info("Subject Dropdown selected to:"+subject);
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to select subject to:"+subject);
        }
    }

    public Collection<String> allSubjectDropdowns() throws Exception 
    {
        List<WebElement> Elements_AllSubjectDropdowns;
        Collection<String> allSubjectDropdowns = new ArrayList<>();
        try
        {
            Elements_AllSubjectDropdowns = dropdown_Subject().findElements(By.tagName("option"));
            for(WebElement element: Elements_AllSubjectDropdowns)
            {
            	allSubjectDropdowns.add(element.getText());
            }
        }
        catch (Exception e) 
        {
            throw (e);
        }
        return allSubjectDropdowns;
    }

    public WebElement textBox_Message() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("feedback_form_msg"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Message Text Field on Feedback form");
            throw(e);
        }
        return element;
    }

    public WebElement setMessage(String message) throws Exception
    {
        try
        {
            textBox_Message().sendKeys(message);
            AutomationLog.info("message is set to:"+message);
        }
        catch(Exception e)
        {
            AutomationLog.error("message is failed to set to:"+message);
            throw(e);
        }
        return element;
    }

    WebElement btn_SubmitFeedback() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("submitFeedback"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find button Submit Feedback");
            throw(e);
        }
        return element;
    }

    public void clickSubmitFeedback() throws Exception
    {
        try
        {
            btn_SubmitFeedback().click();
            AutomationLog.info("sucessfully clicked Submit Feedback");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to click Submit Feedback button");
            throw(e);
        }
    }

    WebElement errorForName() throws Exception
    {
        WebElement parentElement;
        try
        {
            parentElement = form_Feedback().findElement(By.className("nameformError"));
            element = parentElement.findElement(By.className("formErrorContent"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find error element for Name text box");
            throw(e);
        }
        return element;
    }

    public String string_ErrorForName() throws Exception
    {
        String errorForName = null;
        try
        {
            errorForName = errorForName().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to return string of error element for Name text box");
            throw(e);
        }
        return errorForName;
    }

    WebElement errorForEmail() throws Exception
    {
        WebElement parentElement;
        try
        {
            parentElement = form_Feedback().findElement(By.className("exampleInputEmail1formError"));
            element = parentElement.findElement(By.className("formErrorContent"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find error element for Email text box");
            throw(e);
        }
        return element;
    }

    public String string_ErrorForEmail() throws Exception
    {
        String errorForEmail = null;
        try
        {
            errorForEmail = errorForEmail().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to return string of error element for Email text box");
            throw(e);
        }
        return errorForEmail;
    }

    WebElement errorForSubjectDropdown() throws Exception
    {
        WebElement parentElement;
        try
        {
            parentElement = form_Feedback().findElement(By.className("subjectformError"));
            element = parentElement.findElement(By.className("formErrorContent"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find error element for Subject Dropdown");
            throw(e);
        }
        return element;
    }

    public String string_ErrorForSubjectDropdown() throws Exception
    {
        String errorForSubjectDropdown = null;
        try
        {
            errorForSubjectDropdown = errorForSubjectDropdown().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to return string of error element for Subject Dropdown");
            throw(e);
        }
        return errorForSubjectDropdown;
    }

    WebElement errorForMessage() throws Exception
    {
        WebElement parentElement;
        try
        {
            parentElement = form_Feedback().findElement(By.className("feedback_form_msgformError"));
            element = parentElement.findElement(By.className("formErrorContent"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find error element for Message text box");
            throw(e);
        }
        return element;
    }

    public String string_ErrorForMessage() throws Exception
    {
        String errorForMessage = null;
        try
        {
            errorForMessage = errorForMessage().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to return string of error element for Message text box");
            throw(e);
        }
        return errorForMessage;
    }

    WebElement successMsgOfFormFillUp() throws Exception
    {
        try
        {
            element = form_Feedback().findElement(By.id("sendFeedbackErrorMessage"));
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to find success element for feedback form fill up");
            throw(e);
        }
        return element;
    }

    public String string_successMsgOfFormFillUp() throws Exception
    {
        String successMsgOfFormFillUp = null;
        try
        {
            Thread.sleep(1000);;
            successMsgOfFormFillUp = successMsgOfFormFillUp().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to return string of success element for feedback form fill up");
            throw(e);
        }
        return successMsgOfFormFillUp;
    }

}
