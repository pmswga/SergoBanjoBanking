package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sbb.sergobanjobanking.database.entities.AccountStockModel;

@Dao
public interface AccountStockDao {

    @Query("SELECT * FROM account_stocks WHERE idAccount=:idAccount")
    AccountStockModel[] getAccountStocks(long idAccount);

    @Insert
    void insert(AccountStockModel accountStockModel);

}
