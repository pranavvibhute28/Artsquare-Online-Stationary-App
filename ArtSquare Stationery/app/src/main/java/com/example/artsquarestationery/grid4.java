package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid4);
    }

    public void off1(View view) {
        Intent intent = new Intent(grid4.this,off1.class);
        startActivity(intent);
    }

    public void off2(View view) {
        Intent intent = new Intent(grid4.this,off2.class);
        startActivity(intent);
    }

    public void off3(View view) {
        Intent intent = new Intent(grid4.this,off3.class);
        startActivity(intent);
    }

    public void off4(View view) {
        Intent intent = new Intent(grid4.this,off4.class);
        startActivity(intent);
    }

    public void off5(View view) {
        Intent intent = new Intent(grid4.this,off5.class);
        startActivity(intent);
    }
}