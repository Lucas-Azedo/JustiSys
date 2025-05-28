package com.example.JustiSys.exception;

public class InvalidCityId extends RuntimeException {

    public InvalidCityId() {
        super("Invalid id inserted");
    }
}
