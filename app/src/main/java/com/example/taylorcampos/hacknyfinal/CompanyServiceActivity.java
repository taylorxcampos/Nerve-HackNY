package com.example.taylorcampos.hacknyfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class CompanyServiceActivity extends AppCompatActivity {
    private Map<String, Object> mp;

    String ms;
    String cnt;
    String dt;
    String tt;
    String clt;
    String cdet;

    private DatabaseReference mDatabase;

    Spinner mySpinner;
    EditText companyNameText;
    EditText dateText;
    EditText timeText;
    EditText companyLocationText;
    EditText companyDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_service);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.servicess_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        mySpinner = (Spinner) findViewById(R.id.spinner);
        companyNameText = (EditText) findViewById(R.id.editCompanyName1);
        dateText = (EditText) findViewById(R.id.editCompanyDate1);
        timeText = (EditText) findViewById(R.id.editCompanyTime1);
        companyLocationText = (EditText) findViewById(R.id.editCompLocation1);
        companyDescriptionText = (EditText) findViewById(R.id.editCompDescription1);


    }
    public void postService(View view){
        ms = mySpinner.getSelectedItem().toString();
        cnt = companyNameText.getText().toString();
        dt = dateText.getText().toString();
        tt = timeText.getText().toString();
        clt = companyLocationText.getText().toString();
        cdet = companyDescriptionText.getText().toString();

        mp = new HashMap<String, Object>();

        Service service = new Service(ms, cnt, dt,tt
                , clt , cdet);

        mp.putAll(service.toMap());

        mDatabase.child("services").child("kjid5LabR6cXJlck6s0i2jJXqDH3").setValue(mp);

        Intent intent = new Intent(this, CompanyMainActivity.class);
        startActivity(intent);
    }
}
