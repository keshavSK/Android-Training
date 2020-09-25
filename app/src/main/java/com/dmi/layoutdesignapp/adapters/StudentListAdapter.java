package com.dmi.layoutdesignapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dmi.layoutdesignapp.R;
import com.dmi.layoutdesignapp.models.StudentDetailsModel;

import java.util.ArrayList;

public class StudentListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StudentDetailsModel> list;

    public StudentListAdapter(Context context, ArrayList<StudentDetailsModel> list) {
        this.context = context;
        this.list = list;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater.from(context));
        View convertView = inflater.inflate(R.layout.row_student, viewGroup, false);
        TextView tvStudentName = convertView.findViewById(R.id.rowStudentName);
        TextView tvStudentContact = convertView.findViewById(R.id.rowStudentContact);
        TextView tvStudentPassword = convertView.findViewById(R.id.rowStudentPassword);
        tvStudentName.setText(list.get(position).getStudentName());
        tvStudentContact.setText(list.get(position).getStudentContact());
        tvStudentPassword.setText(list.get(position).getStudentPassword());
        return convertView;
    }
}
