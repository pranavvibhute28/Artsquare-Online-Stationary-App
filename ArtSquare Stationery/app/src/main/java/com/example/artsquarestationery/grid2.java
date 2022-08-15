package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class grid2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid2);
    }

    public void engg1(View view) {
        Intent intent = new Intent(grid2.this,engg1.class);
        startActivity(intent);
    }

    public void engg2(View view) {
        Intent intent = new Intent(grid2.this,engg2.class);
        startActivity(intent);
    }

    public void engg3(View view) {
        Intent intent = new Intent(grid2.this,engg3.class);
        startActivity(intent);
    }

    public void engg4(View view) {
        Intent intent = new Intent(grid2.this,engg4.class);
        startActivity(intent);
    }

    public void engg5(View view) {
        Intent intent = new Intent(grid2.this,engg5.class);
        startActivity(intent);
    }
}