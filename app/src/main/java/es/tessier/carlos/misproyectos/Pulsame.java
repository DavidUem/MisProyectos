package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Pulsame extends Activity {
 Button button;
 private int NumVeces;
 private final static String contador="NumVeces";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsame);
        button= (Button) findViewById(R.id.button2);

        if (savedInstanceState != null){
         NumVeces = savedInstanceState.getInt(contador);
          button.setText("el contador ha sido pulsado" + NumVeces +"veces" );
       }
    }

    public void onClick(View v){
        button.setText("el contador ha sido pulsado" + ++NumVeces +"veces");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pulsame, menu);
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



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(contador,NumVeces);
    }
}
