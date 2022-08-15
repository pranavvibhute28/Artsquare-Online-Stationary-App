package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid3);
    }

    public void gen1(View view) {
        Intent intent = new Intent(grid3.this,gen1.class);
        startActivity(intent);
    }

    public void gen2(View view) {
        Intent intent = new Intent(grid3.this,gen2.class);
        startActivity(intent);
    }

    public void gen3(View view) {
        Intent intent = new Intent(grid3.this,gen3.class);
        startActivity(intent);
    }

    public void gen4(View view) {
        Intent intent = new Intent(grid3.this,gen4.class);
        startActivity(intent);
    }

    public void gen5(View view) {
        Intent intent = new Intent(grid3.this,gen5.class);
        startActivity(intent);
    }
}