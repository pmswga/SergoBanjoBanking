package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "companies")
public class CompanyModel {
    @PrimaryKey(autoGenerate = true)
    public long idCompany;

    @ColumnInfo(name = "caption")
    public String caption;

    @ColumnInfo(name = "description")
    public String description;
}
