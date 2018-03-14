package com.example.drodrigues.heroespoc.infrastructure;

import android.text.TextUtils;

public class OperationError {
    private final int errorCode;
    private String errorMessage;
    private Object errorData;

    public OperationError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        if(TextUtils.isEmpty(errorMessage)) {
            throw new RuntimeException("ErrorMessage cannot be empty.");
        } else {
            this.errorMessage = errorMessage;
        }
    }

    public Object getErrorData() {
        return this.errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
