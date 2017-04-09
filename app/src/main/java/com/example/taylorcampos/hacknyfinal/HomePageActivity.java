package com.example.taylorcampos.hacknyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void wantClick(View view){
        Intent intent = new Intent(this, CompanyMainActivity.class);
        startActivity(intent);
    }

    public void needClick(View view){
        Intent intent = new Intent(this, HomelessMainActivity.class);
        startActivity(intent);
    }

}
