package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.sbb.sergobanjobanking.database.entities.StockTypeModel;

@Dao
public interface StockTypeDao {

    @Query("SELECT COUNT(*) FROM stock_type")
    int getCount();

    @Insert
    void insert(StockTypeModel stockTypeModel);

}
