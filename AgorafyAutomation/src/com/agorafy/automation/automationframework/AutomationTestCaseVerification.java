package com.agorafy.automation.automationframework;

import java.util.Collection;

public abstract class AutomationTestCaseVerification extends AutomationTestCase
{
    public AutomationTestCaseVerification()
    {
        super();
    }
    
    protected AutomationTestCaseVerification(String executingTestCase)
    {
        super(executingTestCase);
    }

    public void setup()
    {
        super.setup();
    }

    public void cleanup()
    {
        super.cleanup();
    }

    public Boolean compareTwoCollections(Collection<String> collection1, Collection<String> collection2)
    {
        if(collection1.size() == collection2.size())
        {
            if(collection1.containsAll(collection2) && collection2.containsAll(collection1))
            return true;
        }
        return false;
    }

    protected abstract void verifyTestCases() throws Exception;
    protected abstract String successMessage();
    protected abstract String failureMessage();

    public void Execute() throws Exception
    {
        try
        {
            setup();
            verifyTestCases();
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
        AutomationLog.error(message);
        testcaseFailed(failureMessage());
        throw (new Exception(message));
    }
}
