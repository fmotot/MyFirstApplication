package com.example.myfirstapplication.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.dal.AppDatabase;
import com.example.myfirstapplication.dal.UserDAO;

import java.util.List;

public class UserDBRepository implements IUserRepository {

    private UserDAO userDAO;

    public UserDBRepository(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        userDAO = db.getUserDAO();
    }

    @Override
    public void insert(User user) {
        new AsyncTask<User,Void,Void>(){

            @Override
            protected Void doInBackground(User... users) {
                userDAO.insert(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public LiveData<List<User>> get() {

        return userDAO.get();
    }

    @Override
    public LiveData<User> get(int id) {
        return userDAO.get(id);
    }

    @Override
    public void update(User user) {
        new AsyncTask<User,Void,Void>(){

            @Override
            protected Void doInBackground(User... users) {
                userDAO.update(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete(User user) {
        new AsyncTask<User,Void,Void>(){

            @Override
            protected Void doInBackground(User... users) {
                userDAO.delete(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete() {
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                userDAO.delete();
                return null;
            }
        }.execute();
    }
}
