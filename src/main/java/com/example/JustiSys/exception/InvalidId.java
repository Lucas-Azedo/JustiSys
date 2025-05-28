package com.example.JustiSys.exception;

public class InvalidId extends RuntimeException {

    public InvalidId() {
        super("Invalid id inserted");
    }
}
