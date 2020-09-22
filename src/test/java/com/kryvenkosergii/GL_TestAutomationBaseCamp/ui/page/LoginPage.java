package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.page;

import java.util.List;

import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data.UserData;

/**
 * Describes 'LoginPage' and contains business logic, and some functionality.
 * @author SergiiK
 * 2020-09-22
 */
public abstract class LoginPage {

    /**
     * Entering a email in the "Email" field.
     * @param email String
     * @return LoginPage
     */
    protected abstract LoginPage enterEmail(String email);
   
    /**
     * Entering a password in the "Password" field.
     * @param password String
     * @return LoginPage
     */
    protected abstract LoginPage enterPassword(String password);
   
    /**
     * Filling credentials and click "Login".
     * @param user UserData
     * @return HomePage
     */
    public abstract LoginPage sighIn(UserData user);
    
    /**
     * Click in the link "Sigh Up"
     * @param user UserData
     * @return RegisterPage
     */
    public abstract LoginPage sighUp();
    
    /**
     * Getting a list of error messages.
     * @return List<String>
     */
    public abstract List<String> getErrorEmailTextList();
}
