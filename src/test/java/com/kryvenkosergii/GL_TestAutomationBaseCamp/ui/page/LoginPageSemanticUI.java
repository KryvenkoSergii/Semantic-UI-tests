package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data.UserData;

import io.qameta.allure.Step;

/**
 * LoginPageSemanticUI describes a 'LoginPage' page using PageObject pattern.
 * @author SergiiK 2020-09-22
 */
public class LoginPageSemanticUI extends LoginPage {
    //
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    private WebDriverWait wait;
    //
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement signUpLink;
    //
    private List<WebElement> errorMessagesList;
    //
    public final static String ERROR_MESSAGES_LIST_CSS_LOCATOR = "div[class='ui error message'] .list li";

    /**
     * LoginPageSemanticUI constructor.
     * @param driver WebDriver
     */
    public LoginPageSemanticUI(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    /**
     * Initialize web elements
     */
    private void initElements() {
//        wait = new WebDriverWait(driver, 1);
        emailField = driver.findElement(By.cssSelector("[name='email']"));
        passwordField = driver.findElement(By.cssSelector("[name='password']"));
        loginButton = driver.findElement(By.cssSelector("div[class*='submit button']"));
        signUpLink = driver.findElement(By.cssSelector("a[href='#']"));
    }

    // Page Object

    // emailField
    private WebElement getEmailField() {
        return emailField;
    }

    @Step(value = "input in EmailField text {0}")
    private LoginPageSemanticUI inputEmailField(String text) {
        logger.debug("start inputEmailField()");
        logger.trace("input EmailField: " + text);
        logger.info(this.getClass().getSimpleName() + " input EmailField: " + text);
        log("Start EmailField using string: " + text);
        this.getEmailField().sendKeys(text);
        return this;
    }

    @Step(value = "clear EmailField")
    private LoginPageSemanticUI clearEmailField() {
        logger.debug("start clearEmailField()");
        logger.trace("clear EmailField");
        logger.info(this.getClass().getSimpleName() + " clear EmailField");
        this.getEmailField().clear();
        return this;
    }

    @Step(value = "click in EmailField")
    private LoginPageSemanticUI clickEmailField() {
        logger.debug("start clickEmailField()");
        logger.trace("click EmailField");
        logger.info(this.getClass().getSimpleName() + " click EmailField");
        if (isDisplayedEmailField()) {
            this.getEmailField().click();
            Actions action = new Actions(driver);
            action.contextClick(getEmailField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    private boolean isDisplayedEmailField() {
        logger.debug("start isDisplayedEmailField()");
        logger.trace("is Displayed EmailField");
        return getEmailField().isDisplayed();
    }

    /**
     * Getting text in the EmailField.
     * @return String
     */
    public String getEmailFieldText() {
        return getEmailField().getText();
    }

    // passwordField
    private WebElement getPasswordField() {
        return passwordField;
    }

    @Step(value = "input in PasswordField text {0}")
    private LoginPageSemanticUI inputPasswordField(String text) {
        logger.debug("start inputPasswordField()");
        logger.trace("input PasswordField: " + text);
        logger.info(this.getClass().getSimpleName() + " input PasswordField: " + text);
        log("Start PasswordField using string: " + text);
        this.getPasswordField().sendKeys(text);
        return this;
    }

    @Step(value = "clear PasswordField")
    private LoginPageSemanticUI clearPasswordField() {
        logger.debug("start clearPasswordField()");
        logger.trace("clear PasswordField");
        logger.info(this.getClass().getSimpleName() + " clear PasswordField");
        this.getPasswordField().clear();
        return this;
    }

    @Step(value = "click in PasswordField")
    private LoginPageSemanticUI clickPasswordField() {
        logger.debug("start clickPasswordField()");
        logger.trace("click PasswordField");
        logger.info(this.getClass().getSimpleName() + " click PasswordField");
        if (isDisplayedPasswordField()) {
            this.getPasswordField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    private boolean isDisplayedPasswordField() {
        logger.debug("start isDisplayedPasswordField()");
        logger.trace("is Displayed PasswordField");
        return getPasswordField().isDisplayed();
    }

    /**
     * Getting text in the PasswordField.
     * @return String
     */
    public String getPasswordFieldText() {
        return getPasswordField().getText();
    }

    // loginButton
    private WebElement getLoginButton() {
        return loginButton;
    }

    @Step(value = "click in LoginButton")
    private LoginPageSemanticUI clickLoginButton() {
        logger.debug("start clickLoginButton()");
        logger.trace("click LoginButton");
        logger.info(this.getClass().getSimpleName() + " click LoginButton");
        if (isDisplayedLoginButton()) {
            this.getLoginButton().click();
        }
        return this;
    }

    private boolean isDisplayedLoginButton() {
        logger.debug("start isDisplayedLoginButton()");
        logger.trace("is Displayed LoginButton");
        return getLoginButton().isDisplayed();
    }

    /**
     * Getting text in the LoginButton.
     * @return String
     */
    public String getLoginButtonText() {
        return getLoginButton().getText();
    }

    // signUpLink
    private WebElement getSignUpLink() {
        return signUpLink;
    }

    @Step(value = "click in SignUpLink")
    private LoginPageSemanticUI clickSignUpLink() {
        logger.debug("start clickSignUpLink()");
        logger.trace("click SignUpLink");
        logger.info(this.getClass().getSimpleName() + " click SignUpLink");
        if (isDisplayedSignUpLink()) {
            this.getSignUpLink().click();
        }
        return this;
    }

    private boolean isDisplayedSignUpLink() {
        logger.debug("start isDisplayedSignUpLink()");
        logger.trace("is Displayed SignUpLink");
        return getSignUpLink().isDisplayed();
    }

    /**
     * Getting text in the SignUpLink.
     * @return String
     */
    public String getSignUpLinkText() {
        return getSignUpLink().getText();
    }

    //
    // errorMessagesList
    private List<WebElement> getErrorMessagesList() {
        errorMessagesList = driver.findElements(By.cssSelector(ERROR_MESSAGES_LIST_CSS_LOCATOR));
        return errorMessagesList;
    }

    private boolean isDisplayedErrorEmail() {
        logger.debug("start isDisplayedErrorEmail()");
        logger.trace("is Displayed ErrorEmail");
        getErrorMessagesList();
        return errorMessagesList.size()!=0;
    }

    @Step(value = "get ErrorMessagesList")
    @Override
    public List<String> getErrorEmailTextList() {
        List<String> errors = new ArrayList<String>();
        if (isDisplayedErrorEmail()) {
            for (WebElement message : errorMessagesList) {
                errors.add(message.getText());
            }
            return errors;
        }
        errors.add("error Email Text not found");
        return errors;
    }

    // empty method for Allure logging
    @Step("{0}")
    private void log(String value) {
        // empty method
    }

    // functional
    @Override
    protected LoginPage enterEmail(String email) {
        clickEmailField().clearEmailField().inputEmailField(email);
        return this;
    }

    @Override
    protected LoginPage enterPassword(String password) {
        clickPasswordField().clearPasswordField().inputPasswordField(password);
        return this;
    }

    // business logic
    @Override
    public LoginPage sighIn(UserData user) {
        enterEmail(user.getEmail()).enterPassword(user.getPassword());
        clickLoginButton();
        return this;
    }

    @Override
    public LoginPage sighUp() {
        clickSignUpLink();
        return this;
    }

}
