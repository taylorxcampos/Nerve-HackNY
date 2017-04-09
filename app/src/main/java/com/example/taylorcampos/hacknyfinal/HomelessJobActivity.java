package com.example.taylorcampos.hacknyfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomelessJobActivity extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference mPostReference = ref.child("jobs").child("KhH0gvMe-pc4HxhPQCJ");
    DatabaseReference temp = ref.child("jobs");

    ArrayAdapter<String> adapter;

    @Override
    public void onStart(){
        super.onStart();


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Job job = postSnapshot.getValue(Job.class);

                    myArrayList.add(job.getTitle() + "\n" + job.getCompanyName()  + "\n" + job.getLocation()
                            + " " +job.getPartOrFull() + " " + job.getDescription());

                }

                ListView lv = (ListView)findViewById(R.id.list);
                adapter = new ArrayAdapter<String>(HomelessJobActivity.this, android.R.layout.simple_list_item_1, myArrayList);
                lv.setAdapter(adapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Getting Post failed, log a message
                Log.w("HOMELESSFOOD", "loadPost:onCancelled", databaseError.toException());

            }
        };
        temp.addValueEventListener(postListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_job);
    }
}
