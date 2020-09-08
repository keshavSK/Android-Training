package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MobileGridViewActivity extends AppCompatActivity {

    String[] mobileList = {
            "Apple",
            "Samsung",
            "Redmi",
            "Vivo",
            "RealMe",
            "OnePlus",
            "Oppo",
            "Oppo",
            "Oppo",
            "Oppo",
            "Oppo",
    };
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_grid_view);
        gridView = findViewById(R.id.gridViewMobileList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mobileList
        );
        gridView.setAdapter(arrayAdapter);
    }
}