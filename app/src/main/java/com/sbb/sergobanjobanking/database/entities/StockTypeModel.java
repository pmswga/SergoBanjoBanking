package com.sbb.sergobanjobanking.database.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stock_type")
public class StockTypeModel {
    @PrimaryKey(autoGenerate = true)
    public long idStockType;

    @ColumnInfo(name = "caption")
    public String caption;
}
