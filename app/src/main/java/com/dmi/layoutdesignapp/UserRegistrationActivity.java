package com.dmi.layoutdesignapp;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserRegistrationActivity extends AppCompatActivity {
    EditText edtUsername, edtMobileNumber, edtEmailAddress;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        edtUsername = findViewById(R.id.edt_username);
        edtMobileNumber = findViewById(R.id.edtMobileNumber);
        edtEmailAddress = findViewById(R.id.edtEmailAddress);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String mobileNumber = edtMobileNumber.getText().toString();
                String emailId = edtEmailAddress.getText().toString();
                if (username.equals("")) {
                    Toast.makeText(UserRegistrationActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidMobileNumber(mobileNumber) || mobileNumber.length() > 10 || mobileNumber.length() < 9) {
                    Toast.makeText(UserRegistrationActivity.this, "Please enter Valid mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidEmailId(emailId)) {
                    Toast.makeText(UserRegistrationActivity.this, "Please enter valid email Id", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(UserRegistrationActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean isValidMobileNumber(String mobileNumber) {
        return Patterns.PHONE.matcher(mobileNumber).matches();
    }

    private boolean isValidEmailId(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}