package com.lazyprogrammer.icare;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class AddDietChart extends ActionBarActivity {

    private Spinner spnDay, spnMeal;
    private EditText etFood;
    private Button btnSave;
    private  Intent intent;

    private String[] dayList = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] mealList = {"Breakfast", "Lunch", "Dinner"};

    ArrayAdapter<String> adapterDayList, adapterMealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet_chart);

//        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));

        spnDay = (Spinner)findViewById(R.id.spnDay);
        spnMeal = (Spinner)findViewById(R.id.spnMeal);
        etFood = (EditText)findViewById(R.id.etFood);
        btnSave = (Button)findViewById(R.id.btnSave);

        adapterDayList = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner, R.id.txtSpinner, dayList);
        spnDay.setAdapter(adapterDayList);

        adapterMealList = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner, R.id.txtSpinner, mealList);
        spnMeal.setAdapter(adapterMealList);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(AddDietChart.this, MyDietChart.class);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
        });

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_add_diet_chart, menu);
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

        Intent i= new Intent(AddDietChart.this, MyDietChart.class);
        startActivity(i);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        super.onBackPressed();
    }
}
