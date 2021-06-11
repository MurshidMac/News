package com.vimoautomations.newsapp.ui.util;

// Resource.java
public abstract class Resource<T> {
    public T data;
    public String message;
    // There is possibility of null
    private Resource(T type, String message) {
        if(type == null || message == null){
            type = null;
            message = null;
        }
        this.data = type;
        this.message = message;
    }

    public static final class Success<T> extends Resource<T> {
        public T data;
        public Success(T data) {
            super(data, "SUCCESS");
            this.data = data;
            this.message = "SUCCESS";
        }
        public Resource<T> loadValue(){
            return new Resource.Success<T>(this.data);
        }
    }

    public static final class Error<T> extends Resource<T> {
        public Exception exception;
        public String data;
        public Error(String data, Exception exception) {
            super(null, data);
            this.exception = exception;
            this.data = data;
        }
        public Resource<T> loadValue(){
            return new Resource.Error<T>("ERROR",new Exception());
        }
    }

    public static final class Load<T> extends Resource<T> {

        public Load(T type) {
            super(type, "LOAD");
            this.data = type;
            this.message = "LOAD";
        }

        public Resource<T> loadValue(){
            return new Resource.Load<T>(this.data);
        }
    }
}
