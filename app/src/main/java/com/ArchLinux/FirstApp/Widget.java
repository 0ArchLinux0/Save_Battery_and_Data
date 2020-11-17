package com.ArchLinux.FirstApp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import static com.ArchLinux.FirstApp.MainActivity.fts;


public class Widget extends AppWidgetProvider {

    private static final String button_clicked_k="com.ArchLinux.FirstApp.BUTTONCLICKED_k";
    private static final String button_clicked_i="com.ArchLinux.FirstApp.BUTTONCLICKED_i";
    private static final String button_clicked_f="com.ArchLinux.FirstApp.BUTTONCLICKED_f";
    private static final String button_clicked_c="com.ArchLinux.FirstApp.BUTTONCLICKED_c";
    private static final String button_clicked_a="com.ArchLinux.FirstApp.BUTTONCLICKED_a";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Log.d("#","onUpdate");
        RemoteViews view=new RemoteViews(context.getPackageName(),R.layout.widget_layout);

        Intent intent_kakotalk=new Intent(context,Widget.class);
        Intent intent_instagram=new Intent(context,Widget.class);
        Intent intent_facebook=new Intent(context,Widget.class);
        Intent intent_chrome=new Intent(context,Widget.class);
        Intent intent_all=new Intent(context,Widget.class);

        intent_kakotalk.setAction(button_clicked_k);
        intent_instagram.setAction(button_clicked_i);
        intent_facebook.setAction(button_clicked_f);
        intent_chrome.setAction(button_clicked_c);
        intent_all.setAction(button_clicked_a);

        PendingIntent pendingIntent_kakaotalk=PendingIntent.getBroadcast(context,0,intent_kakotalk,0);
        PendingIntent pendingIntent_instagram=PendingIntent.getBroadcast(context,0,intent_instagram,0);
        PendingIntent pendingIntent_facebook=PendingIntent.getBroadcast(context,0,intent_facebook,0);
        PendingIntent pendingIntent_chrome=PendingIntent.getBroadcast(context,0,intent_chrome,0);
        PendingIntent pendingIntent_all=PendingIntent.getBroadcast(context,0,intent_all,0);

        view.setOnClickPendingIntent(R.id.b_kill_kakaotalk,pendingIntent_kakaotalk);
        view.setOnClickPendingIntent(R.id.b_kill_instagram,pendingIntent_instagram);
        view.setOnClickPendingIntent(R.id.b_kill_facebook,pendingIntent_facebook);
        view.setOnClickPendingIntent(R.id.b_kill_chrome,pendingIntent_chrome);
        view.setOnClickPendingIntent(R.id.b_kill_all,pendingIntent_all);


        appWidgetManager.updateAppWidget(appWidgetId, view);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d("#","onrecieve");
        String action=intent.getAction();
        Log.d("#",action);
        if(action.equals(button_clicked_k)){
            fts.forceToStop_kakao();
        }
        else if(action.equals(button_clicked_i)){
            fts.forceToStop_instagram();
        }
        else if(action.equals(button_clicked_f)){
            fts.forceToStop_facebook();
        }
        else if(action.equals(button_clicked_c)){
            fts.forceToStop_chrome();
        }
        else if(action.equals(button_clicked_a)){
            fts.forceToStop_all();
        }
    }
}
