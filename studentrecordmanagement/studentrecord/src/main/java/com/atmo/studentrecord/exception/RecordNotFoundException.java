package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

public class RecordNotFoundException extends CustomException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}

