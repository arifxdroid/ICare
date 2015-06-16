package com.lazyprogrammer.icare;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class CreateProfile extends ActionBarActivity {
    EditText etBlood,etCurrentDate, etAge,etHeight,etWeight,etPhone,etEmail,etPatientCondition;
    ImageView imageView;
    Spinner spnType;
    String[] typeList={"My Own","Father","Mother","Brother","Sister","Grand Father","Grand Mother","Children","Other"};
    private String profileType;
    private String gender;
    private Uri imgUri = Uri.parse("android.resource://com.lazyprogrammer.icare/drawable/pa.png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);
        setInitialize();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));
    }

    public void onRadioButtonClick(View v){

        boolean checked= ((RadioButton)v).isChecked();

        switch (v.getId()){

            case R.id.rbMale:
                if (checked)
                    gender = "Male";
                break;

            case R.id.rbFemale:
                if (checked)
                    gender = "Female";
                break;

        }
    }

    public void setInitialize() {
        etBlood= (EditText) findViewById(R.id.etBlood);
        etCurrentDate= (EditText) findViewById(R.id.etCurrentDate);
        etAge= (EditText) findViewById(R.id.etAge);
        etHeight= (EditText) findViewById(R.id.etHeight);
        etWeight= (EditText) findViewById(R.id.etWeight);
        etPhone= (EditText) findViewById(R.id.etPhone);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPatientCondition= (EditText) findViewById(R.id.etPatientCondition);
        imageView= (ImageView) findViewById(R.id.imageView);
        spnType= (Spinner) findViewById(R.id.spnType);

    }
    public void getData() {

        String bloodGroup=etBlood.getText().toString();
        String currentDate=etCurrentDate.getText().toString();
        String age=etAge.getText().toString();
        String height=etHeight.getText().toString();
        String weight=etWeight.getText().toString();
        String phone=etPhone.getText().toString();
        String email=etEmail.getText().toString();
        String patientCondition=etPatientCondition.getText().toString();
        profileType = null;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,typeList);
        spnType.setAdapter(adapter);
        spnType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                profileType = typeList[pos];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void btnSave(View v){
        getData();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_profile, menu);
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
