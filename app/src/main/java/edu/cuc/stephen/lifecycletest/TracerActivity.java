package edu.cuc.stephen.lifecycletest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.Toast;

public class TracerActivity extends Activity {
    public static final String TRACER = "tracer";
    private int nToasts = 0;
    protected String textColor = "#EE0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String msg = String.valueOf(nToasts) + ". onCreate()";
        notify(msg);
        createToast(msg);
    }

    private void createToast(String msg) {
        msg = msg + " - " + this.getLocalClassName();
        msg = "<font color='" + textColor + "'>" + msg + "</font>";
        Toast toast = Toast.makeText(getApplicationContext(), Html.fromHtml(msg), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 80*nToasts);
        toast.show();
        nToasts++;
    }


    private void notify(String message) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification.Builder notificationBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationBuilder = new Notification.Builder(this, TRACER);
        }else{
            notificationBuilder = new Notification.Builder(this);
        }
        Notification notification = notificationBuilder
                .setContentTitle(message + " " + strings[strings.length-1])
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), notification);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String msg = String.valueOf(nToasts) + ". onPause()";
        notify(msg);
        createToast(msg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String msg = String.valueOf(nToasts) + ". onResume()";
        notify(msg);
        createToast(msg);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String msg = String.valueOf(nToasts) + ". onSaveInstanceState()";
        notify(msg);
        createToast(msg);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String msg = String.valueOf(nToasts) + ". onRestoreInstanceState()";
        notify(msg);
        createToast(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String msg = String.valueOf(nToasts) + ". onDestroy()";
        notify(msg);
        createToast(msg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String msg = String.valueOf(nToasts) + ". onStop()";
        notify(msg);
        createToast(msg);
    }
}
