package com.vimoautomations.newsapp.ui.util;

public abstract class Resource<T> {
    public Resource(T t, String message){

    }
    class SuccessMessage<T> extends Resource<T>{

        public SuccessMessage(T success, String message) {
            super(success, message);
        }
    }
    class ErrorMessage<T> extends Resource<T>{

        public ErrorMessage(T t, String message) {
            super(t, message);
        }
    }

    class LoadingMessage<T> extends Resource<T>{

        public LoadingMessage(T t, String message) {
            super(t, message);
        }
    }
}
