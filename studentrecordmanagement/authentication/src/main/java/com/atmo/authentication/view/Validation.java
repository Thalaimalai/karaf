package com.atmo.authentication.view;

public class Validation {

    /**
     * Validate choice.
     *
     * @param choice
     */
    public static boolean validateChoice(String choice) {
        return choice.matches("[1-5]") ? true : false;
    }
}
