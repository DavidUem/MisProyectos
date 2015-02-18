package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ImplicitIntents extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
    }

    public void onClickWebBrowser(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uem.es."));
        startActivity(i);
    }
    public void onClickShowTelephone(View view){
        String number = " 902232350";
        Intent ii = new Intent (Intent.ACTION_CALL);
        ii.setData(Uri.parse("tel:" + number));
        startActivity(ii);
    }



    public void onClickShowMap(View view){
        Uri gmmIntentUri = Uri.parse("geo:40.3736,-3.919848");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_implicit_intents, menu);
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
