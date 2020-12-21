package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "company_stock")
public class CompanyStockModel {
    @PrimaryKey
    public long idCompanyStock;

    @ColumnInfo(name = "idStockType")
    public long idStockType;

    @ColumnInfo(name = "price")
    public long price;

    @ColumnInfo(name = "count")
    public long count;
}
