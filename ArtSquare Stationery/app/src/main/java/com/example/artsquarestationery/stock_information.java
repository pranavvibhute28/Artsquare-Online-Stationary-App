package com.example.artsquarestationery;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class stock_information extends AppCompatActivity {

    ListView listview;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    String[] items = {"Camel Oil Colours (Set of 12) ~ ₹599","Brush Set (Set of 12) ~ ₹399","Sketchbook (Set of 6) ~ ₹459","Miss & Chief Art Set ~ ₹259","Sketching Pencil Set (Set of 6) ~ ₹375",
            "Mini Drafter ~ ₹250","Drawing Board ~ ₹520","PCB (Set of 10) ~ ₹300","Soldering Iron Kit ~ ₹300","Multimeter set with LCD Display ~ ₹450",
            "Classmate Octane Gel Pen Set (Pack of 12) ~ ₹100","Pocket Size Spiral Sticky Notepad (Set of 12) ~ ₹299","Apsara Stationery School Set ~ ₹110","Coloured Pencils (Set of 6) ~ ₹600","Apsara Eraser (Pack of 12) ~ ₹59",
            "Classmate Notebook (Multicolor, Set of 4) ~ ₹163","Classmate Longbook (Multicolor, Set of 6) ~ ₹296","Classmate A4 Size (MultiColor, Set of 6) ~ ₹315","Classmate Longbook A4 size (Multicolor, Set of 12) ~ ₹528","Schoolmate Notebook (Multicolor, Set of 10) ~ ₹269",
            "Highlighter (Set of 5) - ₹180","Steel Paper Clips (Set of 12) ~ ₹259","Portable Laptop Table ~ ₹699","File Folder (Set of 12) ~ ₹1576","Stapler & Punching machine Set ~ ₹310",
            "Writing Pad (Set of 12) ~ ₹899"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_information);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listItems=new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.userInfo,listItems);
        listview = findViewById(R.id.listv);
        listview.setAdapter(adapter);
    }
}