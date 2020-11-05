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

    private static final String button_clicked="com.ArchLinux.FirstApp.BUTTONCLICKED";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Log.d("#","onUpdate");
        RemoteViews view=new RemoteViews(context.getPackageName(),R.layout.widget_layout);
        // Intent intent=new Intent(button_clicked);
        Intent intent=new Intent(context,Widget.class);
        intent.setAction(button_clicked);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);
        view.setOnClickPendingIntent(R.id.widgetButton,pendingIntent);
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
        if(action.equals(button_clicked)){
            fts.forceToStop();
        }


    }
}
