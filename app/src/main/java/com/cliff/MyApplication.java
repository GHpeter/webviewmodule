package com.cliff;

import com.cliff.base.BaseApplication;
import com.kingja.loadsir.core.LoadSir;

import com.cliff.base.loadsir.CustomCallback;
import com.cliff.base.loadsir.EmptyCallback;
import com.cliff.base.loadsir.ErrorCallback;
import com.cliff.base.loadsir.LoadingCallback;
import com.cliff.base.loadsir.TimeoutCallback;


public class MyApplication extends BaseApplication {

    @Override
    public void onCreate(){
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
