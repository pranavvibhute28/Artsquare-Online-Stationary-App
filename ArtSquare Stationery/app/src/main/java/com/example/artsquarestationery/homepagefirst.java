package com.example.artsquarestationery;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.artsquarestationery.CategoryFragment;
import com.example.artsquarestationery.HelpFragment;
import com.example.artsquarestationery.HomeFragment;
import com.example.artsquarestationery.ProfileFragment;
import com.example.artsquarestationery.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepagefirst extends AppCompatActivity {
BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new HomeFragment()).commit();

        bnv=(BottomNavigationView)findViewById(R.id.bottomnavigation);
                bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment temp=null;
                        switch (item.getItemId())
                        {
                            case R.id.menu_home : temp=new HomeFragment();
                            break;
                            case R.id.menu_category : temp=new CategoryFragment();
                            break;
                            case R.id.menu_help : temp=new HelpFragment();
                            break;
                            case R.id.menu_profile : temp=new ProfileFragment();
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,temp).commit();

                        return true;
                    }
                });
    }
}