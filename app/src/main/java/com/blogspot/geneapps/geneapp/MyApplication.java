package com.blogspot.geneapps.geneapp;

import android.app.Application;

import com.orm.SugarContext;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        SugarContext.init(getApplicationContext());
    }
}
