package com.example.drodrigues.heroespoc.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class OperationResult<T> {
    private T mResult;
    private List<OperationError> mError;

    public OperationResult() {
    }

    public List<OperationError> getErrors() {
        return this.mError;
    }

    public void addError(OperationError error) {
        if(this.mError == null) {
            this.mError = new ArrayList();
        }

        this.mError.add(error);
    }

    public void addAllErrors(List<OperationError> errors) {
        if(this.mError == null) {
            this.mError = new ArrayList();
        }

        this.mError.addAll(errors);
    }

    public T getResult() {
        return this.mResult;
    }

    public void setResult(T result) {
        this.mResult = result;
    }

    public boolean isOperationSuccessful() {
        return this.mError == null && this.getResult() != null;
    }

    public boolean hasErrors() {
        return this.mError != null && !this.mError.isEmpty();
    }
}
