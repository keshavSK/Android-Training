package com.dmi.layoutdesignapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmi.layoutdesignapp.R;
import com.dmi.layoutdesignapp.models.StudentModel;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentModel> studentModelList;

    public StudentAdapter(Context context, ArrayList<StudentModel> studentModelList) {
        this.context = context;
        this.studentModelList = studentModelList;
    }

    @Override
    public int getCount() {
        return studentModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater.from(context));
        View view1 = inflater.inflate(R.layout.row_student_list, viewGroup, false);
        TextView tvStudentName = view1.findViewById(R.id.rowStudentName);
        tvStudentName.setText(studentModelList.get(i).getStudentName());
        return view1;
    }
}
