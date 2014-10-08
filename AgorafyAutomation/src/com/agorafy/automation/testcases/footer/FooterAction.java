package com.agorafy.automation.testcases.footer;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;

public abstract class FooterAction extends AutomationTestCase
{
    public FooterAction()
    {
        super();
    }

    public void setup()
    {
        super.setup();
    }

    public void cleanup()
    {
        super.cleanup();
    }

    abstract void testLink();
    abstract String successMessage();
    abstract String failureMessage();

    public void Execute() throws Exception
    {
        try
        {
            setup();
            testLink();
            testcasePassed(successMessage());
        }
        catch(Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
        finally
        {
            cleanup();
        }
    }

    private void handleTestCaseFailure(String message) throws Exception
    {
        AutomationLog.error(failureMessage() + message);
        testcaseFailed(failureMessage() + message);
        throw (new Exception(failureMessage() + message));
    }
}