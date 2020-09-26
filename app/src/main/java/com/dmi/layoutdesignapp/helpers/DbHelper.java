package com.dmi.layoutdesignapp.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dmi.layoutdesignapp.models.StudentDetailsModel;
import com.dmi.layoutdesignapp.models.StudentModel;

import java.util.ArrayList;

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
        //int update = db.update(TABLE_STUDENT_NAME, contentValues, COLUMN_STUDENT_ID + " = ?", new String[]{studentName});
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<StudentModel> getAllStudents() {
        ArrayList<StudentModel> studentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                StudentModel studentModel = new StudentModel();
                studentModel.setStudentId(cursor.getInt(cursor.getColumnIndex(COLUMN_STUDENT_ID)));
                studentModel.setStudentName(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME)));
                studentModel.setStudentContact(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_CONTACT)));
                studentModel.setStudentPassword(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_PASSWORD)));
                studentList.add(studentModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentList;
    }

    public ArrayList<StudentDetailsModel> getStudentList() {
        ArrayList<StudentDetailsModel> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                StudentDetailsModel studentDetailsModel = new StudentDetailsModel();
                studentDetailsModel.setStudentId(cursor.getInt(cursor.getColumnIndex(COLUMN_STUDENT_ID)));
                studentDetailsModel.setStudentName(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME)));
                studentDetailsModel.setStudentContact(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_CONTACT)));
                studentDetailsModel.setStudentPassword(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_PASSWORD)));
                list.add(studentDetailsModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public StudentModel getStudent(int studentId) {
        StudentModel studentDetailsModel = new StudentModel();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT_NAME + " WHERE " + COLUMN_STUDENT_ID + " = " + studentId;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            studentDetailsModel.setStudentId(cursor.getInt(cursor.getColumnIndex(COLUMN_STUDENT_ID)));
            studentDetailsModel.setStudentName(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME)));
            studentDetailsModel.setStudentContact(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_CONTACT)));
            studentDetailsModel.setStudentPassword(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_PASSWORD)));
        }
        cursor.close();
        db.close();
        return studentDetailsModel;
    }

    public StudentDetailsModel getStudentDetails(int studentId) {
        StudentDetailsModel studentDetailsModel = new StudentDetailsModel();
        SQLiteDatabase database = getReadableDatabase();
        // Select * from Student where studentId = 1;
        String sql = "SELECT * FROM " + TABLE_STUDENT_NAME + " WHERE " + COLUMN_STUDENT_ID + " = " + studentId;
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            studentDetailsModel.setStudentId(cursor.getInt(cursor.getColumnIndex(COLUMN_STUDENT_ID)));
            studentDetailsModel.setStudentName(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME)));
            studentDetailsModel.setStudentContact(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_CONTACT)));
            studentDetailsModel.setStudentPassword(cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_PASSWORD)));
        }
        cursor.close();
        database.close();
        return studentDetailsModel;
    }

    public int updateStudent(int studentId, String studentName, String studentContact, String password) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STUDENT_NAME, studentName);
        contentValues.put(COLUMN_STUDENT_CONTACT, studentContact);
        contentValues.put(COLUMN_STUDENT_PASSWORD, password);
        // string to int conversion
        String studId = String.valueOf(studentId);
        int value = database.update(TABLE_STUDENT_NAME, contentValues, COLUMN_STUDENT_ID + " = ?", new String[]{studId});
        return value;
    }

    public int deleteStudent(int studentId) {
        SQLiteDatabase database = getWritableDatabase();
        String studId = String.valueOf(studentId);
        int returnValue = database.delete(TABLE_STUDENT_NAME, COLUMN_STUDENT_ID + " = ? ", new String[]{studId});
        return returnValue;
    }
}
