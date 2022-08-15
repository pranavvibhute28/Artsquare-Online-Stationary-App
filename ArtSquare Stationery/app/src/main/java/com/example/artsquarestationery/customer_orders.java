package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
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

public class customer_orders extends AppCompatActivity {

    ListView lview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Orders o;
    String name,item,quantity,price,address,totalprice,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_orders);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        o = new Orders();
        lview = findViewById(R.id.lview);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Orders");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.list_user,R.id.users,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    o = ds.getValue(Orders.class);
                    name=""+o.getName().toString();
                    item=""+o.getItem().toString();
                    quantity=""+o.getQuantity().toString();
                    price=""+o.getPrice().toString();
                    address=""+o.getAddress().toString();
                    totalprice=""+o.getTotalprice().toString();
                    contact=""+o.getContact().toString();

                    list.add(name+"  \n"+
                            item+"  \n"+
                            quantity+"  \n"+
                            price+"  \n"+
                            address+"  \n"+
                            totalprice+"  \n"+
                            contact);

                    lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String s = list.get(position);
                            String[] data = s.split("  \n");
                            Intent orderdetails = new Intent(customer_orders.this,order_info.class);
                            orderdetails.putExtra("name",data[0]);
                            orderdetails.putExtra("item",data[1]);
                            orderdetails.putExtra("quantity",data[2]);
                            orderdetails.putExtra("price",data[3]);
                            orderdetails.putExtra("address",data[4]);
                            orderdetails.putExtra("totalprice",data[5]);
                            orderdetails.putExtra("contact",data[6]);
                            startActivity(orderdetails);
                        }
                    });
                }
                lview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}