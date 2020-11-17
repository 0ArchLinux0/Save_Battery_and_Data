package com.ArchLinux.FirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_kill_kakaotalk;
    private Button button_kill_instagram;
    private Button button_kill_facebook;
    private Button button_kill_chrome;
    private Button button_kill_all;
    private Context context;
    static ForceToStop fts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_kill_kakaotalk=findViewById(R.id.button_kill_kakaotalk);
        button_kill_instagram=findViewById(R.id.button_kill_instagram);
        button_kill_facebook=findViewById(R.id.button_kill_facebook);
        button_kill_chrome=findViewById(R.id.button_kill_chrome);
        button_kill_all=findViewById(R.id.button_kill_all);

        context=getApplicationContext();
        fts=new ForceToStop(context);

        button_kill_kakaotalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fts.forceToStop_kakao();

            }
        });

        button_kill_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fts.forceToStop_instagram();
            }
        });

        button_kill_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fts.forceToStop_facebook();
            }
        });

        button_kill_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fts.forceToStop_chrome();
            }
        });

        button_kill_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fts.forceToStop_all();
            }
        });
    }

}