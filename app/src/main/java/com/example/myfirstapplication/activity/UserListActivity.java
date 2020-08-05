package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.activity.adapter.UserAdapter;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.view_model.UserViewModel;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    public static final String ITEM_ID = "itemId";

    private ListView list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("===================================", "onCreate");
        setContentView(R.layout.activity_user_list);

        list = findViewById(R.id.user_list);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(UserListActivity.this, "Position " + i, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(UserListActivity.this, UserActivity.class);
                intent.putExtra(ITEM_ID, ((User)list.getAdapter().getItem(i)).getId());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("===================================", "onResume");

        UserViewModel vm = ViewModelProviders.of(this).get(UserViewModel.class);

        LiveData<List<User>> observer = vm.get();
        observer.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

                UserAdapter adapter = new UserAdapter(UserListActivity.this, R.layout.style_user_list, users);
                list.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("===================================", "onDestroy");
    }
}