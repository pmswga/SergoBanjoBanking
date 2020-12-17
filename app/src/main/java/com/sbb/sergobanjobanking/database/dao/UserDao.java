package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.sbb.sergobanjobanking.database.entities.ProfileModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE isLogged=1 LIMIT 1")
    UserModel getLoggedUser();

    @Query("SELECT * FROM users")
    List<UserModel> getAll();

    @Query("SELECT * FROM users WHERE idUser=:idUser")
    UserModel getUser(int idUser);

    @Query("SELECT * FROM users WHERE email=:email")
    UserModel getUserByEmail(String email);


    @Query("SELECT * FROM users WHERE email=:email and password=:password")
    UserModel attemptUser(String email, String password);


    @Query("SELECT profile.idProfile, profile.secondName, profile.firstName, profile.patronymic, profile.passport  FROM users " +
            "INNER JOIN profile ON users.idUser=profile.idProfile " +
            "WHERE users.email = :email")
    ProfileModel getProfile(String email);

    @Transaction
    @Insert
    long insert(UserModel userModel);

    @Update
    void update(UserModel userModel);

    @Delete
    void delete(UserModel userModel);

}
