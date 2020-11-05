package com.ArchLinux.FirstApp;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class ForceToStop {
    private static Context context;
    static public void forceToStop() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.kakao.talk");

    }
    public ForceToStop(Context context){
        this.context=context;
    }
}
