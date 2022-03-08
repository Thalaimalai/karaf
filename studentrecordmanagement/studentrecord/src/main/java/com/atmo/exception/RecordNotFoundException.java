package com.atmo.exception;

import com.atmo.CustomException;

public class RecordNotFoundException extends CustomException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}

