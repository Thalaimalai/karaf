package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

public class RollNumberAlreadyExistException extends CustomException {

    public RollNumberAlreadyExistException(String message) {
        super(message);
    }
}

