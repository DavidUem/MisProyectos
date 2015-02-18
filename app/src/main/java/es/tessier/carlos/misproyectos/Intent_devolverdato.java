package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Intent_devolverdato extends Activity {
Button b;
    static final int ACTIVIDAD_DEVOLVERDATO_1_REQUEST_CODE = 1;
    private static final String TAG = Intent_devolverdato_1.class.getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_devolverdato);
        b= (Button) findViewById(R.id.button5);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intent_devolverdato, menu);
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
    public void Pulsar1 (View view){
        Intent intent = new Intent(this, Intent_devolverdato_1.class);
        startActivityForResult(intent,ACTIVIDAD_DEVOLVERDATO_1_REQUEST_CODE );
    }
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // nombreclase.class.getName()
        if (requestCode == ACTIVIDAD_DEVOLVERDATO_1_REQUEST_CODE) {
            if(resultCode==RESULT_OK) {
                Log.d(TAG, "Recibe intent 2_2 ok");
                String resultado = data.getStringExtra("edittext");
                Toast.makeText(this,resultado, Toast.LENGTH_LONG).show();
            }
        }

    }
}
