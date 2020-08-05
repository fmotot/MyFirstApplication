package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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


        UserViewModel uvm = ViewModelProviders.of(this).get(UserViewModel.class);

        Log.i(TAG, "========================================================================================================");
        Log.i(TAG, "Test en cours");

        LiveData<List<User>> observer = repo.get();
        observer.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User user : users) {
                    Log.i(TAG, user.toString());
                }
            }
        });

        repo.insert(new User(0, "Kilo", "Sandy"));
        SystemClock.sleep(5000);
        repo.insert(new User(0, "Second", "Milly"));
    }

    public void onClickLoad(View view) {
        SharedPreferences sp = getSharedPreferences("preferences", MODE_PRIVATE);

        int nb = sp.getInt("nb", 666);
        String key = sp.getString("key", "vide");

        Toast.makeText(this, "nb :" + nb + ", key : " + key, Toast.LENGTH_SHORT).show();

    }

    public void onClickSave(View view) {
        SharedPreferences sp = getSharedPreferences("preferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("key", "value");
        editor.putInt("nb", 42);

        editor.commit();
    }
}