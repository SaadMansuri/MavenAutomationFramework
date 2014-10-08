package com.agorafy.automation.datamodel.profile;

public class ChangePasswordData 
{
    private String changePassword;
    private String oldPassword;
    private String newPassword;
    private String retypeNewPassword;
    @SuppressWarnings("unused")
    private String passwordChangedSuccesfully;

    public String getOldPassword() 
    {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) 
    {
        this.oldPassword = oldPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) 
    {
        this.newPassword = newPassword;
    }
    public String getRetypeNewPassword() 
    {
        return retypeNewPassword;
    }
    public void setRetypeNewPassword(String retypeNewPassword)
    {
        this.retypeNewPassword = retypeNewPassword;
	}
	
    public String getChangePassword() 
    {
        return changePassword;
    }
    public void setChangePassword(String changePassword) 
    {
        this.changePassword = changePassword;
    }
    public void  setPasswordChangedSuccesfully(String passwordChangedSuccesfully)
    {
        this.passwordChangedSuccesfully = passwordChangedSuccesfully;
    }
}
	

