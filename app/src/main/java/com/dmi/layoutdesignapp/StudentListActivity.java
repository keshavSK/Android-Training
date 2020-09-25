package com.dmi.layoutdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dmi.layoutdesignapp.adapters.StudentAdapter;
import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentModel;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {
    private ListView mListView;
    StudentAdapter studentAdapter;
    DbHelper dbHelper;
    ArrayList<StudentModel> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        mListView = findViewById(R.id.listViewStudent);
        studentList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        studentList = dbHelper.getAllStudents();
        studentAdapter = new StudentAdapter(this, studentList);
        mListView.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(StudentListActivity.this, StudentDetailsActivity.class));
            }
        });
    }
}