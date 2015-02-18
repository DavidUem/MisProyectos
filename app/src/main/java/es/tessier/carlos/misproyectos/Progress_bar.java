package es.tessier.carlos.misproyectos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class Progress_bar extends Activity {
    ProgressDialog progressDialog;
    ProgressBar sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        sp = (ProgressBar) findViewById(R.id.progressBar);
        sp.setVisibility(View.GONE);

    }
    //método para el tercer botón
    public void Muestra_ProgressBar_Ventana(){
        if(sp.getVisibility()==View.INVISIBLE)
            sp.setVisibility(View.VISIBLE);
        else
            sp.setVisibility(View.INVISIBLE);
    }

    // método para el primer botón del layout.
    public void progressDialog(View button){
    final ProgressDialog dialog = ProgressDialog.show(this,"Cargando ventana","Espere...", true);
        new Thread(new Runnable(){
            public void run(){
                try{
        //simulamosquehacemosunaactividad
        //prolongada
                    Thread.sleep(3000);
                    dialog.dismiss();

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    ProgressDialog createProgressDialog(){
    ProgressDialog progressDialog = new ProgressDialog(this);
    progressDialog.setIcon(R.drawable.ic_launcher);
    progressDialog.setTitle("Moviendo imagenes");
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        return progressDialog;
    }
    //Método para el segundo botón
    public void ProgressBar(View button) {


        progressDialog = createProgressDialog();
        progressDialog.show();
        progressDialog.setProgress(0);

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        Thread.sleep(1000);
                        progressDialog.incrementProgressBy((int) (100 / 10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_progress_bar, menu);
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
