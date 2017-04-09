package com.example.taylorcampos.hacknyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomelessMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_main);

    }

    public void companyJobHomeless(View view) {
        Intent intent = new Intent(this, HomelessJobActivity.class);
        startActivity(intent);
    }
    public void companyServicesHomeless(View view) {
        Intent intent = new Intent(this, HomelessServiceActivity.class);
        startActivity(intent);
    }

    public void companyFoodHomeless(View view) {
        Intent intent = new Intent(this, HomelessFoodActivity.class);
        startActivity(intent);


    }

}