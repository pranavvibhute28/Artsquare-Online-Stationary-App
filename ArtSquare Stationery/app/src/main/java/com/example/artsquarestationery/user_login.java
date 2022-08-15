package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class user_login extends AppCompatActivity {
    public EditText inputEmail;
    public TextInputLayout inputPassword;
    public Button btnLogin;
    public ProgressBar progressBar;
    public FirebaseAuth auth;
    //Bundle extras;
    //String temppass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(user_login.this, homepagefirst.class));
            finish();
        }

        btnLogin = findViewById(R.id.btnLogin);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        progressBar = findViewById(R.id.progressBar);
        //Intent i = getIntent();
        //temppass = i.getStringExtra("Temp");

        auth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_LONG).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(user_login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError("Password Length Must be more than 6 Characters");
                                    }
                                    else {
                                        Toast.makeText(user_login.this, "Authentication Failed due to Invalid Credentials", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(user_login.this, homepagefirst.class);
                                    Toast.makeText(user_login.this,"Logged In Successfully",Toast.LENGTH_LONG).show();
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

    }

    public void register(View view) {
        Intent indent;
        indent = new Intent(user_login.this,register_account.class);
        startActivity(indent);
    }

    public void forgot(View view) {
        Intent intent;
        intent = new Intent(user_login.this,SendOTPActivity.class);
        startActivity(intent);
    }

    public void admin(View view) {
        Intent ad = new Intent(this,admin_login.class);
        startActivity(ad);
        finish();
    }
}