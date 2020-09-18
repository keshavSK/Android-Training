package com.dmi.layoutdesignapp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student";
    private static final String COLUMN_STUDENT_ID = "StudentId";
    private static final String COLUMN_STUDENT_NAME = "StudentName";
    private static final String COLUMN_STUDENT_MOBILE = "StudentMobile";
    private static final String COLUMN_STUDENT_PASSWORD = "StudentPassword";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUDENT_NAME + " TEXT, " +
                COLUMN_STUDENT_MOBILE + " TEXT, " +
                COLUMN_STUDENT_PASSWORD + " TEXT " +
                ")";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // DATABASE OPERATION
    public boolean insertStudentDetails(String name, String mobile, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STUDENT_NAME, name);
        contentValues.put(COLUMN_STUDENT_MOBILE, mobile);
        contentValues.put(COLUMN_STUDENT_PASSWORD, password);
        long id = database.insert(TABLE_NAME, null, contentValues);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }
}
