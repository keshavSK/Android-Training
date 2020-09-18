package com.dmi.layoutdesignapp.helperss;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dmI.db";
    private static final String TABLE_STUDENT_NAME = "StudentTable";
    private static final String COLUMN_STUDENT_ID = "StudentId";
    private static final String COLUMN_STUDENT_NAME = "StudentName";
    private static final String COLUMN_STUDENT_CONTACT = "StudentContact";
    private static final String COLUMN_STUDENT_PASSWORD = "StudentPassword";
    private static final String TABLE_PERSON_NAME = "PersonTable";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String table = "Create Table StudentTable (StudentId Integer primary autoincrement, StudentName TEXT, StudentContact TEXT, StudentPassword TEXT)";
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT_NAME + "(" +
                COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUDENT_NAME + " TEXT, " +
                COLUMN_STUDENT_CONTACT + " TEXT, " +
                COLUMN_STUDENT_PASSWORD + " TEXT " +
                ")";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_NAME);
        onCreate(sqLiteDatabase);
    }

    // STUDENT TABLE OPERATION

    public boolean insertStudent(String studentName, String studentContact, String studentPassword) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STUDENT_NAME, studentName);
        contentValues.put(COLUMN_STUDENT_CONTACT, studentContact);
        contentValues.put(COLUMN_STUDENT_PASSWORD, studentPassword);
        long id = db.insert(TABLE_STUDENT_NAME, null, contentValues);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void getStudentDetails() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT_NAME;
        db.execSQL(sql);
    }
}
