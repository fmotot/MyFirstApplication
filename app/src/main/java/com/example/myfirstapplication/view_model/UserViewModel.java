package com.example.myfirstapplication.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.RepoFactory;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    IUserRepository repo;

    /**
     * we get only one observer for all the activities
     */
    private LiveData<List<User>> observer = null;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repo = RepoFactory.getUserRepository(application);
        observer = repo.get();
    }

    public LiveData<List<User>> get(){
        return observer;
    }
}
