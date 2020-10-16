package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.helpers.DbHelper;

public class StudentRegistrationActivity extends AppCompatActivity {
    private EditText edtName, edtContact, edtPassword;
    private Button btnRegister;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        edtName = findViewById(R.id.edtStudentName);
        edtContact = findViewById(R.id.edtStudentContact);
        edtPassword = findViewById(R.id.edtStudentPassword);
        btnRegister = findViewById(R.id.btnStudentRegister);
        dbHelper = new DbHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = edtName.getText().toString().trim();
                String studentContact = edtContact.getText().toString().trim();
                String studentPassword = edtPassword.getText().toString().trim();
                boolean isInserted = dbHelper.insertStudent(studentName, studentContact, studentPassword);
                if (isInserted) {
                    Toast.makeText(StudentRegistrationActivity.this, "Student Registration Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentRegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(StudentRegistrationActivity.this, "Please try again. Student not registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}