package com.sbb.sergobanjobanking.ui.notifications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sbb.sergobanjobanking.HomeActivity;
import com.sbb.sergobanjobanking.MainActivity;
import com.sbb.sergobanjobanking.R;
import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.ProfileModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

import java.io.Console;
import java.net.Inet4Address;
import java.util.Objects;

public class NotificationsFragment extends Fragment {

    AppDatabase db;
    UserModel loggedUser;

    View root;

    Button logoutButton;

    EditText profileSecondNameInput, profileFirstNameInput, profilePatronymicInput;
    EditText profileEmailInput;
    EditText profilePassportInput;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_notifications, container, false);

        db = DatabaseApp.getInstance().getDatabase();

        loggedUser = db.userDao().getLoggedUser();

        profileSecondNameInput = (EditText) root.findViewById(R.id.profileSecondName);
        profileSecondNameInput.setEnabled(false);

        profileFirstNameInput = (EditText) root.findViewById(R.id.profileFirstName);
        profileFirstNameInput.setEnabled(false);

        profilePatronymicInput = (EditText) root.findViewById(R.id.profilePatronymic);
        profilePatronymicInput.setEnabled(false);

        profileEmailInput = (EditText) root.findViewById(R.id.profileEmail);
        profileEmailInput.setEnabled(false);

        profilePassportInput = (EditText) root.findViewById(R.id.profilePassport);
        profilePassportInput.setEnabled(false);


        logoutButton = (Button) root.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                Toast.makeText(getActivity(), "You are logout", Toast.LENGTH_LONG).show();

                if (loggedUser != null) {
                    loggedUser.isLogged = 0;
                    db.userDao().update(loggedUser);
                }

                startActivity(i);
                getActivity().finish();
            }
        });

        if (loggedUser != null) {
            ProfileModel profileModel = db.userDao().getProfile(loggedUser.email);
            profileEmailInput.setText(loggedUser.email);

            if (profileModel != null) {
                profileSecondNameInput.setText(profileModel.secondName);
                profileFirstNameInput.setText(profileModel.firstName);
                profilePatronymicInput.setText(profileModel.patronymic);
                profilePassportInput.setText(profileModel.passport);
            }
        }

        return root;
    }

}