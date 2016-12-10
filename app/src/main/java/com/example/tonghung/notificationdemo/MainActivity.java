package com.example.tonghung.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn1){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://careers-framgia.icims" +
                    ".com/jobs/1067/android-hacker/job"));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            builder.setSmallIcon(android.R.drawable.ic_lock_lock);
//            builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon));
            builder.setContentText("This is content text of notification");
            builder.setContentTitle("Title of notification");
            builder.setSubText("Click here to open web page");
            builder.setAutoCancel(true);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, builder.build());
        } else if(view == btn2){
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.cancel(1);
        }
    }
}
