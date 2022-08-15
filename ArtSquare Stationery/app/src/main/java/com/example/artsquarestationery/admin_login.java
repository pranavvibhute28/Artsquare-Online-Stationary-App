package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class admin_login extends AppCompatActivity {

    public EditText admail;
    public TextInputLayout adpass;
    public Button adlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        adlog=findViewById(R.id.adlog);
        admail=findViewById(R.id.admail);
        adpass=findViewById(R.id.adpass);

        adlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=admail.getText().toString();
                String s2=adpass.getEditText().getText().toString();
                if(s1.equals("asadmin131@gmail.com") && s2.equals("AsPass@1928")) {
                    Toast.makeText(admin_login.this, "Admin Logged in Successfully", Toast.LENGTH_LONG).show();
                    Intent op = new Intent(admin_login.this, Operations_of_admin.class);
                    startActivity(op);
                    finish();
                }
                else
                {
                    Toast.makeText(admin_login.this,"Unsuccessful login due to Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}