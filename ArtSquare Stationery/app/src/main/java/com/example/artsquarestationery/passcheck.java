package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class passcheck extends AppCompatActivity {

    public TextView randomnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcheck);
        randomnum=findViewById(R.id.randomnum);
        int n = 10000000 + new Random().nextInt(90000000);
        randomnum.setText(n+"");
    }

    public void passuplogin(View view) {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signOut();
        String str = randomnum.getText().toString();
        Intent intent = new Intent(passcheck.this,user_login.class);
        intent.putExtra("Temp",str);
        startActivity(intent);
        finish();
    }
}