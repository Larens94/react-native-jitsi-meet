package com.reactnativejitsimeet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.ThemedReactContext;

import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetView;

public class RNJitsiMeetView extends FrameLayout
implements JitsiMeetActivityInterface {
    private JitsiMeetView jitsiMeetView;

    public RNJitsiMeetView(Context context) {
        super(context);
        init();
    }

    private void init() {
        jitsiMeetView = new JitsiMeetView(getContext());

        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                .setRoom("https://meet.jit.si/test123")
                .build();
        jitsiMeetView.join(options);

        addView(jitsiMeetView);
    }

    @Override
    public int checkPermission(String s, int i, int i1) {
        return 0;
    }

    @Override
    public int checkSelfPermission(String s) {
        return 0;
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String s) {
        return false;
    }

    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}