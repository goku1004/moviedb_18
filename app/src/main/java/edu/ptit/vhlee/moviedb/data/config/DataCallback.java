package edu.ptit.vhlee.moviedb.data.config;

public interface DataCallback {
    interface Callback<T> {
        void onStart();

        void onSuccess(T data);

        void onFail(Exception exception);

        void onComplete();
    }
}
