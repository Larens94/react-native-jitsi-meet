package com.reactnativejitsimeet;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class RNJitsiMeetViewManager extends SimpleViewManager<RNJitsiMeetView> {

    public static final String REACT_CLASS = "RNJitsiMeetView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected RNJitsiMeetView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RNJitsiMeetView(reactContext);
    }
}