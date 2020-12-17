package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.sbb.sergobanjobanking.database.entities.ProfileModel;

import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profile")
    List<ProfileModel> getAll();

    @Transaction
    @Insert
    void insert(ProfileModel profileModel);

}
