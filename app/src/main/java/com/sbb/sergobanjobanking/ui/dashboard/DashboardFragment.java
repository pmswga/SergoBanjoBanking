package com.sbb.sergobanjobanking.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.components.CompanyCardView;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    LinearLayout companiesList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        companiesList = (LinearLayout) root.findViewById(R.id.companiesLayout);


        for (int i = 0; i < 10; i++) {

            CompanyCardView companyCardView = new CompanyCardView(companiesList.getContext(), "Sber");

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 137);
            lp.setMargins(30, 30, 30, 30);
            companyCardView.setLayoutParams(lp);


            companiesList.addView(companyCardView);
        }



        return root;
    }
}