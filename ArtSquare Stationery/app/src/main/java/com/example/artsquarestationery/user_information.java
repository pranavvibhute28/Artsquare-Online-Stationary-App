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

public class user_information extends AppCompatActivity {

    ListView lview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        u = new User();
        lview = findViewById(R.id.lview);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.list_user,R.id.users,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    u = ds.getValue(User.class);
                    list.add("Name : "+u.getName().toString() +"\n"+
                            "E-mail : "+u.getE_mail().toString() +"\n"+
                            "Phone : "+u.getPhone_no().toString() +"\n"+
                            "Shop Name : "+u.getShop_name());
                }
                lview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}