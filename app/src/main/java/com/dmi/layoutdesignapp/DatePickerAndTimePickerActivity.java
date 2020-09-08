package com.dmi.layoutdesignapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DatePickerAndTimePickerActivity extends AppCompatActivity {

    Button btnShowDatePicker, btnShowTimerPicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_and_time_picker);
        btnShowDatePicker = findViewById(R.id.btnShowDatePickerDialog);
        btnShowTimerPicker = findViewById(R.id.btnShowTimePickerDialog);

        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _showDatePicker();
            }
        });

        btnShowTimerPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _showTimerPicker();
            }
        });
    }

    private void _showTimerPicker() {
        int hours, minutes;
        calendar = Calendar.getInstance();
        hours = calendar.get(Calendar.HOUR);
        minutes = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(DatePickerAndTimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                String selectedTime = hours + ":" + minutes;
                Toast.makeText(DatePickerAndTimePickerActivity.this, "Selected Time : " + selectedTime, Toast.LENGTH_SHORT).show();
            }
        }, hours, minutes, false);
        timePickerDialog.show();
    }

    private void _showDatePicker() {
        int year, month, dayOfMonth;
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePickerDialog = new DatePickerDialog(DatePickerAndTimePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // 25-8-2020
                //25/8/2020
                //2020-08-28
                String selectedDay = day + "-" + (month + 1) + "-" + year;
                Toast toast = Toast.makeText(DatePickerAndTimePickerActivity.this, "Selected Date : " + selectedDay, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
                toast.show();
            }
        }, year, month, dayOfMonth);
        mDatePickerDialog.show();
    }
}