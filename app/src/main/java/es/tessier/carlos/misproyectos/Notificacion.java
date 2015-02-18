package es.tessier.carlos.misproyectos;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Notificacion extends Activity {
    int notificationID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);


    }
    public void ClickNotification(View view){
        Log.d("Notification", "ClickNotification");
        displayNotification();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    protected void displayNotification(){
        Intent i = new Intent(this, Notification.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        CharSequence ticker ="Reservar otro viaje";
        CharSequence contentTitle = "Alarma del sistema";
        CharSequence contentText = "Coger la renfe de las 20:30";
        Notification noti = new Notification.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.drawable.icon_renfe)
                .addAction(R.drawable.ic_launcher, ticker, pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();
        nm.notify(notificationID, noti);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notificacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
