package com.atmo.exception;

import com.atmo.CustomException;

public class DetailsAlreadyFoundException extends CustomException {

    public DetailsAlreadyFoundException(String message) {
        super(message);
    }
}

