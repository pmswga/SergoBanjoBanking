package com.sbb.sergobanjobanking.database.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class AccountModel {
    @PrimaryKey(autoGenerate = true)
    public long idAccount;

    @ColumnInfo(name = "idUser")
    public long idUser;

    @ColumnInfo(name = "balance")
    public double balance;
}
