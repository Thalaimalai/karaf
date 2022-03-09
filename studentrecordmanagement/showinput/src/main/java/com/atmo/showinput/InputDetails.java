package com.atmo.showinput;

import java.util.Scanner;

public class InputDetails {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Show the details of the input.
     *
     * @param data
     */
    public static String getInputData(String data) {
        System.out.println(data);
        return SCANNER.next().trim();
    }
}
