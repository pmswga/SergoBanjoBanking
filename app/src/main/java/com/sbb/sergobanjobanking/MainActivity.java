package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton, toRegistrationButton;

    EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        toRegistrationButton = (Button) findViewById(R.id.toRegistrationButton);

        emailInput = (EditText) findViewById(R.id.emailLoginInput);
        passwordInput = (EditText) findViewById(R.id.passwordLoginInput);

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

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.loginButton:
            {
                Intent i = new Intent(this, HomeActivity.class);

                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.equals("pmswga@gmail.com") && password.equals("qwerty")) {

                    emailInput.setHintTextColor(Color.BLACK);
                    passwordInput.setHintTextColor(Color.BLACK);
                    startActivity(i);
                    this.finish();
                } else {
                    emailInput.setHintTextColor(Color.rgb(173, 0, 0));
                    passwordInput.setHintTextColor(Color.rgb(173, 0, 0));
                    Toast.makeText(this, "Incorrect email & login", Toast.LENGTH_LONG).show();
                }

                //check login & pass

            } break;
            case R.id.toRegistrationButton:
            {
                Intent i = new Intent(this, RegistrationActivity.class);

                String email = emailInput.getText().toString();
                if (!email.isEmpty()) {
                    i.putExtra("email", email);
                }

                String password = passwordInput.getText().toString();
                if (!password.isEmpty()) {
                    i.putExtra("password", password);
                }

                startActivity(i);
            } break;
        }

    }

}