package com.example.artsquarestationery;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
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

public class edit_info extends AppCompatActivity {

    private FirebaseUser user;
    private String userId;
    private DatabaseReference reference;

    String name1,username1,sname1,saddress1,phno1,pass1;
    EditText name11,username11,sname11,saddress11,phno11,pass11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        name11 = findViewById(R.id.name);
        username11 = findViewById(R.id.username);
        sname11 =findViewById(R.id.sname);
        saddress11 = findViewById(R.id.saddress);
        phno11 = findViewById(R.id.phno);
        pass11 = findViewById(R.id.pass);

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile!=null){
                    name1 = userprofile.name;
                    username1 = userprofile.username;
                    sname1 = userprofile.shop_name;
                    saddress1 = userprofile.shop_address;
                    phno1 = userprofile.phone_no;
                    pass1 = userprofile.password;

                    name11.setText(name1);
                    username11.setText(username1);
                    sname11.setText(sname1);
                    saddress11.setText(saddress1);
                    phno11.setText(phno1);
                    pass11.setText(pass1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(edit_info.this, "Something went Wrong..", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void update(View view) {
        if(isNameChanged() || isUsernameChanged() || isShopnameChanged() || isShopaddressChanged() || isPhoneChanged() || isPassChanged()){
            Toast.makeText(this,"Profile Data has been successfully Updated",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Profile Data is same and cannot be updated",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isPassChanged() {
        if(!pass1.equals(pass11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("password").setValue(pass11.getText().toString());
            pass1 = pass11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isPhoneChanged() {
        if(!phno1.equals(phno11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("phone_no").setValue(phno11.getText().toString());
            phno1 = phno11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isShopaddressChanged() {
        if(!saddress1.equals(saddress11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("shop_address").setValue(saddress11.getText().toString());
            saddress1 = saddress11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isShopnameChanged() {
        if(!sname1.equals(sname11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("shop_name").setValue(sname11.getText().toString());
            sname1 = sname11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isUsernameChanged() {
        if(!username1.equals(username11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("username").setValue(username11.getText().toString());
            username1 = username11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }

    }

    private boolean isNameChanged() {
        if(!name1.equals(name11.getText().toString().trim())){
            reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").setValue(name11.getText().toString());
            name1 = name11.getText().toString().trim();
            return true;
        }
        else{
            return false;
        }
    }
}