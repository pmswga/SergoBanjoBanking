package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.AccountStockModel;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.database.entities.StockModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

public class BuyStockActivity extends AppCompatActivity {
    AppDatabase db;

    TextView companyNameBuyStocksLabel;
    EditText priceInput, limitInput;

    Button buyStockButton;

    UserModel loggedUser;
    CompanyModel companyModel;
    StockModel stockModel;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_stock);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.buy_activity_title);

        companyNameBuyStocksLabel = (TextView) findViewById(R.id.companyNameBuyStocksLabel);
        priceInput = (EditText) findViewById(R.id.stockPriceInput);
        priceInput.setEnabled(false);
        limitInput = (EditText) findViewById(R.id.stockCountInput);

        buyStockButton = (Button) findViewById(R.id.buyStockButton);

        db = DatabaseApp.getInstance().getDatabase();

        loggedUser = db.userDao().getLoggedUser();

        // add check is user logged


        long idCompany = 0;
        idCompany = getIntent().getLongExtra("idCompany", 0);

        if (idCompany != 0) {
            companyModel = db.companyDao().getCompany(idCompany);
        }

        if (companyModel != null) {
            companyNameBuyStocksLabel.setText(companyModel.caption);

            stockModel = db.stockDao().getStock(companyModel.idCompany, 1);

            if (stockModel != null) {
                priceInput.setText(Double.toString(stockModel.price));
            }
        }


        buyStockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = Integer.parseInt(limitInput.getText().toString());

                if (count <= stockModel.limit) {
                    AccountModel accountModel = db.accountDao().getAccount(loggedUser.idUser);

                    if (accountModel != null) {
                        AccountStockModel accountStockModel = new AccountStockModel();
                        accountStockModel.idAccount = accountModel.idAccount;
                        accountStockModel.idStock = stockModel.idStock;
                        accountStockModel.price = stockModel.price;
                        accountStockModel.count = count;

                        db.accountStockDao().insert(accountStockModel);

                        accountModel.balance += stockModel.price * count;
                        db.accountDao().update(accountModel);

                        Toast.makeText(v.getContext(), getResources().getString(R.string.buy_stock_success_message), Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else {
                    Toast.makeText(v.getContext(), getResources().getString(R.string.buy_stock_warning_message), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(v.getContext(), getResources().getString(R.string.buy_stock_fail_message), Toast.LENGTH_LONG).show();
            }
        });

    }
}