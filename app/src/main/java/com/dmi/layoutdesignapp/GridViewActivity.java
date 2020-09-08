package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity {
    String[] androidVersionList = {
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Nougat",
            "Oreo",
            "Pie",
            "Android 10",
            "Android 11"
    };
    GridView _griView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        _griView = findViewById(R.id.gridView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, androidVersionList
        );
        _griView.setAdapter(arrayAdapter);
    }
}