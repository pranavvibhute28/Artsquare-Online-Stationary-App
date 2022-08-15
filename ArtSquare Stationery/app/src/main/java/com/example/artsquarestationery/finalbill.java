package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class finalbill extends AppCompatActivity {

    TextView name,item,quantity,price,address,totalprice,contact,billInvoiceno,billDate,billTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalbill);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name=findViewById(R.id.billname);
        item=findViewById(R.id.billitem);
        quantity=findViewById(R.id.billquantity);
        price=findViewById(R.id.billprice);
        address=findViewById(R.id.billaddress);
        totalprice=findViewById(R.id.billtotalprice);
        contact=findViewById(R.id.billcontact);
        billInvoiceno=findViewById(R.id.billInvoiceno);
        billDate=findViewById(R.id.billDate);
        billTime=findViewById(R.id.billTime);

        Intent i = getIntent();

        String nm=i.getStringExtra("bname");
        String it=i.getStringExtra("bitem");
        String qu=i.getStringExtra("bquantity");
        String pr=i.getStringExtra("bprice");
        String ad=i.getStringExtra("baddress");
        String tp=i.getStringExtra("btotalprice");
        String co=i.getStringExtra("bcontact");

        TextView dateTimeDisplay;
        Calendar calendar;
        SimpleDateFormat dateFormat;
        String date;

        String n = String.valueOf(100 + new Random().nextInt(99999999));

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        billDate.setText(date);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z");
        String currentDateandTime = sdf.format(new Date());

        billTime.setText(currentDateandTime);

        name.setText(nm);
        item.setText(it);
        quantity.setText(qu);
        price.setText(pr);
        address.setText(ad);
        totalprice.setText("Total Price : ₹"+tp);
        contact.setText(co);
        billInvoiceno.setText(""+n);
    }

    public void backtoop(View view) {
        Intent intent = new Intent(finalbill.this,Operations_of_admin.class);
        startActivity(intent);
        finish();
    }
}