package com.dmi.layoutdesignapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SharePreferenceActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHAREPREF = "UserSharePref";
    private EditText edtUsername;
    private Button btnSave, btnRetrieve, btnClear;
    private TextView tvData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);
        edtUsername = findViewById(R.id.edtSharePrefUsername);
        btnSave = findViewById(R.id.btnSharePrefSave);
        btnClear = findViewById(R.id.btnSharePrefClear);
        btnRetrieve = findViewById(R.id.btnSharePrefGetData);
        tvData = findViewById(R.id.tvSharePrefGetData);
        sharedPreferences = getSharedPreferences(SHAREPREF, Context.MODE_PRIVATE);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", username);
                editor.apply();
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = sharedPreferences.getString("Username", "Not found");
                tvData.setText(username);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });
    }
}