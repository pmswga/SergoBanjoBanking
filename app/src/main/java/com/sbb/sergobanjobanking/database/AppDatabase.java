package com.sbb.sergobanjobanking.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sbb.sergobanjobanking.database.dao.AccountDao;
import com.sbb.sergobanjobanking.database.dao.AccountStockDao;
import com.sbb.sergobanjobanking.database.dao.ProfileDao;
import com.sbb.sergobanjobanking.database.dao.UserDao;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.AccountStockModel;
import com.sbb.sergobanjobanking.database.entities.ProfileModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

@Database(entities = {UserModel.class, ProfileModel.class, AccountModel.class, AccountStockModel.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ProfileDao profileDao();
    public abstract AccountDao accountDao();
    public abstract AccountStockDao accountStockDao();
}
