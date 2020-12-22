package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "account_stocks")
public class AccountStockModel {
    @PrimaryKey(autoGenerate = true)
    public long idAccountStock;

    @ColumnInfo(name = "idAccount")
    public long idAccount;

    @ColumnInfo(name = "idStock")
    public long idStock;

    @ColumnInfo(name = "count")
    public long count;

    @ColumnInfo(name = "price")
    public double price;
}
