package com.sbb.sergobanjobanking.ui.stockmarket;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sbb.sergobanjobanking.BuyStockActivity;
import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;
import com.sbb.sergobanjobanking.ui.stockmarket.components.CompanyCardView;

import java.util.ArrayList;

public class StockMarketFragment extends Fragment {
    AppDatabase db;

    LinearLayout companiesList;
    ArrayList<CompanyCardView> companyCardViews;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stock_market, container, false);

        db = DatabaseApp.getInstance().getDatabase();

        companiesList = (LinearLayout) root.findViewById(R.id.companiesLayout);

        companyCardViews = new ArrayList<CompanyCardView>();
        CompanyModel[] companies = db.companyDao().getAll();


        for (CompanyModel companyModel : companies) {
            CompanyCardView companyCardView = new CompanyCardView(companiesList.getContext(), companyModel);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(30, 30, 30, 30);
            companyCardView.setLayoutParams(lp);

            companyCardViews.add(companyCardView);
            companiesList.addView(companyCardView);

            companyCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), BuyStockActivity.class);

                    i.putExtra("idCompany", companyModel.idCompany);

                    startActivity(i);
                }
            });
        }

        return root;
    }
}