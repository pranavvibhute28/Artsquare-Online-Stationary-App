package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid1);
    }

    public void wpad(View view) {
        Intent intent = new Intent(grid1.this,detail.class);
        startActivity(intent);
    }
}