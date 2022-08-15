package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }

    public void n1(View view) {
        Intent intent = new Intent(grid.this, n1.class);
        startActivity(intent);
    }

    public void n2(View view) {
        Intent intent = new Intent(grid.this, n2.class);
        startActivity(intent);
    }

    public void n3(View view) {
        Intent intent = new Intent(grid.this, n3.class);
        startActivity(intent);
    }

    public void n4(View view) {
        Intent intent = new Intent(grid.this, n4.class);
        startActivity(intent);
    }

    public void n5(View view) {
        Intent intent = new Intent(grid.this, n5.class);
        startActivity(intent);
    }
}