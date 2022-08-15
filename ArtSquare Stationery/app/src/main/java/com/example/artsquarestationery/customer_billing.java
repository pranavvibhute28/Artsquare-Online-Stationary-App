package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class customer_billing extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    public FirebaseAuth mAuth;

    private String userId;

    String contact;

    ProgressBar pg;
    Button one,two,three;
    TextView item,quantity,price,total,limit;
    String it,qu,pr,tpr,pl;

    EditText crtaddress;

    TextView placed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_billing);

        placed = findViewById(R.id.placed);

        pg = findViewById(R.id.pg);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);

        item = findViewById(R.id.item);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);
        total = findViewById(R.id.total);
        limit = findViewById(R.id.limit);

        Intent i = getIntent();

        it = i.getStringExtra("item");
        qu = i.getStringExtra("quantity");
        pr = i.getStringExtra("price");
        tpr = i.getStringExtra("totalprice");
        pl = i.getStringExtra("pricelimit");

        item.setText(it);
        quantity.setText(qu);
        price.setText("₹"+pr);
        total.setText("TOTAL PRICE OF ORDER : ₹"+tpr);
        limit.setText("ORDER SHOULD BE ABOVE ₹"+pl);

        crtaddress = findViewById(R.id.crtaddress);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile!=null){
                    String shopadd = userprofile.shop_address;
                    crtaddress.setText(shopadd);
                    contact = userprofile.phone_no;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(customer_billing.this, "Something went Wrong..", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void commingsoon(View view) {
        Toast.makeText(customer_billing.this,"This functionality is to be added yet",Toast.LENGTH_LONG).show();
    }

    public void purchase(View view) {
        pg.setVisibility(View.VISIBLE);
        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);

        String n = String.valueOf(100 + new Random().nextInt(9999));

        String item1 = it;
        String quantity1 = qu;
        String price1 = pr;
        String address1 = crtaddress.getText().toString();
        String totalcost1 = tpr;
        String contact1 = contact;

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile!=null){
                    String name1 = userprofile.name;
                    Orders od = new Orders(name1,item1,quantity1,price1,address1,totalcost1,contact1);
                    FirebaseDatabase.getInstance().getReference("Orders")
                            .child(n).setValue(od);
                    pg.setVisibility(View.GONE);
                    placed.setVisibility(View.VISIBLE);
                    Toast.makeText(customer_billing.this,"Order Placed Successfully",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(customer_billing.this, "Something went Wrong..", Toast.LENGTH_LONG).show();
            }
        });
    }
}

