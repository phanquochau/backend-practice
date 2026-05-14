package com.example.indentity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters"),
    INVALID_PASSWORD(1003, "Password must be at least 8 characters"),
    INVALID_KEY(1004, "Invalid key")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
