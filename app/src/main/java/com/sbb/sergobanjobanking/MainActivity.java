package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.sbb.sergobanjobanking.database.AppDatabase;
import com.sbb.sergobanjobanking.database.DatabaseApp;
import com.sbb.sergobanjobanking.database.entities.UserModel;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    Button loginButton, toRegistrationButton;

    EditText emailInput, passwordInput;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseApp.getInstance().getDatabase();
        //db.clearAllTables();

        loginButton = (Button) findViewById(R.id.loginButton);
        toRegistrationButton = (Button) findViewById(R.id.toRegistrationButton);

        emailInput = (EditText) findViewById(R.id.emailLoginInput);
        passwordInput = (EditText) findViewById(R.id.passwordLoginInput);

        UserModel loggedUser = db.userDao().getLoggedUser();

        if (loggedUser != null) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            this.finish();
        }


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

                UserModel loginUser = db.userDao().attemptUser(email, password);

                if (loginUser != null) {
                    Toast.makeText(this, getResources().getString(R.string.login_success_message), Toast.LENGTH_LONG).show();
                    emailInput.setHintTextColor(Color.BLACK);
                    passwordInput.setHintTextColor(Color.BLACK);

                    loginUser.isLogged = 1;
                    db.userDao().update(loginUser);

                    startActivity(i);
                    this.finish();
                } else {
                    emailInput.setHintTextColor(Color.rgb(173, 0, 0));
                    passwordInput.setHintTextColor(Color.rgb(173, 0, 0));
                    Toast.makeText(this, getResources().getString(R.string.login_warning_message), Toast.LENGTH_LONG).show();
                }
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