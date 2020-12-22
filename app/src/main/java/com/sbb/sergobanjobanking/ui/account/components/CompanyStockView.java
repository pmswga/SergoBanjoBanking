package com.sbb.sergobanjobanking.ui.account.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.database.dao.AccountStockDao;
import com.sbb.sergobanjobanking.database.entities.AccountStockModel;
import com.sbb.sergobanjobanking.database.entities.CompanyModel;

import org.w3c.dom.Text;

public class CompanyStockView extends CardView {
    LinearLayout linearLayout;

    TextView companyNameLabel;
    //DividerItemDecoration horizontalDivider1;

    TextView buyPriceLabel;
    EditText buyPriceInput;

    TextView stockCountLabel;
    EditText stockCountInput;
    //DividerItemDecoration horizontalDivider2;

    TextView stockSumLabel;
    EditText stockSumInput;


    @SuppressLint("SetTextI18n")
    public CompanyStockView(@NonNull Context context, CompanyModel companyModel, AccountStockModel accountStockModel) {
        super(context);
        linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        this.addView(linearLayout);

        LinearLayout.LayoutParams labelLP =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        labelLP.setMargins(15, 10, 10, 10);

        companyNameLabel = new TextView(getContext());
        companyNameLabel.setText(companyModel.caption);
        companyNameLabel.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        companyNameLabel.setLayoutParams(labelLP);

        buyPriceLabel = new TextView(getContext());
        buyPriceLabel.setText(getResources().getString(R.string.buy_price_label));
        buyPriceLabel.setLayoutParams(labelLP);

        buyPriceInput = new EditText(getContext());
        buyPriceInput.setEnabled(false);
        buyPriceInput.setText(Double.toString(accountStockModel.price));

        stockCountLabel = new TextView(getContext());
        stockCountLabel.setText(getResources().getString(R.string.count_text));
        stockCountLabel.setLayoutParams(labelLP);

        stockCountInput = new EditText(getContext());
        stockCountInput.setEnabled(false);
        stockCountInput.setText(Double.toString(accountStockModel.count));

        stockSumLabel = new TextView(getContext());
        stockSumLabel.setText(getResources().getString(R.string.sum_stock_label));
        stockSumLabel.setLayoutParams(labelLP);

        stockSumInput = new EditText(getContext());
        stockSumInput.setEnabled(false);
        stockSumInput.setText(Double.toString(accountStockModel.count * accountStockModel.price));


        linearLayout.addView(companyNameLabel);
        linearLayout.addView(buyPriceLabel);
        linearLayout.addView(buyPriceInput);
        linearLayout.addView(stockCountLabel);
        linearLayout.addView(stockCountInput);
        linearLayout.addView(stockSumLabel);
        linearLayout.addView(stockSumInput);
    }
}
