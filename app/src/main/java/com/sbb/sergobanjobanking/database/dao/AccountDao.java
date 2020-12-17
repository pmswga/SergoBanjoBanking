package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sbb.sergobanjobanking.database.entities.AccountModel;

@Dao
public interface AccountDao {

    @Query("SELECT * FROM accounts WHERE idUser=:idUser")
    AccountModel getAccount(long idUser);

    @Insert
    void insert(AccountModel accountModel);

}
