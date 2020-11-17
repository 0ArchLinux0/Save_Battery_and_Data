package com.ArchLinux.FirstApp;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ForceToStop {
    private static Context context;
    private static Toast myToast ;
    private static String nameString;

    public ForceToStop(Context context){
        this.context=context;
    }


    static public void callToast(String name){
        nameString="Successfully killed "+name;
        if(myToast!=null) myToast.cancel();
        myToast.makeText(context,nameString,Toast.LENGTH_SHORT).show();
    }

    static public void forceToStop_kakao() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.kakao.talk");
        callToast("kakotalk");
    }

    static public void forceToStop_instagram() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.instagram.android");
        callToast("instagram");
    }

    static public void forceToStop_facebook() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.facebook.katana");
        callToast("facebook");
    }

    static public void forceToStop_chrome() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.android.chrome");
        callToast("chrome");
    }

    static public void forceToStop_all() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.facebook.katana");
        am.killBackgroundProcesses("com.instagram.android");
        am.killBackgroundProcesses("com.kakao.talk");
        am.killBackgroundProcesses("com.android.chrome");
        callToast("all");
    }
}
