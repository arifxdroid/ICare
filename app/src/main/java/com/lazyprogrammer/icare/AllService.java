package com.lazyprogrammer.icare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class AllService extends ActionBarActivity {

    private ImageButton ibProfile,ibVaccination,ibDiet,ibMyDoctor,ibMedicineRoutine,ibNote,ibEmergencyCall,ibPrescription;
    static int patient_id;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_service);

        initialize();

        intent = getIntent();

        if (intent.getIntExtra("patient_id",-1) == -1 ){

            patient_id = intent.getIntExtra("patient_id",0);
            SharedPreferences sharedPreferences=getSharedPreferences("allService",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("patient_id",patient_id);
            editor.commit();

        }

        else {

            SharedPreferences preferences = getSharedPreferences("allService", Context.MODE_PRIVATE);
            preferences.getInt("patient_id",patient_id);

        }

        ibDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(AllService.this, MyDietChart.class);
                i.putExtra("patient_id", patient_id);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });

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

    @Override
    public void onBackPressed() {

        Intent i= new Intent(AllService.this, MainActivity.class);
        startActivity(i);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        super.onBackPressed();
    }
}
