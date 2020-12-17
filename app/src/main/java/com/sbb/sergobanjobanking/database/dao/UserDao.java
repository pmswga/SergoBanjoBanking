package com.sbb.sergobanjobanking.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.sbb.sergobanjobanking.database.entities.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<UserModel> getAll();

    @Query("SELECT * FROM users WHERE idUser=:idUser")
    UserModel getUser(int idUser);

    @Query("SELECT * FROM users WHERE email=:email")
    UserModel getUserByEmail(String email);

    @Insert
    void insertAll(UserModel... users);

    @Delete
    void delete(UserModel user);
}
