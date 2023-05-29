package com.reactnativejitsimeet;

import android.util.Log;
import java.net.URL;
import java.net.MalformedURLException;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReadableMap;
import org.jitsi.meet.sdk.JitsiMeetView;

@ReactModule(name = RNJitsiMeetModule.MODULE_NAME)
public class RNJitsiMeetModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "RNJitsiMeetModule";
    private JitsiMeetView view;

    public RNJitsiMeetModule(ReactApplicationContext reactContext, IRNJitsiMeetViewReference jitsiMeetViewReference) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void call(String url, ReadableMap userInfo, ReadableMap meetOptions, ReadableMap meetFeatureFlags) {
        Log.d("EXJitsiMeet", "call start");
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view = new JitsiMeetView(this);
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setRoom("https://meet.jit.si/test123")
                    .build();
                view.join(options);
                setContentView(view);
            }
        });
    }

    @ReactMethod
    public void endCall() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.dispose();
                view = null;
                JitsiMeetActivityDelegate.onHostDestroy(this);
            }
        });
    }
}
