package com.ArchLinux.FirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.buttonId);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ActivityManager am=(ActivityManager)getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
                am.killBackgroundProcesses("com.kakao.talk");
                Process.killProcess( APP-PROCESS-ID )import android.os.Process

    ActivityManager am = (ActivityManager)
    getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
    am.killBackgroundProcesses("app-package-name");
                */  //Killing process can't prevent service from reviving.
              ForeceToStop.forceToStop();
            }
        });
    }

}