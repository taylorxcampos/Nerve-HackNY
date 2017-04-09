package com.example.taylorcampos.hacknyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CompanyFoodActivity extends AppCompatActivity {

    private Map<String, Object> mp;
    String tt;
    String cnt;
    String cdt;
    String ctt;
    String clt;
    String cdect;

    private DatabaseReference mDatabase;

    EditText typeText;
    EditText companyNameText;
    EditText companyDateText;
    EditText companyTimeText;
    EditText companyLocationText;
    EditText companyDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_food);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        typeText = (EditText) findViewById(R.id.editCompanyFoodType);
        companyNameText = (EditText) findViewById(R.id.editCompanyName2);
        companyDateText = (EditText) findViewById(R.id.editCompanyDate2);
        companyTimeText = (EditText) findViewById(R.id.editCompanyTime2);
        companyLocationText = (EditText) findViewById(R.id.editCompLocFood);
        companyDescriptionText = (EditText) findViewById(R.id.editCompDescription2);



    }
    public void postFood(View view){
        tt = typeText.getText().toString();
        cnt = companyNameText.getText().toString();
        cdt = companyDateText.getText().toString();
        ctt = companyTimeText.getText().toString();
        clt = companyLocationText.getText().toString();
        cdect = companyDescriptionText.getText().toString();

        mp = new HashMap<String, Object>();

        Food food = new Food(tt,cnt,cdt,ctt,clt,cdect);

        mp.putAll(food.toMap());

        mDatabase.child("food").child("kjid5LabR6cXJlck6s0i2jJXqDH3").setValue(mp);

        Intent intent = new Intent(this, CompanyMainActivity.class);
        startActivity(intent);
    }
}
