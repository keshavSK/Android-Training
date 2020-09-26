package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentDetailsModel;

public class StudentDetailsActivity extends AppCompatActivity {
    EditText edtStudentName, edtStudentContact, edtStudentPassword;
    Button btnUpdate;
    DbHelper dbHelper;
    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        edtStudentName = findViewById(R.id.tvStudentName);
        edtStudentPassword = findViewById(R.id.tvStudentPassword);
        edtStudentContact = findViewById(R.id.tvStudentContact);
        btnUpdate = findViewById(R.id.btnUpdateStudent);
        dbHelper = new DbHelper(this);
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            studentId = intent.getExtras().getInt("StudentId");
        }
        final StudentDetailsModel studentDetailsModel = dbHelper.getStudentDetails(studentId);
        if (studentDetailsModel == null) {
            Toast.makeText(this, "Student details not available", Toast.LENGTH_SHORT).show();
        } else {
            edtStudentName.setText(studentDetailsModel.getStudentName());
            edtStudentContact.setText(studentDetailsModel.getStudentContact());
            edtStudentPassword.setText(studentDetailsModel.getStudentPassword());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtStudentName.getText().toString().trim();
                String contact = edtStudentContact.getText().toString().trim();
                String password = edtStudentPassword.getText().toString().trim();
                if (studentDetailsModel == null) {
                    Toast.makeText(StudentDetailsActivity.this, "Student Id not available", Toast.LENGTH_SHORT).show();
                    return;
                }
                int value = dbHelper.updateStudent(studentDetailsModel.getStudentId(), name, contact, password);
                Log.d("StudentDetails", "Student Update : " + value);
                if (value == 0) {
                    Toast.makeText(StudentDetailsActivity.this, "Student not updated. Please try again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(StudentDetailsActivity.this, "Student updated successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StudentDetailsActivity.this, StudentDetailsListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}