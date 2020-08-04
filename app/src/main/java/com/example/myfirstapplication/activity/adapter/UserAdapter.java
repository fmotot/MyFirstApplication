package com.example.myfirstapplication.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View userLine = li.inflate(R.layout.style_user_list, parent,false);

        TextView tvFirstName = userLine.findViewById(R.id.tv_firstname);
        tvFirstName.setText(getItem(position).getFirstName());

        TextView tvLastName = userLine.findViewById(R.id.tv_lastname);
        tvLastName.setText(getItem(position).getLastName());


        return super.getView(position, convertView, parent);
    }
}
