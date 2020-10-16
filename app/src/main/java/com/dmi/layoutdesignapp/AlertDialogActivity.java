package com.dmi.layoutdesignapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {
    Button btnShowDialog;
    private TextView tvStudentId, tvStudentName, tvStudentContact, tvLogout;
    SharedPreferences preferences;
    private static final String SHAREPREF = "UserSharePref";
    String studentName, studentContact;
    int studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btnShowDialog = findViewById(R.id.showDialog);
        tvStudentId = findViewById(R.id.tvAlertStudentId);
        tvStudentName = findViewById(R.id.tvAlertStudentName);
        tvStudentContact = findViewById(R.id.tvAlertStudentContact);
        tvLogout = findViewById(R.id.tvAlertLogout);
        preferences = getSharedPreferences(SHAREPREF, Context.MODE_PRIVATE);
        studentId = preferences.getInt("StudentId", 0);
        studentName = preferences.getString("StudentName", "Not found");
        studentContact = preferences.getString("StudentContact", "Not found");
        tvStudentId.setText("" + studentId);
        tvStudentName.setText(studentName);
        tvStudentContact.setText(studentContact);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showDialog();
                showAlertDialog();
            }
        });
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(AlertDialogActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
        mBuilder.setTitle("Alert Dialog");
        mBuilder.setMessage("This is showing alert");
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        builder.setTitle("Exits");
        builder.setMessage("Are you sure want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "Exit from app", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "No", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}