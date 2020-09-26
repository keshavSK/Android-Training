package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.adapters.StudentListAdapter;
import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentDetailsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StudentDetailsListActivity extends AppCompatActivity {
    private ListView mStudentListView;
    private ArrayList<StudentDetailsModel> studentList;
    DbHelper dbHelper;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_list);
        mStudentListView = findViewById(R.id.studentListView);
        btnAdd = findViewById(R.id.floatingAdd);
        studentList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        studentList = dbHelper.getStudentList();
        StudentListAdapter adapter = new StudentListAdapter(this, studentList);
        mStudentListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        mStudentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                StudentDetailsModel studentDetailsModel = (StudentDetailsModel) adapterView.getItemAtPosition(position);
                int studentId = studentDetailsModel.getStudentId();
                Intent intent = new Intent(StudentDetailsListActivity.this, StudentDetailsActivity.class);
                intent.putExtra("StudentId", studentId);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentDetailsListActivity.this, StudentRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

}