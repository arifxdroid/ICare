package com.lazyprogrammer.icare;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DoctorView extends ActionBarActivity {

    private TextView txtDoctorNameView, txtDoctorNumberView, txtDoctorEmailView, txtDoctorAddressView, txtDoctorAboutView;
    private Button btnDoctorOk;

    private DatabaseHelper databaseHelper;
    private Intent intent;
    private int id_doctor;
    private  Doctor doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));

        databaseHelper = new DatabaseHelper(this);
        intent = getIntent();
        id_doctor = intent.getIntExtra("id_doctor", -1);
        doctor = databaseHelper.getADoctor(id_doctor);

        initialize();

        txtDoctorNameView.setText("Doctor Name: " + doctor.getDoctorName());
        txtDoctorNumberView.setText("Phone Number: " + doctor.getDoctorNumber());
        txtDoctorEmailView.setText("Email:  " + doctor.getDoctorEmail());
        txtDoctorAddressView.setText("Address:  " + doctor.getDoctorAddress());
        txtDoctorAboutView.setText("About Doctor: " + doctor.getAboutDoctor());

        btnDoctorOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DoctorView.this, DoctorList.class);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });





    }

    public void initialize(){

        txtDoctorNameView = (TextView)findViewById(R.id.txtDoctorNameView);
        txtDoctorNumberView = (TextView)findViewById(R.id.txtDoctorNumberView);
        txtDoctorEmailView = (TextView)findViewById(R.id.txtDoctorEmailView);
        txtDoctorAddressView = (TextView)findViewById(R.id.txtDoctorAddressView);
        txtDoctorAboutView = (TextView)findViewById(R.id.txtDoctorAboutView);

        btnDoctorOk = (Button)findViewById(R.id.btnDoctorOk);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_doctor_view, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(DoctorView.this, DoctorList.class);
        startActivity(i);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        super.onBackPressed();
    }
}
