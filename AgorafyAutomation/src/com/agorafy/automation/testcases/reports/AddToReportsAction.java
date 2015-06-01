package com.agorafy.automation.testcases.reports;

 import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.utilities.Login;

public class AddToReportsAction extends AutomationTestCaseVerification
{
    private Homepage homePage;
    private SearchResultsPage searchresult;
    static int reportcount = 15;

	public AddToReportsAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            HashMap<String, String> search = testCaseData.get("SearchRes");
            searchresult = homePage.populateSearchTermTextBox(search.get("borough"), search.get("listingcategory"), search.get("searchterm"));
            AutomationLog.info("Successfully redirected to SearchResults page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to SearchResults page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfAddingMoreThanFifteenListingShowsErrorDialog();
    }

    public void verifyIfAddingMoreThanFifteenListingShowsErrorDialog() throws Exception
    {
        int licount =0;
        int count = 1;
        int total = searchresult.getResultSetListingsConut();
        for(int i=0;i<total;i++)
        {
            if(reportcount < 0)
            {
                break;
            }
            else
            {
                if(searchresult.checkMultipleListings(i))
                {
                    if((searchresult.getListingBadgeCount(i))>reportcount)
                    {
                        if(++licount >=6*count)
                        {
                            searchresult.scrollPage(0, 700);
                            ++count;
                        }
                        continue;
                    }
                    reportcount = reportcount-(searchresult.getListingBadgeCount(i));
                    searchresult.hoverOnSearchResult(i);
                    searchresult.hoverAndClickOnPincushionIcon(i);
                }
                else
                {
                    searchresult.hoverOnSearchResult(i);
                    searchresult.hoverAndClickOnPincushionIcon(i);
                    --reportcount;
                }
                if(++licount >=6*count)
                {
                    searchresult.scrollPage(0, 700);
                    ++count;
                }
            }
        }
        WaitFor.sleepFor(2000);
        Assert.assertTrue(searchresult.popup_ErrorDialog().isDisplayed(), "Expected Error dialog pop up is not shown");
        AutomationLog.info("Error Dialog is shown if more than fifteen listings tried to add ");
    }

    @Override
    protected String successMessage()
    {
        return "test cases for AddToReports Passed";
    }

    @Override
    protected String failureMessage()
    {
        return "test cases for AddToReports Failed";
    }
}
