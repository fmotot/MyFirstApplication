package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.view_model.UserViewModel;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    @Override
    protected void onResume() {
        super.onResume();

        UserViewModel vm = ViewModelProviders.of(this).get(UserViewModel.class);

        int id = getIntent().getIntExtra(UserListActivity.ITEM_ID,0);

        LiveData<User> observer = vm.get(id);
        observer.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                EditText etFirstName = findViewById(R.id.et_firstname);
                EditText etLastName = findViewById(R.id.et_lastname);

                etFirstName.setText(user.getFirstName());
                etLastName.setText(user.getLastName());
            }
        });
    }
}