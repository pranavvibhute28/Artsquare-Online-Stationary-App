package com.example.artsquarestationery;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register_account extends AppCompatActivity {

    EditText name, username, shopnm, shopadd, phno, email, pass;
    public FirebaseAuth mAuth;
    Button b1;

    public Object ExampleDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        shopnm = findViewById(R.id.shopnm);
        shopadd = findViewById(R.id.shopadd);
        phno = findViewById(R.id.phno);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        phno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(validateMobile(phno.getText().toString())){

                }
                else
                {
                    phno.setError("Please Provide Valid Phone Number");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    boolean validateMobile(String input){
        Pattern p = Pattern.compile("[0-9]{10}");
        Matcher m = p.matcher(input);
        return m.matches();
    }

    public void registerUser() {

        String nm = name.getText().toString().trim();
        String unm = username.getText().toString().trim();
        String snm = shopnm.getText().toString().trim();
        String sadd = shopadd.getText().toString().trim();
        String phn = phno.getText().toString().trim();
        String em = email.getText().toString().trim();
        String p = pass.getText().toString().trim();

        if(nm.isEmpty()){
            name.setError("Full Name is Required");
            name.requestFocus();
            return;
        }

        if(unm.isEmpty()){
            username.setError("Username is Required");
            username.requestFocus();
            return;
        }

        if(snm.isEmpty()){
            shopnm.setError("Shop Name is Required");
            shopnm.requestFocus();
            return;
        }

        if(sadd.isEmpty()){
            shopadd.setError("Shop Address is Required");
            shopadd.requestFocus();
            return;
        }

        if(phn.isEmpty()){
            phno.setError("Contact Number is Required");
            phno.requestFocus();
            return;
        }

        if(em.isEmpty()){
            email.setError("E-mail ID is Required");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            email.setError("Please Provide Valid E-mail");
            email.requestFocus();
            return;
        }

        if(p.isEmpty()){
            pass.setError("Password is Required");
            pass.requestFocus();
            return;
        }

        if(p.length() < 6){
            pass.setError("Minimum Password Length should be 6 characters");
            pass.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(em,p)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(nm,unm,snm,sadd,phn,em,p);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(register_account.this,"User Registered Successfully",Toast.LENGTH_LONG).show();
                                        name.setText("");
                                        username.setText("");
                                        shopnm.setText("");
                                        shopadd.setText("");
                                        phno.setText("");
                                        email.setText("");
                                        pass.setText("");
                                    }
                                    else
                                    {
                                        Toast.makeText(register_account.this,"Failed to Register...Try Again!!",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(register_account.this,"Failed to Register...Try Again!!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void helpbox(View view) {
        openDialog();
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}