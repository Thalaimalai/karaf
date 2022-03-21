package com.atmo.authentication.exception;

import com.atmo.exception.CustomException;

public class DetailsAlreadyFoundException extends CustomException {

    public DetailsAlreadyFoundException(String message) {
        super(message);
    }
}

