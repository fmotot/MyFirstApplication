package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.RepoFactory;

public class InsertUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        int i = intent.getIntExtra(DemoIntentActivity.KEY_WOLOLO, 0);
        String j = intent.getStringExtra(DemoIntentActivity.KEY_WALALA);

        User user = intent.getParcelableExtra("user");

        EditText etFirstName = findViewById(R.id.et_firstname);
        etFirstName.setText(j);

        Toast.makeText(this, i + " " + j, Toast.LENGTH_LONG).show();
    }

    public void onClickSave(View view) {
        IUserRepository repo = RepoFactory.getUserRepository(this);

        EditText etFirstName = findViewById(R.id.et_firstname);
        EditText etLastName = findViewById(R.id.et_lastname);

        String textFirstName = etFirstName.getText().toString();

        Toast.makeText(this, "Utilisateur " + textFirstName + " créé!", Toast.LENGTH_LONG).show();

        repo.insert(new User(0, etLastName.getText().toString(), etFirstName.getText().toString()));
    }
}