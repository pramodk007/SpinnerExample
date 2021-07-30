package com.androiddev.customfonts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp_selectFruits;
    TextView tv_showFruit;
    //data for my spinner
    String[] fruits = {"please select any one fruit you like","apple","mango","watermelon","berry","papaya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking the views
        sp_selectFruits = findViewById(R.id.sp_selectfruits);
        tv_showFruit = findViewById(R.id.tv_showFruit);

        //creating adapter for the spinner to pass the data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,fruits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //connecting the adapter to the spinner
        sp_selectFruits.setAdapter(adapter);

        //event
        sp_selectFruits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    tv_showFruit.setText("");
                }else{
                    tv_showFruit.setText(getString(R.string.message)+fruits[position]);
                    tv_showFruit.setTextColor(Color.RED);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}