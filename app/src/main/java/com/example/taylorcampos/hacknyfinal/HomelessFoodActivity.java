package com.example.taylorcampos.hacknyfinal;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomelessFoodActivity extends AppCompatActivity{
    ArrayList<String> myArrayList = new ArrayList<>();

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference mPostReference = ref.child("food").child("KhH0gvMe-pc4HxhPQCJ");
    DatabaseReference temp = ref.child("food");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeless_food);

    }

    ArrayAdapter<String> adapter;


    @Override
    public void onStart(){
        super.onStart();


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                Food food = postSnapshot.getValue(Food.class);

                  myArrayList.add(food.getType() + "\n" + food.getCompanyName()  + "\n" + food.getLocation() + " " +food.getDate() + " " + food.getTime() + "\n"+ food.getDescription());

            }

                ListView lv = (ListView)findViewById(R.id.list);
                adapter = new ArrayAdapter<String>(HomelessFoodActivity.this, android.R.layout.simple_list_item_1, myArrayList);
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

}
