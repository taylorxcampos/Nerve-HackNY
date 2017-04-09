package com.example.taylorcampos.hacknyfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomelessServiceActivity extends AppCompatActivity {
    ArrayList<String> myArrayList = new ArrayList<>();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference mPostReference = ref.child("services").child("kjid5LabR6cXJlck6s0i2jJXqDH3");
    DatabaseReference temp = ref.child("services");

    ArrayAdapter<String> adapter;

    @Override
    public void onStart(){
        super.onStart();


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Service service = postSnapshot.getValue(Service.class);

                    myArrayList.add(service.getService() + "\n" + service.getCompanyName()  + "\n" + service.getLocation()
                            + " " +service.getDate() + " " + service.getTime() + "\n"+ service.getDescription());

                }

                ListView lv = (ListView)findViewById(R.id.list);
                adapter = new ArrayAdapter<String>(HomelessServiceActivity.this, android.R.layout.simple_list_item_1, myArrayList);
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
        setContentView(R.layout.activity_homeless_service);
    }
}
