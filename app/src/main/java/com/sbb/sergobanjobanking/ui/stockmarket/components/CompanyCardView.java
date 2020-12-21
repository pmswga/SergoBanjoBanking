package com.sbb.sergobanjobanking.ui.dashboard.components;

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

    public CompanyCardView(@NonNull Context context, CompanyModel companyModel) {
        super(context);
        constraintLayout = new ConstraintLayout(this.getContext());
        this.addView(constraintLayout);



        companyNameView = new TextView(this.getContext());
        companyNameView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        companyNameView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        companyNameView.setText(companyModel.caption);

        companyDescriptionView = new TextView(this.getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, companyNameView.getHeight(), 0, 0);
        companyDescriptionView.setLayoutParams(lp);
        companyDescriptionView.setText(companyModel.description);


        constraintLayout.addView(this.companyNameView, this.getWidth());
        constraintLayout.addView(this.companyDescriptionView, this.getWidth());
    }

}
