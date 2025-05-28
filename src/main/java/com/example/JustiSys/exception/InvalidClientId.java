package com.example.JustiSys.exception;

public class InvalidClientId extends RuntimeException {

    public InvalidClientId() {
        super("Invalid id inserted");
    }
}
