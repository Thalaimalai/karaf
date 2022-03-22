package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    public ConnectionFailedException(String message) {
        super(message);
    }
}
