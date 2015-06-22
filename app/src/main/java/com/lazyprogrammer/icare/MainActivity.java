package com.lazyprogrammer.icare;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));
        actionBar.setLogo(R.mipmap.ic_launcher);

        lvName = (ListView)findViewById(R.id.lvName);

        ListAdapter listAdapter = new ListAdapter(this, allPatient);
        lvName.setAdapter(listAdapter);
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                PatientTemplate patient = allPatient.get(position);
                int patient_id = patient.getId();

                Intent i = new Intent(MainActivity.this, AllService.class);
                i.putExtra("patient_id", patient_id);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
        registerForContextMenu(lvName);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_main, menu);;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){

            case R.id.action_delete:
                break;
            case R.id.action_edit:
                break;
        }

        return super.onContextItemSelected(item);
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
