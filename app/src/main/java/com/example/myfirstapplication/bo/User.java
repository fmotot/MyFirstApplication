package com.example.myfirstapplication.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

/**
 * Class application user
 */
@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String lastName;
    private String firstName;

    public User(int id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
