package com.faabsystems.pensionapplication.util;

public interface DataStateListener<T> {
    void onLoading();
    void onSuccess(T data);
    void onError(String errorMessage);
}
