package com.agorafy.automation.automationframework;

public abstract class AutomationTestCaseVerification extends AutomationTestCase
{
    public AutomationTestCaseVerification()
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

    protected abstract void verifyTestCases();
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
        AutomationLog.error(failureMessage() + message);
        testcaseFailed(failureMessage() + message);
        throw (new Exception(failureMessage() + message));
    }
}
