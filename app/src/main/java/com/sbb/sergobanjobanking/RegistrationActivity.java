package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    Button backLoginButton, registrationButton;

    EditText secondNameInput, firstNameInput, patronymicInput;
    EditText passportNumber, passportSeries;
    EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        backLoginButton = (Button) findViewById(R.id.backLoginButton);
        registrationButton = (Button) findViewById(R.id.registrationButton);

        secondNameInput = (EditText) findViewById(R.id.secondNameInput);
        firstNameInput = (EditText) findViewById(R.id.firstNameInput);
        patronymicInput = (EditText) findViewById(R.id.patronymicInput);

        passportNumber = (EditText) findViewById(R.id.passportNumberInput);
        passportSeries = (EditText) findViewById(R.id.passportSeriesInput);

        emailInput = (EditText) findViewById(R.id.emailRegInput);
        passwordInput = (EditText) findViewById(R.id.passwordRegInput);


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


        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You are registered", Toast.LENGTH_LONG).show();
            }
        });

        backLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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