package com.lazyprogrammer.icare;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class UpdateProfile extends ActionBarActivity {
    EditText etPatientName, etAge,etHeight,etWeight,etPhone,etEmail,etPatientCondition;
    ImageView imageView;
    TextView tvCurrentDate,tvBloodGroup,tvGender;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile);
        etPatientName = (EditText)findViewById(R.id.etPatientName);
        tvCurrentDate= (TextView) findViewById(R.id.tvCurrentDate);
        tvBloodGroup= (TextView) findViewById(R.id.tvBloodGroup);
        tvGender= (TextView) findViewById(R.id.tvGender);
        etAge= (EditText) findViewById(R.id.etAge);
        etHeight= (EditText) findViewById(R.id.etHeight);
        etWeight= (EditText) findViewById(R.id.etWeight);
        etPhone= (EditText) findViewById(R.id.etPhone);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPatientCondition= (EditText) findViewById(R.id.etPatientCondition);
        imageView= (ImageView) findViewById(R.id.imageView);
        btnSave = (Button)findViewById(R.id.btnSave);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_profile, menu);
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
