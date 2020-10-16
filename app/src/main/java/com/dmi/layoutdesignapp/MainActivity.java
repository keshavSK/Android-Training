package com.dmi.layoutdesignapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentModel;

public class MainActivity extends AppCompatActivity {
    private TextView tvSignUp;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private DbHelper _dDbHelper;
    SharedPreferences sharedPreferences;
    private static final String SHAREPREF = "UserSharePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSignUp = findViewById(R.id.tvSignUp);
        edtUsername = findViewById(R.id.edtMainUsername);
        edtPassword = findViewById(R.id.edtMainPassword);
        btnLogin = findViewById(R.id.btnMainLogin);
        _dDbHelper = new DbHelper(this);
        sharedPreferences = getSharedPreferences(SHAREPREF, Context.MODE_PRIVATE);
        int student = sharedPreferences.getInt("StudentId", 0);
        if (student > 0) {
            Intent intent = new Intent(this, AlertDialogActivity.class);
            startActivity(intent);
            finish();
        }

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentRegistrationActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                StudentModel studentModel = _dDbHelper.signIn(username, password);
                if (studentModel == null || studentModel.getStudentId() < 1) {
                    Toast.makeText(MainActivity.this, "Please enter correct credentials", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("StudentId", studentModel.getStudentId());
                editor.putString("StudentName", studentModel.getStudentName());
                editor.putString("StudentContact", studentModel.getStudentContact());
                editor.apply();
                Intent intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}