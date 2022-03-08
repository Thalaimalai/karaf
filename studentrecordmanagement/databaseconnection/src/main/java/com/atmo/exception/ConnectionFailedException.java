package com.atmo.exception;

import com.atmo.CustomException;

public class ConnectionFailedException extends CustomException {

    public ConnectionFailedException(String message) {
        super(message);
    }
}
