package com.lazyprogrammer.icare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyDietChart extends ActionBarActivity {

    private ListView lvDiet;
    static int patient_id;
    Intent intent;
    private ArrayList<Diet> allChart;
    private DatabaseHelper databaseHelper;
    private DietAdapter dietAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet_chart);

        databaseHelper = new DatabaseHelper(this);

        intent = getIntent();

        if (intent.getIntExtra("patient_id",-1) != -1){

            patient_id = intent.getIntExtra("patient_id", 0);
            SharedPreferences sharedPreferences=getSharedPreferences("allService", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("patient_id",patient_id);
            editor.commit();

        }

        else {

            SharedPreferences preferences = getSharedPreferences("allService",MODE_PRIVATE);
            preferences.getInt("patient_id",patient_id);

        }

        allChart = databaseHelper.getDietChart(patient_id);
        lvDiet = (ListView)findViewById(R.id.lvDiet);
        dietAdapter = new DietAdapter(this,allChart);
        lvDiet.setAdapter(dietAdapter);
        registerForContextMenu(lvDiet);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_diet_chart, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Diet d = allChart.get(info.position);


        switch (item.getItemId()){

            case R.id.action_edit_diet:
                break;
            case R.id.action_delete_diet:

                int deleted = databaseHelper.deleteDietChartSingle(d.getId_diet());

                if (deleted >0 ){

                    Toast.makeText(getApplicationContext(), "Delete success!", Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(getApplicationContext(), "Delete failed!", Toast.LENGTH_SHORT).show();

                }
                dietAdapter.notifyDataSetChanged();
                lvDiet.setAdapter(dietAdapter);
                break;
            case R.id.action_deleteall_diet:
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onPostResume() {

        dietAdapter = new DietAdapter(this,allChart);
        lvDiet.setAdapter(dietAdapter);
        super.onPostResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_diet_chart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_addDiet) {

            Intent i = new Intent(MyDietChart.this, AddDietChart.class);
            i.putExtra("patient_id", patient_id);
            startActivity(i);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent i= new Intent(MyDietChart.this, AllService.class);
        startActivity(i);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        super.onBackPressed();
    }
}
