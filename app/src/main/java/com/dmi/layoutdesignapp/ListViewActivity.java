package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
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
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, androidVersionList
        );
        listView.setAdapter(arrayAdapter);
    }
}