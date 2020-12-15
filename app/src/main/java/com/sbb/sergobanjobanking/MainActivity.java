package com.sbb.sergobanjobanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    public void onLoginButtonClick(View view)
    {
        switch (view.getId())
        {
            case R.id.loginButton:
            {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            } break;
        }

    }

}