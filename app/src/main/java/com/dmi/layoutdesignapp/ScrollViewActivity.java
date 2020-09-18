package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.helpers.DatabaseHelper;

public class ScrollViewActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtContact, edtAddress, edtCity, edtState, edtCountry, edtPassword;
    Button btnSubmit;
    TextView tvDisplayDetails;
    DatabaseHelper _daDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtContact = findViewById(R.id.edt_contact);
        edtAddress = findViewById(R.id.edt_address);
        edtCity = findViewById(R.id.edt_city);
        edtState = findViewById(R.id.edt_state);
        edtCountry = findViewById(R.id.edt_country);
        edtPassword = findViewById(R.id.edt_Password);
        btnSubmit = findViewById(R.id.btn_submit);
        tvDisplayDetails = findViewById(R.id.tvDisplayDetails);
        _daDatabaseHelper = new DatabaseHelper(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String contact = edtContact.getText().toString().trim();
                String address = edtAddress.getText().toString().trim();
                String city = edtCity.getText().toString().trim();
                String state = edtState.getText().toString().trim();
                String country = edtCountry.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                boolean isInserted = _daDatabaseHelper.insertStudentDetails(name, contact, password);
                if (isInserted) {
                    Toast.makeText(ScrollViewActivity.this, "Inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScrollViewActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}