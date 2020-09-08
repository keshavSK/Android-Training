package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AndroidVersionListViewActivity extends AppCompatActivity {
    String[] mobileList = {
            "Samsung",
            "Apple",
            "Vivo",
            "Oppo",
            "RealMe",
            "OnePlus",
            "Redmi",
    };
    String[] samsungMobileList = {
            "Galaxy S6",
            "Galaxy M30",
            "Galaxy M21",
            "Galaxy M10",
            "Galaxy Note 10",
            "Galaxy A70",
            "Galaxy A70",
    };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_version_list_view);
        listView = findViewById(R.id.listViewMobileList);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                samsungMobileList
        );
        listView.setAdapter(stringArrayAdapter);
    }


}