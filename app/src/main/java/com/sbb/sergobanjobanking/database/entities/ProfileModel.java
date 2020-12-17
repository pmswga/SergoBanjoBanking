package com.sbb.sergobanjobanking.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile")
public class ProfileModel {
    @PrimaryKey
    public long idProfile;

    @ColumnInfo(name = "secondName")
    public String secondName;

    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "patronymic")
    public String patronymic;

    @ColumnInfo(name = "passport")
    public String passport;
}
