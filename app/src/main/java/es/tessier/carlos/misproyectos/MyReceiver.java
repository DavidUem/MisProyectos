package es.tessier.carlos.misproyectos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,intent.getStringExtra("message"), Toast.LENGTH_LONG).show();

    }



}
