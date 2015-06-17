package com.lazyprogrammer.icare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;


public class CreateProfile extends ActionBarActivity {


    EditText etPatientName,etBlood,etCurrentDate, etAge,etHeight,etWeight,etPhone,etEmail,etPatientCondition;
    ImageView imageView;
    Spinner spnType;
    Button btnSave;

    private String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    private int DATE_PICKER = 1;
    private String[] typeList={"My Own","Father","Mother","Brother","Sister","Grand Father","Grand Mother","Children","Other"};
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


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Choose from Gallery"), 1);
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom_spinner,R.id.txtSpinner,typeList);
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

        etCurrentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etPatientName.getText().toString();
                String bloodGroup = etBlood.getText().toString();
                String currentDate = etCurrentDate.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());
                double height = Double.parseDouble(etHeight.getText().toString());
                double weight = Double.parseDouble(etWeight.getText().toString());
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String patientCondition = etPatientCondition.getText().toString();

                Patient patient = new Patient(name , profileType , gender , bloodGroup , currentDate , age , height , weight , phone , email , patientCondition , imgUri);


            }
        });

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

        etPatientName = (EditText)findViewById(R.id.etPatientName);
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
        btnSave = (Button)findViewById(R.id.btnSave);

    }


    @Override
    protected Dialog onCreateDialog(int id) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        switch (id){

            case 1:

                return new DatePickerDialog(this,datePickerListener, year, month, day);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

            if (etCurrentDate.getText().toString() != null){
                etCurrentDate.setText(" ");
                etCurrentDate.setText(dayOfMonth+" - "+months[monthOfYear]+" - "+year);
            }else {

                etCurrentDate.setText(dayOfMonth+" - "+months[monthOfYear]+" - "+year);
            }

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                imgUri = data.getData();
                imageView.setImageURI(data.getData());
            }
        }
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
