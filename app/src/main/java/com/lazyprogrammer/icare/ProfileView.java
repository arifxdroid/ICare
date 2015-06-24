package com.lazyprogrammer.icare;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileView extends ActionBarActivity {

    TextView tvPatientName,tvGender,tvBloodGroup,tvCurrentDate,tvAge,tvHeight,tvWeight,tvPhone,tvEmail,tvPatientCondition;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);
        initialize();
    }

    private void initialize() {

        tvPatientName = (TextView) findViewById(R.id.tvPatientName);
        tvGender = (TextView) findViewById(R.id.tvGender);
        tvBloodGroup = (TextView) findViewById(R.id.tvBloodGroup);
        tvCurrentDate = (TextView) findViewById(R.id.tvCurrentDate);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvWeight = (TextView) findViewById(R.id.tvWeight);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPatientCondition = (TextView) findViewById(R.id.tvPatientCondition);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_view, menu);
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
