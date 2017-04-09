package com.example.taylorcampos.hacknyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CompanyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
    }
    public void companyJob(View view) {
        Intent intent = new Intent(this, CompanyJobActivity.class);
        startActivity(intent);
    }
    public void companyServices(View view) {
        Intent intent = new Intent(this, CompanyServiceActivity.class);
        startActivity(intent);
    }

    public void companyFood(View view) {
        Intent intent = new Intent(this, CompanyFoodActivity.class);
        startActivity(intent);
    }

}
