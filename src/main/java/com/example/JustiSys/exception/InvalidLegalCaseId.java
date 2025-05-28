package com.example.JustiSys.exception;

public class InvalidLegalCaseId extends RuntimeException {
    public InvalidLegalCaseId() {
        super("Invalid id inserted");
    }
}
