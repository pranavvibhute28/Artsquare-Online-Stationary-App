package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class art2 extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    public FirebaseAuth mAuth;
    private String userId;
    TextView itemname,cost;
    TextView value;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art2);

        value=(TextView) findViewById(R.id.value);
        itemname = findViewById(R.id.itemname2);
        cost = findViewById(R.id.cost2);
    }

    public void increment(View v){
        count++;
        value.setText(""+count);
    }

    public void decrement(View v){
        if(count<=0)
            count=0;
        else
            count--;
        value.setText(""+count);
    }

    public void favart2(View view) {
        String itnm = itemname.getText().toString();
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile!=null){
                    String name = userprofile.name;
                    Favourites fav = new Favourites(name,itnm);
                    FirebaseDatabase.getInstance().getReference("Favourites")
                            .child("d").setValue(fav);
                    Toast.makeText(art2.this,"Item Added to Favourites Successfully",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(art2.this, "Something went Wrong..", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void buyart2(View view) {
        int q = Integer.parseInt(value.getText().toString());
        if(q!=0){
            int itemcost = Integer.parseInt(cost.getText().toString());
            int quantity = Integer.parseInt(value.getText().toString());

            int totalprice = itemcost * quantity;

            if(totalprice<2000){
                Toast.makeText(this,"Total cost should be more than the limit : 2000",Toast.LENGTH_LONG).show();
            }
            else{
                Intent billing = new Intent(art2.this,customer_billing.class);
                billing.putExtra("item",itemname.getText().toString());
                billing.putExtra("quantity",value.getText().toString());
                billing.putExtra("price",cost.getText().toString());
                billing.putExtra("totalprice",String.valueOf(totalprice));
                billing.putExtra("pricelimit",String.valueOf(2000));
                startActivity(billing);
            }
        }
        else{
            Toast.makeText(this,"Quantity cannot be O for placing an order",Toast.LENGTH_LONG).show();
        }
    }
}