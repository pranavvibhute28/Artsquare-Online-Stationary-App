package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid5);
    }

    public void art1(View view) {
        Intent intent = new Intent(grid5.this,art1.class);
        startActivity(intent);
    }

    public void art2(View view) {
        Intent intent = new Intent(grid5.this,art2.class);
        startActivity(intent);
    }

    public void art3(View view) {
        Intent intent = new Intent(grid5.this,art3.class);
        startActivity(intent);
    }

    public void art4(View view) {
        Intent intent = new Intent(grid5.this,art4.class);
        startActivity(intent);
    }

    public void art5(View view) {
        Intent intent = new Intent(grid5.this,art5.class);
        startActivity(intent);
    }
}