package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public long idUser;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "isLogged")
    public int isLogged;
}
