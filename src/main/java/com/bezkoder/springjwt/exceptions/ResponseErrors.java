package com.bezkoder.springjwt.exceptions;

public class ResponseErrors {
    private final String fieldName;
    private final String message;
    private final int code;

    public ResponseErrors(String fieldName, String message, int code) {
        this.fieldName = fieldName;
        this.message = message;
        this.code = code;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
