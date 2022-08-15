package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.example.artsquarestationery.HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    View rootview;
    ListView listview;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    String[] items = {"Camel Oil Colours (Set of 12)","Brush Set (Set of 12)","Sketchbook (Set of 6)","Miss & Chief Art Set","Sketching Pencil Set (Set of 6)",
            "Mini Drafter","Drawing Board","PCB (Set of 10)","Soldering Iron Kit","Multimeter set with LCD Display",
            "Classmate Octane Gel Pen Set (Pack of 12)","Pocket Size Spiral Sticky Notepad (Set of 12)","Apsara Stationery School Set","Coloured Pencils (Set of 6)","Apsara Eraser (Pack of 12)",
            "Classmate Notebook (Multicolor, Set of 4)","Classmate Longbook (Multicolor, Set of 6)","Classmate A4 Size (MultiColor, Set of 6)","Classmate Longbook A4 size (Multicolor, Set of 12)","Schoolmate Notebook (Multicolor, Set of 10)",
            "Highlighter (Set of 5)","Steel Paper Clips (Set of 12)","Portable Laptop Table","File Folder (Set of 12)","Stapler & Punching machine Set",
            "Writing Pad (Set of 12)"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static com.example.artsquarestationery.HomeFragment newInstance(String param1, String param2) {
        com.example.artsquarestationery.HomeFragment fragment = new com.example.artsquarestationery.HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_home, container, false);

        final EditText txtsearch = (EditText) rootview.findViewById(R.id.txtsearch);
        listout();

        txtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    listout();
                }
                else{
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return rootview;
    }

    private void searchItem(String search) {
        for(String item:items){
            if(!item.contains(search)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void listout() {
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item,R.id.userInfo,listItems);
        listview = (ListView) rootview.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(view.getContext(),art1.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(view.getContext(),art2.class);
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(view.getContext(),art3.class);
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(view.getContext(),art4.class);
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent = new Intent(view.getContext(),art5.class);
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent = new Intent(view.getContext(),engg1.class);
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent = new Intent(view.getContext(),engg2.class);
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent = new Intent(view.getContext(),engg3.class);
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent = new Intent(view.getContext(),engg4.class);
                    startActivity(intent);
                }
                if(position==9){
                    Intent intent = new Intent(view.getContext(),engg5.class);
                    startActivity(intent);
                }
                if(position==10){
                    Intent intent = new Intent(view.getContext(),gen1.class);
                    startActivity(intent);
                }
                if(position==11){
                    Intent intent = new Intent(view.getContext(),gen2.class);
                    startActivity(intent);
                }
                if(position==12){
                    Intent intent = new Intent(view.getContext(),gen3.class);
                    startActivity(intent);
                }
                if(position==13){
                    Intent intent = new Intent(view.getContext(),gen4.class);
                    startActivity(intent);
                }
                if(position==14){
                    Intent intent = new Intent(view.getContext(),gen5.class);
                    startActivity(intent);
                }
                if(position==15){
                    Intent intent = new Intent(view.getContext(),n1.class);
                    startActivity(intent);
                }
                if(position==16){
                    Intent intent = new Intent(view.getContext(),n2.class);
                    startActivity(intent);
                }
                if(position==17){
                    Intent intent = new Intent(view.getContext(),n3.class);
                    startActivity(intent);
                }
                if(position==18){
                    Intent intent = new Intent(view.getContext(),n4.class);
                    startActivity(intent);
                }
                if(position==19){
                    Intent intent = new Intent(view.getContext(),n5.class);
                    startActivity(intent);
                }
                if(position==20){
                    Intent intent = new Intent(view.getContext(),off1.class);
                    startActivity(intent);
                }
                if(position==21){
                    Intent intent = new Intent(view.getContext(),off2.class);
                    startActivity(intent);
                }
                if(position==22){
                    Intent intent = new Intent(view.getContext(),off3.class);
                    startActivity(intent);
                }
                if(position==23){
                    Intent intent = new Intent(view.getContext(),off4.class);
                    startActivity(intent);
                }
                if(position==24){
                    Intent intent = new Intent(view.getContext(),off5.class);
                    startActivity(intent);
                }
                if(position==25){
                    Intent intent = new Intent(view.getContext(),detail.class);
                    startActivity(intent);
                }
            }
        });
    }
}