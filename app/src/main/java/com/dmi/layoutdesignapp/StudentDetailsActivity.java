package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentDetailsModel;

public class StudentDetailsActivity extends AppCompatActivity {
    TextView tvStudentName, tvStudentContact, tvStudentPassword;
    DbHelper dbHelper;
    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        tvStudentName = findViewById(R.id.tvStudentName);
        tvStudentPassword = findViewById(R.id.tvStudentPassword);
        tvStudentContact = findViewById(R.id.tvStudentContact);
        dbHelper = new DbHelper(this);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            studentId = intent.getExtras().getInt("StudentId");
        }
        StudentDetailsModel studentDetailsModel = dbHelper.getStudentDetails(studentId);
        if (studentDetailsModel == null) {
            Toast.makeText(this, "Student details not available", Toast.LENGTH_SHORT).show();
        } else {
            tvStudentName.setText(studentDetailsModel.getStudentName());
            tvStudentContact.setText(studentDetailsModel.getStudentContact());
            tvStudentPassword.setText(studentDetailsModel.getStudentPassword());
        }
    }
}