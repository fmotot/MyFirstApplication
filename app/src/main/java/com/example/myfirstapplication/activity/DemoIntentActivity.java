package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;

public class DemoIntentActivity extends AppCompatActivity {

    public static final String KEY_WOLOLO = "wololo";
    public static final String KEY_WALALA = "walala";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent);
    }

    public void onClickMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickUserInsert(View view) {
        Intent intent = new Intent(this, InsertUserActivity.class);
        intent.putExtra(KEY_WOLOLO, 14540);
        intent.putExtra(KEY_WALALA, "Soliers");

        User user = new User(0, "Tare", "Gui" );

        intent.putExtra("user", user);
        startActivity(intent);
    }

    public void onClickUserList(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }
}