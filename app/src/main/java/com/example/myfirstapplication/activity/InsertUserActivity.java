package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.RepoFactory;

public class InsertUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);
    }

    public void onClickSave(View view) {
        IUserRepository repo = RepoFactory.getUserRepository(this);

        EditText etFirstName = findViewById(R.id.et_firstname);
        EditText etLastName = findViewById(R.id.et_lastname);

        String textFirstName = etFirstName.getText().toString();

        Toast.makeText(this, "Nom : " + textFirstName, Toast.LENGTH_LONG).show();
    }
}