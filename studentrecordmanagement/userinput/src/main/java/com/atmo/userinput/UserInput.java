package com.atmo.userinput;

import java.util.Scanner;

/**
 *Get the input from the user.
 *
 * @author ThalaimalaiPandiyanT
 *
 */
public class UserInput {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Show the details of the input.
     *
     * @param text
     */
    public static String getString(String text) {
        System.out.println(text);
        return SCANNER.next().trim();
    }
}
