package com.dmi.layoutdesignapp.models;

public class StudentDetailsModel {
    int studentId;
    String studentName;
    String studentContact;
    String studentPassword;

    public StudentDetailsModel() {
    }

    public StudentDetailsModel(int studentId, String studentName, String studentContact, String studentPassword) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentContact = studentContact;
        this.studentPassword = studentPassword;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
