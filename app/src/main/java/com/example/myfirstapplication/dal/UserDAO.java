package com.example.myfirstapplication.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myfirstapplication.bo.User;

import java.util.List;

/**
 * Class giving instruction to Room which will create the dao for user table
 */
@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Insert
    void insert(User ... users);

    @Query("SELECT * FROM User")
    LiveData<List<User>> get();

    @Query("SELECT * FROM User WHERE id = :id")
    User get(int id);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM User")
    void delete();
}
