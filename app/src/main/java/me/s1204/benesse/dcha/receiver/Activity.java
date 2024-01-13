package me.s1204.benesse.dcha.receiver;

import android.content.Intent;
import android.os.Bundle;

import static android.content.Intent.*;
import static android.net.Uri.parse;
import static android.os.BenesseExtension.setDchaState;
import static android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS;
import static android.provider.Settings.System.*;

public class Activity extends android.app.Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDchaState(3);
        if (canWrite(this)) {
            putInt(getContentResolver(), "hide_navigation_bar", 0);
            putInt(getContentResolver(), "allow_screen_shot", 1);
        } else {
            startActivity(new Intent(ACTION_MANAGE_WRITE_SETTINGS, parse("package:" + getPackageName())).setFlags(FLAG_ACTIVITY_NEW_TASK));
        }
        finishAndRemoveTask();
    }
}