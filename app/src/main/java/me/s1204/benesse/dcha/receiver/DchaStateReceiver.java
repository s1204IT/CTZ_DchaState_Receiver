package me.s1204.benesse.dcha.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import static android.os.BenesseExtension.setDchaState;
import static android.provider.Settings.System.canWrite;
import static android.provider.Settings.System.putInt;

public class DchaStateReceiver extends BroadcastReceiver {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    public void onReceive(Context c, Intent i) {
        setDchaState(3);
        if (canWrite(c)) {
            putInt(c.getContentResolver(), "hide_navigation_bar", 0);
            putInt(c.getContentResolver(), "allow_screen_shot", 1);
        }
    }
}
