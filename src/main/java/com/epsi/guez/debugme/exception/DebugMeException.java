package com.epsi.guez.debugme.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DebugMeException extends Exception {

    private static final long serialVersionUID = 1L;

    public DebugMeException(String message) {
        super(message);
    }
}