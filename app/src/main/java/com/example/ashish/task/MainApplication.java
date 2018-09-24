package com.example.ashish.task;

import android.app.Application;

import com.example.ashish.task.receiver.ConnectionReceiver;

public class MainApplication extends Application{
    private static MainApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized MainApplication getInstance() {
        return mInstance;
    }

    public void setConnectionListener(ConnectionReceiver.ConnectionReceiverListener listener) {
        ConnectionReceiver.connectionReceiverListener = listener;
    }
}
