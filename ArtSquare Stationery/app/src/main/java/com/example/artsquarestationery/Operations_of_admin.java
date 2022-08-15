package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Operations_of_admin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_of_admin);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void up(View view) {
        Intent i11 = new Intent(this,up_stock.class);
        startActivity(i11);
    }

    public void logoutad(View view) {
        Intent logout = new Intent(this,admin_login.class);
        startActivity(logout);
        finish();
    }

    public void userinfo(View view) {
        Intent intent = new Intent(this,user_information.class);
        startActivity(intent);
    }

    public void stockinfo(View view) {
        Intent intent = new Intent(this,stock_information.class);
        startActivity(intent);
    }

    public void customerorder(View view) {
        Intent intent = new Intent(this,customer_orders.class);
        startActivity(intent);
    }

    public void deliveryitem(View view) {
        Intent intent = new Intent(this,delivered.class);
        startActivity(intent);
    }
}