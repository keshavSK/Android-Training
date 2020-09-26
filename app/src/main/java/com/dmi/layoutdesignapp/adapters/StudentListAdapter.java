package com.dmi.layoutdesignapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dmi.layoutdesignapp.R;
import com.dmi.layoutdesignapp.StudentDetailsListActivity;
import com.dmi.layoutdesignapp.helpers.DbHelper;
import com.dmi.layoutdesignapp.models.StudentDetailsModel;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentDetailsModel> list;
    DbHelper dbHelper;

    public StudentListAdapter(Context context, ArrayList<StudentDetailsModel> list) {
        this.context = context;
        this.list = list;
        dbHelper = new DbHelper(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater.from(context));
        final View convertView = inflater.inflate(R.layout.row_student, viewGroup, false);
        TextView tvStudentName = convertView.findViewById(R.id.rowStudentName);
        TextView tvStudentContact = convertView.findViewById(R.id.rowStudentContact);
        TextView tvStudentPassword = convertView.findViewById(R.id.rowStudentPassword);
        ImageView imgDelete = convertView.findViewById(R.id.imgDeleteStudent);
        tvStudentName.setText(list.get(position).getStudentName());
        tvStudentContact.setText(list.get(position).getStudentContact());
        tvStudentPassword.setText(list.get(position).getStudentPassword());
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = dbHelper.deleteStudent(list.get(position).getStudentId());
                if (value == 0) {
                    Toast.makeText(context, "Student not deleted.Please try again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, StudentDetailsListActivity.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            }
        });
        return convertView;
    }
}
