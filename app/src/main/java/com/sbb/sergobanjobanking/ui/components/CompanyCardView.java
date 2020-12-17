package com.sbb.sergobanjobanking.ui.components;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

public class CompanyCardView extends CardView {

    TextView companyNameView;

    public CompanyCardView(@NonNull Context context, String companyName) {
        super(context);

        companyNameView = new TextView(this.getContext());
        companyNameView.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        companyNameView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        companyNameView.setText(companyName);


        this.addView(this.companyNameView, this.getWidth());
    }
}
