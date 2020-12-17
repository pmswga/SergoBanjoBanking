package com.sbb.sergobanjobanking.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    AppDatabase db;
    UserModel loggedUser;
    AccountModel accountModel;

    TextView accountBalanceLabel;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        db = DatabaseApp.getInstance().getDatabase();

        accountBalanceLabel = (TextView) root.findViewById(R.id.accountBalanceLabel);



        loggedUser = db.userDao().getLoggedUser();

        accountModel = db.accountDao().getAccount(loggedUser.idUser);

        if (accountModel != null) {
            accountBalanceLabel.setText(Double.toString(accountModel.balance));
        }

        return root;
    }
}