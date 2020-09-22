package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data;

public enum ErrorMessages {

    EMPTY_EMAIL_FIELD("Please enter your e-mail"), 
    WROG_EMAIL("Please enter a valid e-mail"),
    EMPTY_PASSWORD_FIELD("Please enter your password"), 
    WROG_PASSWORD("Your password must be at least 6 characters");

    private String message;

    private ErrorMessages(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return message;
    }
}
