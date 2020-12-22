package com.sbb.sergobanjobanking.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sbb.sergobanjobanking.database.dao.AccountDao;
import com.sbb.sergobanjobanking.database.dao.AccountStockDao;
import com.sbb.sergobanjobanking.database.dao.CompanyDao;
import com.sbb.sergobanjobanking.database.dao.ProfileDao;
import com.sbb.sergobanjobanking.database.dao.StockDao;
import com.sbb.sergobanjobanking.database.dao.StockTypeDao;
import com.sbb.sergobanjobanking.database.dao.UserDao;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.AccountStockModel;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.database.entities.ProfileModel;
import com.sbb.sergobanjobanking.database.entities.StockModel;
import com.sbb.sergobanjobanking.database.entities.StockTypeModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

@Database(entities = {
        UserModel.class,
        ProfileModel.class,
        AccountModel.class,
        AccountStockModel.class,
        CompanyModel.class,
        StockModel.class,
        StockTypeModel.class
},
        version = 10)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract ProfileDao profileDao();
    public abstract AccountDao accountDao();
    public abstract AccountStockDao accountStockDao();
    public abstract CompanyDao companyDao();
    public abstract StockDao stockDao();
    public abstract StockTypeDao stockTypeDao();
}
