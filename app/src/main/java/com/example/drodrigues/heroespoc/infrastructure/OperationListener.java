package com.example.drodrigues.heroespoc.infrastructure;

import java.util.List;

public abstract class OperationListener<T> {
    public OperationListener() {
    }

    public void onSuccess(T result) {
    }

    public void onError(List<OperationError> errors) {
    }

    public void onCancel() {
    }
}
