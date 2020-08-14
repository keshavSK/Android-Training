package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class IntentIntroductionActivity extends AppCompatActivity {
    private Button btnExplicitIntent, btnImplicitIntent;
    double latitude = 19.9975;
    double longitude = 73.7898;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_introduction);
        btnExplicitIntent = findViewById(R.id.btnExplicitIntent);
        btnImplicitIntent = findViewById(R.id.btnImplicitIntent);
        btnExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentIntroductionActivity.this, OptionMenuActivity.class);
                startActivity(intent);
            }
        });
        btnImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}