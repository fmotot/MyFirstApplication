package com.example.myfirstapplication.repository;
import android.content.Context;

public class RepoFactory {

    public static IUserRepository getUserRepository(Context context){
        return new UserDBRepository(context);
    }
}
