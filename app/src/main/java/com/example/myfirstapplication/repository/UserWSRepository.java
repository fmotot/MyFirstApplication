package com.example.myfirstapplication.repository;

import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;

import java.util.List;

public class UserWSRepository implements IUserRepository {
    @Override
    public void insert(User user) {

    }

    @Override
    public LiveData<List<User>> get() {
        return null;
    }

    @Override
    public LiveData<User> get(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete() {

    }
}
