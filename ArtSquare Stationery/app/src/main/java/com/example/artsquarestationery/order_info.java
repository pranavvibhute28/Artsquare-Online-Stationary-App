package com.example.artsquarestationery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class order_info extends AppCompatActivity {

    TextView name,item,quantity,price,address,totalprice,contact;

    Button delivery;

    private DatabaseReference reference;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name=findViewById(R.id.name);
        item=findViewById(R.id.item);
        quantity=findViewById(R.id.quantity);
        price=findViewById(R.id.price);
        address=findViewById(R.id.address);
        totalprice=findViewById(R.id.totalprice);
        contact=findViewById(R.id.contact);

        delivery=findViewById(R.id.delivery);

        Intent i = getIntent();

        String nm=i.getStringExtra("name");
        String it=i.getStringExtra("item");
        String qu=i.getStringExtra("quantity");
        String pr=i.getStringExtra("price");
        String ad=i.getStringExtra("address");
        String tp=i.getStringExtra("totalprice");
        String co=i.getStringExtra("contact");

        name.setText(nm);
        item.setText(it);
        quantity.setText(qu);
        price.setText(pr);
        address.setText(ad);
        totalprice.setText(tp);
        contact.setText(co);

        delivery.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                delivery.setBackgroundColor(Color.GREEN);
                delivery.setText("PROCEEDED TO DELIVERY");

                String n = String.valueOf(100 + new Random().nextInt(9999));

                reference = FirebaseDatabase.getInstance().getReference();

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Delivery d = new Delivery(nm,it,qu,pr,ad,tp,co);
                            FirebaseDatabase.getInstance().getReference("Delivery")
                                    .child(n).setValue(d);
                            Toast.makeText(order_info.this,"Order Getting Delivered Successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(order_info.this, "Something went Wrong..", Toast.LENGTH_LONG).show();
                    }
                });

                delivery.setEnabled(false);

                Intent intent = new Intent(order_info.this,finalbill.class);
                intent.putExtra("bname",nm);
                intent.putExtra("bcontact",co);
                intent.putExtra("baddress",ad);
                intent.putExtra("bitem",it);
                intent.putExtra("bprice",pr);
                intent.putExtra("bquantity",qu);
                intent.putExtra("btotalprice",tp);
                startActivity(intent);
            }
        });

    }
}