package com.atmo.exception;

import com.atmo.CustomException;

public class DateNotValidException extends CustomException {

    public DateNotValidException(String message) {
        super(message);
    }
}

