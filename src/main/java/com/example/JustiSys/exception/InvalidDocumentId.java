package com.example.JustiSys.exception;

public class InvalidDocumentId extends RuntimeException {
  public InvalidDocumentId() {
    super("Invalid id inserted");
  }
}
