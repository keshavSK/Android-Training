package com.dmi.layoutdesignapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateAndTimePickerActivity extends AppCompatActivity {
    Button btnShowDatePicker, btnTimerPicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);
        btnShowDatePicker = findViewById(R.id.btnShowDatePicker);
        btnTimerPicker = findViewById(R.id.btnShowTimePicker);

        btnShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _showDatePicker();
            }
        });

        btnTimerPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _showTimerPicker();
            }
        });
    }

    private void _showTimerPicker() {
        final int hour, minute;
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog mTimePickerDialog = new TimePickerDialog(DateAndTimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hours, int minute) {

                String selectedTime = hours + ":" + minute;
                Toast.makeText(DateAndTimePickerActivity.this, "Selected Time : " + selectedTime, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, false);
        mTimePickerDialog.show();
    }

    private void _showDatePicker() {
        int year, month, day;
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(DateAndTimePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(DateAndTimePickerActivity.this, "Selected Date : " + selectedDate, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        mDatePicker.show();
    }

}