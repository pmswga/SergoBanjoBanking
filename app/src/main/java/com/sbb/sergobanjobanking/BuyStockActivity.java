package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;

public class BuyStockActivity extends AppCompatActivity {
    AppDatabase db;

    TextView companyNameBuyStocksLabel;

    CompanyModel companyModel;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_stock);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.buy_activity_title);

        companyNameBuyStocksLabel = (TextView) findViewById(R.id.companyNameBuyStocksLabel);

        db = DatabaseApp.getInstance().getDatabase();

        // add check is user logged


        long idCompany = 0;
        idCompany = getIntent().getLongExtra("idCompany", 0);

        if (idCompany != 0) {
            companyModel = db.companyDao().getCompany(idCompany);
        }

        if (companyModel != null) {
            companyNameBuyStocksLabel.setText(companyModel.caption);
        }

    }
}