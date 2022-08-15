package com.example.artsquarestationery;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class delivered extends AppCompatActivity {

    ListView lview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Delivery d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        d = new Delivery();
        lview = findViewById(R.id.delilist);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Delivery");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.list_user,R.id.users,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    d = ds.getValue(Delivery.class);
                    list.add("Name : "+d.getName().toString() +"\n"+
                            "Item : "+d.getItem().toString() +"\n"+
                            "Quantity : "+d.getQuantity().toString() +"\n"+
                            "Price : "+d.getPrice().toString() +"\n"+
                            "Address : "+d.getAddress().toString() +"\n"+
                            "Total Price : "+d.getTotalprice().toString() +"\n"+
                            "Contact : "+d.getContact().toString());
                }
                lview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}