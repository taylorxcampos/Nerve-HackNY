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

public class CompanyJobActivity extends AppCompatActivity {
    String jtt;
    String cnt;
    String clt;
    String poft;
    String cdet;

    private DatabaseReference mDatabase;

    EditText jobTitleText;
    EditText companyNameText;
    EditText companyLocationText;
    EditText partOrFullText;
    EditText companyDescriptionText;

    Map<String, Object> mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_job);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        jobTitleText = (EditText) findViewById(R.id.editJobTitle);
        companyNameText = (EditText) findViewById(R.id.editCompanyName3);
        companyLocationText = (EditText) findViewById(R.id.editCompLocJob);
        partOrFullText = (EditText) findViewById(R.id.editCompPartorFull);
        companyDescriptionText = (EditText) findViewById(R.id.editCompDescription3);



    }

    public void postJob(View view){

        jtt = jobTitleText.getText().toString();
        cnt = companyNameText.getText().toString();
        clt = companyLocationText.getText().toString();
        poft = partOrFullText.getText().toString();
        cdet = companyDescriptionText.getText().toString();

        mp = new HashMap<>();

        Job job = new Job(jtt, cnt, clt, poft, cdet);

        Log.d("JOB", jtt);

        mp.putAll(job.toMap());

        mDatabase.child("jobs").child("kjid5LabR6cXJlck6s0i2jJXqDH3").setValue(mp);

        Intent intent = new Intent(this, CompanyMainActivity.class);
        startActivity(intent);

    }
}
