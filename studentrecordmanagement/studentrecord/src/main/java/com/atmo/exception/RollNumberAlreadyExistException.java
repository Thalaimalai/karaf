package com.atmo.exception;

import com.atmo.CustomException;

public class RollNumberAlreadyExistException extends CustomException {

    public RollNumberAlreadyExistException(String message) {
        super(message);
    }
}

