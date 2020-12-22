package com.sbb.sergobanjobanking.database;

import android.app.Application;

import androidx.room.Room;

import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.database.entities.StockModel;
import com.sbb.sergobanjobanking.database.entities.StockTypeModel;

public class DatabaseApp extends Application {

    public static DatabaseApp instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "sbb_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        migrateCompanies();
        migrateStockTypes();
        migrateStocks();
    }

    private void migrateStockTypes()
    {
        String[] stockTypes = {"Обычная", "Привилегированная"};

        if (database.stockTypeDao().getCount() == 0) {
            for (int i = 0; i < stockTypes.length; i++) {
                StockTypeModel stockTypeModel = new StockTypeModel();
                stockTypeModel.caption = stockTypes[i];

                database.stockTypeDao().insert(stockTypeModel);
            }
        }

    }

    private void migrateCompanies()
    {
        String[][] compines = {
                {"Сбербанк", "Российский финансовый конгломерат, крупнейший транснациональный и универсальный банк Российской Федерации — России, Центральной и Восточной Европы. По итогам 2019 года у «Сбербанка» 96,2 млн активных частных клиентов и 2,6 млн активных корпоративных клиентов"},
                {"ВТБ", "Российский универсальный коммерческий банк c государственным участием. Банк ВТБ является головной структурой Группы ВТБ. Финансовый конгломерат. 60,9 % обыкновенных акций банка принадлежит государству, остальные 39 % находятся в свободном обращении; с учётом привилегированных акций под государственным контролем находится 92 % акционерного капитала группы. Второй по величине активов банк России и первый по размеру уставного капитала"},
                {"Тинькофф", "Российский коммерческий банк, сфокусированный полностью на дистанционном обслуживании, не имеющий розничных отделений"},
                {"Альфа-банк", "Крупнейший частный банк в России, входящий в пятёрку крупнейших банков России по объёму активов по данным рейтингов РБК и Forbes"},
                {"Открытие", "Российский универсальный коммерческий банк. Банк был сформирован в результате интеграции более чем 10 банков различного масштаба, в том числе «Номос-банка», Ханты-Мансийского банка, банка «Петрокоммерц» и других"},
                {"Московский индустриальный банк", "Советский и российский банк. Головной офис расположен в Москве. Один из 30 крупнейших банков России по версии Банка России. Входит в Реестр кредитных организаций, признанных Центробанком России значимыми на рынке платёжных услуг"},
                {"Яндекс", "оссийская транснациональная компания в отрасли информационных технологий, зарегистрированная в Нидерландах и владеющая одноимённой системой поиска в Сети, интернет-порталами и службами в нескольких странах."}
        };


        if (database.companyDao().getCount() == 0) {
            for (int i = 0; i < compines.length; i++) {
                CompanyModel companyModel = new CompanyModel();
                companyModel.caption = compines[i][0];
                companyModel.description = compines[i][1];

                database.companyDao().insert(companyModel);
            }
        }
    }

    private void migrateStocks()
    {
        String[][] stocks = {
                {"1", "1", "260", "1000000"},
                {"2", "1", "0.03752", "100000"},
                {"3", "1", "2392.20", "100000"},
                {"4", "1", "800", "100000"},
                {"5", "1", "981.40", "100000"},
                {"6", "1", "150", "100000"},
                {"7", "1", "5087", "100000"}
        };

        if (database.stockDao().getCount() == 0) {
            for (int i = 0; i < stocks.length; i++) {
                StockModel stockModel = new StockModel();
                stockModel.idCompany = Integer.parseInt(stocks[i][0]);
                stockModel.idStockType = Integer.parseInt(stocks[i][1]);
                stockModel.price = Double.parseDouble(stocks[i][2]);
                stockModel.limit = Integer.parseInt(stocks[i][3]);

                database.stockDao().insert(stockModel);
            }
        }
    }

    public static DatabaseApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }



}
