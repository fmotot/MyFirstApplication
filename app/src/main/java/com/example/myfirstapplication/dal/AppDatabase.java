package com.example.myfirstapplication.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myfirstapplication.bo.User;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    /**
     * get an userDAO instance for upper layers
     * @return UserDAO
     */
    public abstract UserDAO getUserDAO();

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "myFirstApp.db").build();
        }

        return INSTANCE;
    }


}
