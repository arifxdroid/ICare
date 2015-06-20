package com.lazyprogrammer.icare;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;


public class AllService extends ActionBarActivity {

   private ImageButton ibProfile,ibVaccination,ibDiet,ibMyDoctor,ibMedicineRoutine,ibNote,ibEmergencyCall,ibPrescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_service);

        initialize();
    }

    private void initialize() {

        ibProfile= (ImageButton) findViewById(R.id.ibProfile);
        ibVaccination= (ImageButton) findViewById(R.id.ibVaccination);
        ibDiet= (ImageButton) findViewById(R.id.ibDiet);
        ibMyDoctor= (ImageButton) findViewById(R.id.ibMyDoctor);
        ibMedicineRoutine= (ImageButton) findViewById(R.id.ibMedicineRoutine);
        ibNote= (ImageButton) findViewById(R.id.ibNote);
        ibEmergencyCall= (ImageButton) findViewById(R.id.ibEmergencyCall);
        ibPrescription= (ImageButton) findViewById(R.id.ibPrescription);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all, menu);
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
