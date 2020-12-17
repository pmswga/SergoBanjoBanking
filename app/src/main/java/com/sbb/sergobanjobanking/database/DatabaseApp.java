package com.sbb.sergobanjobanking.database;

import android.app.Application;

import androidx.room.Room;

public class DatabaseApp extends Application {

    public static DatabaseApp instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "sbb_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    public static DatabaseApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }



}
