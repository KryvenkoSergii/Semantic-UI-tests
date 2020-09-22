package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data.DataRepository;
import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data.ErrorMessages;
import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data.UserData;
import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.page.LoginPage;
import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.page.LoginPageSemanticUI;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TestUISemanticLoginPage extends TestRunner {

    @DataProvider
    public Object[][] logginWithRandomCredentials() {
        return new Object[][] { { DataRepository.get().randomEmail() }, };
    }

    @DataProvider
    public Object[][] logginWithSomeCredentials() {
        return new Object[][] { { DataRepository.get().someCredentials() }, };
    }

    @DataProvider
    public Object[][] logginWithEmptyCredentials() {
        return new Object[][] { { DataRepository.get().getDefault() }, };
    }

    /**
     * A simple test using Selenium. In Semantic Login page, we enter some
     * credentials.
     * @param user UserData.
     */
    @Epic("A test Semantic Login page with some credentials.")
    @Feature(value = "loggin with some credentials")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Semantic Login page, we enter some credentials and click 'Login'.")
    @Story(value = "Loggin with some credentials. Check URL.")
    @Parameters("Some credentials")
    @Test(dataProvider = "logginWithSomeCredentials")
    public void logging1(UserData user) {
        LoginPage page = new LoginPageSemanticUI(driver).sighIn(user);
        //
        String actual = driver.getCurrentUrl().substring(0, driver.getCurrentUrl().indexOf("?"));
        String expected = "https://semantic-ui.com/examples/login.html";
        Assert.assertEquals(actual, expected, "the URL doesn't match to expected");
    }

    /**
     * A simple test using Selenium. In Semantic Login page, we enter random
     * credentials.
     * @param user UserData.
     */
    @Epic("A test Semantic Login page with random credentials.")
    @Feature(value = "loggin with random credentials")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Semantic Login page, we enter random credentials and click 'Login'.")
    @Story(value = "Loggin with random credentials. Check URL.")
    @Parameters("Random credentials")
    @Test(dataProvider = "logginWithRandomCredentials")
    public void logging2(UserData user) {
        LoginPage page = new LoginPageSemanticUI(driver).sighIn(user);
        //
        String actual = driver.getCurrentUrl().substring(0, driver.getCurrentUrl().indexOf("?"));
        String expected = "https://semantic-ui.com/examples/login.html";
        Assert.assertEquals(actual, expected, "the URL doesn't match to expected");
    }

    /**
     * A simple test using Selenium. In Semantic Login page, we don't enter random
     * any credentials.
     * @param user UserData.
     */
    @Epic("A test Semantic Login page with empty credentials.")
    @Feature(value = "loggin with empty credentials")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Semantic Login page, we enter empty credentials and click 'Login'.")
    @Story(value = "Loggin with empty credentials. Check URL. Check error messages.")
    @Parameters("Empty credentials")
    @Test(dataProvider = "logginWithEmptyCredentials")
    public void logging3(UserData user) {
        LoginPage page = new LoginPageSemanticUI(driver).sighIn(user);
        //
        String actual = driver.getCurrentUrl();
        String expected = "https://semantic-ui.com/examples/login.html";
        Assert.assertEquals(actual, expected, "the URL doesn't match to expected");
        //
        List<String> errors = page.getErrorEmailTextList();
        Assert.assertTrue(
                errors.contains(ErrorMessages.EMPTY_EMAIL_FIELD.toString()) || 
                errors.contains(ErrorMessages.EMPTY_PASSWORD_FIELD.toString()) || 
                errors.contains(ErrorMessages.WROG_EMAIL.toString()) || 
                errors.contains(ErrorMessages.WROG_PASSWORD.toString()),
                "the list of errors doesn't contains necessary result");
    }
    
    /**
     * A simple test using Selenium. In Semantic Login page, we click to SignUp button.
     * @param user UserData.
     */
    @Epic("A test Semantic Login for clicking SignUp button.")
    @Feature(value = "clicking SignUp button")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In Semantic Login page, we clicking SignUp button.")
    @Story(value = "Clicking SignUp button. Check URL.")
    @Test
    public void registering() {
        LoginPage page = new LoginPageSemanticUI(driver).sighUp();
        //
        String actual = driver.getCurrentUrl();
        String expected = "https://semantic-ui.com/examples/login.html#";
        Assert.assertEquals(actual, expected, "the URL doesn't match to expected");
    }

}
