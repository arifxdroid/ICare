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
    private ArrayList<PatientTemplate> allPatient;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        allPatient = databaseHelper.getAllPatient();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));

        lvName = (ListView)findViewById(R.id.lvName);

//        CustomListAdapter listAdapter = new CustomListAdapter(this, allPatient);
//        lvName.setAdapter(listAdapter);

        ListAdapter listAdapter = new ListAdapter(this, allPatient);
        lvName.setAdapter(listAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_add) {

            Intent i = new Intent(MainActivity.this, CreateProfile.class);
            startActivity(i);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
