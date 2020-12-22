package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.database.entities.StockModel;

@Dao
public interface StockDao {

    @Query("SELECT COUNT(*) FROM stocks")
    int getCount();

    @Query("SELECT * FROM stocks WHERE idCompany=:idCompany and idStockType=:idStockType")
    StockModel getStock(long idCompany, long idStockType);

    @Query("SELECT c.idCompany, c.caption, c.description FROM stocks as s " +
            "INNER JOIN companies as c ON s.idCompany=c.idCompany " +
            "WHERE s.idStock=:idStock")
    CompanyModel getCompany(long idStock);

    @Insert
    void insert(StockModel stockModel);

}
