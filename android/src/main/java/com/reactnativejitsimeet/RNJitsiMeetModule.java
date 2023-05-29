package com.reactnativejitsimeet;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReadableMap;


@ReactModule(name = RNJitsiMeetModule.MODULE_NAME)
public class RNJitsiMeetModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "RNJitsiMeetModule";

    public RNJitsiMeetModule(ReactApplicationContext reactContext) {
        Log.d("EXJitsiMeet", "RNJitsiMeetModule");
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void call(String url, ReadableMap userInfo, ReadableMap meetOptions, ReadableMap meetFeatureFlags) {
        Log.d("EXJitsiMeet", "call start");
        //new RNJitsiMeetView();
    }

    @ReactMethod
    public void endCall() {
    }
}
