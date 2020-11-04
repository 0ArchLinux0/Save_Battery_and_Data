package com.ArchLinux.FirstApp;

import android.util.Log;

public class ForeceToStop {
    static public void forceToStop(){
        try {
            Process process = Runtime.getRuntime().exec("am force-stop com.kako.talk");
            Log.d("#","success");
        }catch (Exception e){e.printStackTrace();}
    }
}
