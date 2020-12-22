package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.AccountModel;
import com.sbb.sergobanjobanking.database.entities.ProfileModel;
import com.sbb.sergobanjobanking.database.entities.UserModel;

public class RegistrationActivity extends AppCompatActivity {
    Button registrationButton;

    EditText secondNameInput, firstNameInput, patronymicInput;
    EditText passportNumberInput, passportSeriesInput;
    EditText emailInput, passwordInput;

    private void setIntentData() {
        String email = getIntent().getStringExtra("email");
        if (email != null) {
            if (!email.isEmpty()) {
                emailInput.setText(email);
            }
        }

        String password = getIntent().getStringExtra("password");
        if (password != null) {
            if (!password.isEmpty()) {
                passwordInput.setText(password);
            }
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registrationButton = (Button) findViewById(R.id.registrationButton);

        secondNameInput = (EditText) findViewById(R.id.secondNameInput);
        firstNameInput = (EditText) findViewById(R.id.firstNameInput);
        patronymicInput = (EditText) findViewById(R.id.patronymicInput);

        passportNumberInput = (EditText) findViewById(R.id.passportNumberInput);
        passportSeriesInput = (EditText) findViewById(R.id.passportSeriesInput);

        emailInput = (EditText) findViewById(R.id.emailRegInput);
        passwordInput = (EditText) findViewById(R.id.passwordRegInput);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.registration_activity_title);

        setIntentData();

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = DatabaseApp.getInstance().getDatabase();

                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                String secondName = secondNameInput.getText().toString();
                String firstName = firstNameInput.getText().toString();
                String patronymic = patronymicInput.getText().toString();
                String passportNumber = passportNumberInput.getText().toString();
                String passportSeries = passportSeriesInput.getText().toString();

                if (!secondName.isEmpty() &&
                        !firstName.isEmpty() &&
                        !email.isEmpty() &&
                        !password.isEmpty() &&
                        !passportNumber.isEmpty() &&
                        !passportSeries.isEmpty())
                {
                    UserModel newUser = new UserModel();
                    newUser.email = email;
                    newUser.password = password;

                    ProfileModel newProfile = new ProfileModel();

                    newProfile.secondName = secondName;
                    newProfile.firstName = firstName;
                    newProfile.patronymic = patronymic;
                    newProfile.passport = passportNumber + " " + passportSeries;

                    AccountModel newAccount = new AccountModel();

                    try
                    {
                        long idUser = db.userDao().insert(newUser);

                        if (idUser != -1) {
                            newProfile.idProfile = idUser;
                            db.profileDao().insert(newProfile);

                            newAccount.idUser = idUser;
                            db.accountDao().insert(newAccount);

                            Toast.makeText(v.getContext(), getResources().getString(R.string.registration_success_message), Toast.LENGTH_LONG).show();

                            finish();
                        }
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(v.getContext(), getResources().getString(R.string.registration_fail_message), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(v.getContext(), getResources().getString(R.string.registration_warning_message), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}