package com.dmi.layoutdesignapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    TextView tvSignUp, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        btnLogin = findViewById(R.id.btn_relative_login);
        edtUsername = findViewById(R.id.edt_relative_username);
        edtPassword = findViewById(R.id.edt_relative_password);
        tvSignUp = findViewById(R.id.tv_sign_up);
        tvForgotPassword = findViewById(R.id.tv_relative_forgot_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                Toast.makeText(RelativeLayoutActivity.this, password, Toast.LENGTH_SHORT).show();
            }
        });
    }
}