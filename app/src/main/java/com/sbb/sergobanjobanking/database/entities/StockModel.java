package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stocks")
public class StockModel {
    @PrimaryKey(autoGenerate = true)
    public long idStock;

    @ColumnInfo(name ="idCompany")
    public long idCompany;

    @ColumnInfo(name = "idStockType")
    public long idStockType;

    @ColumnInfo(name ="price")
    public double price;

    @ColumnInfo(name = "limit")
    public long limit;
}
