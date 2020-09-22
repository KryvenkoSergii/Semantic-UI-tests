package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data;

/**
 * User data class.
 * @author SergiiK 2020-09-22
 */
public class UserData {

    private String email;
    private String password;

    /**
     * Default constructor.
     */
    public UserData() {
        this.email = "";
        this.password = "";
    }

    /**
     * Constructor with 2 enter parameters (email and password).
     * @param email String
     * @param password String
     */
    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //

    @Override
    public String toString() {
        return "UserData [email=" + email + ", password=" + password + "]";
    }
}
