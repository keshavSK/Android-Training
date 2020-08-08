package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollViewActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtContact, edtAddress, edtCity, edtState, edtCountry, edtPinCode;
    Button btnSubmit;
    TextView tvDisplayDetails;

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
        edtPinCode = findViewById(R.id.edt_pinCode);
        btnSubmit = findViewById(R.id.btn_submit);
        tvDisplayDetails = findViewById(R.id.tvDisplayDetails);

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
                String pinCode = edtPinCode.getText().toString().trim();

                tvDisplayDetails.setText("Name : "+name + "\nEmail : "+email + "\nContact : "+contact);

            }
        });
    }
}