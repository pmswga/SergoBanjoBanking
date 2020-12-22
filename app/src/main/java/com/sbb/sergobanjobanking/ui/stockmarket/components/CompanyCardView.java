package com.sbb.sergobanjobanking.ui.stockmarket.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sbb.sergobanjobanking.database.entities.CompanyModel;

@SuppressLint("ViewConstructor")
public class CompanyCardView extends CardView {
    TextView companyNameView;
    TextView companyDescriptionView;

    ConstraintLayout constraintLayout;
    LinearLayout layout;

    public CompanyCardView(@NonNull Context context, CompanyModel companyModel) {
        super(context);
        layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        this.addView(layout);



        companyNameView = new TextView(this.getContext());
        companyNameView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        companyNameView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        companyNameView.setText(companyModel.caption);


        companyDescriptionView = new TextView(this.getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(30, 30, 30, 30);
        companyDescriptionView.setLayoutParams(lp);
        companyDescriptionView.setText(companyModel.description);


        layout.addView(this.companyNameView);
        layout.addView(this.companyDescriptionView);
    }

}
