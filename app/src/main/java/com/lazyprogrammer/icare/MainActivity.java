package com.lazyprogrammer.icare;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView lvName;
    private ProfileDAO profileDAO;
    private ArrayList<Patient> allPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileDAO = new ProfileDAO(this);
        allPatient = profileDAO.getAllPatient();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));

        lvName = (ListView)findViewById(R.id.lvName);

        CustomListAdapter listAdapter = new CustomListAdapter(this, allPatient);
        lvName.setAdapter(listAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent i = new Intent(MainActivity.this, CreateProfile.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
