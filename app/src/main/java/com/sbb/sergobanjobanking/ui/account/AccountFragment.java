package com.sbb.sergobanjobanking.ui.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.AccountStockModel;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;
import com.sbb.sergobanjobanking.ui.account.components.CompanyStockView;

public class AccountFragment extends Fragment {

    AppDatabase db;
    UserModel loggedUser;
    AccountModel accountModel;
    AccountStockModel accountStockModel[];

    TextView accountBalanceLabel;
    LinearLayout companiesStockLayout;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        db = DatabaseApp.getInstance().getDatabase();

        accountBalanceLabel = (TextView) root.findViewById(R.id.accountBalanceLabel);
        companiesStockLayout = (LinearLayout) root.findViewById(R.id.companiesStockLayout);

        loggedUser = db.userDao().getLoggedUser();

        accountModel = db.accountDao().getAccount(loggedUser.idUser);

        if (accountModel != null) {
            accountBalanceLabel.setText(Double.toString(accountModel.balance));
        }

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        companiesStockLayout.removeAllViews();

        if (accountModel != null) {
            accountBalanceLabel.setText(Double.toString(accountModel.balance));
        }

        accountStockModel = db.accountStockDao().getAccountStocks(accountModel.idAccount);

        if (accountStockModel != null) {
            for (AccountStockModel accountStock : accountStockModel) {
                CompanyModel companyModel = db.stockDao().getCompany(accountStock.idStock);
                if (companyModel != null) {
                    CompanyStockView companyStockView = new CompanyStockView(companiesStockLayout.getContext(), companyModel, accountStock);

                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(30, 30, 30, 30);
                    companyStockView.setLayoutParams(lp);

                    companiesStockLayout.addView(companyStockView);
                }
            }
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }

}