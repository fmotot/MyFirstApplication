package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.RepoFactory;
import com.example.myfirstapplication.view_model.UserViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG";

    /**
     * First called function in activity's lifecycle
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        // Load HMI
        setContentView(R.layout.activity_main);

        IUserRepository repo = RepoFactory.getUserRepository(this);

//        repo.insert(new User(0, "Kilo", "Sandy"));

        UserViewModel uvm = ViewModelProviders.of(this).get(UserViewModel.class);

        LiveData<List<User>> observer = repo.get();
        observer.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user : users) {
                    Log.d(TAG, user.toString());
                }
            }
        });
    }
}