package com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.data;

import com.kryvenkosergii.GL_TestAutomationBaseCamp.ui.tools.Randomizer;

/**
 * DataRepository class which holds different sets of data.
 * @author SergiiK
 */
public final class DataRepository {
    private static volatile DataRepository instance = null;

    private DataRepository() {
    }

    public static DataRepository get() {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository();
                }
            }
        }
        return instance;
    }

    /**
     * Default credentials with empty parameters.
     * @return UserData class.
     */
    public UserData getDefault() {
        return new UserData();
    }

    /**
     * A random credentials.
     * @return UserData class.
     */
    public UserData randomEmail() {
        return new UserData(Randomizer.getRamdomString20Letters() + "@" + Randomizer.getRamdomStringLetters1(4) + ".com",
                Randomizer.getRamdomString20LettersNumbers());
    }

    /**
     * Give a user credentials: email = "asd123_asd@zxc.com"; password =
     * "123654Azxc_".
     * @return SearchData class.
     */
    public UserData someCredentials() {
        return new UserData("asd123_asd@zxc.com", "123654Azxc_");
    }

}