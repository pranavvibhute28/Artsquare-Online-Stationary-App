package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.example.artsquarestationery.CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static com.example.artsquarestationery.CategoryFragment newInstance(String param1, String param2) {
        com.example.artsquarestationery.CategoryFragment fragment = new com.example.artsquarestationery.CategoryFragment();
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
        View rootview1 = inflater.inflate(R.layout.fragment_category, container, false);
        final Intent intent = new Intent(getActivity(),grid.class);
        final Intent intent1 = new Intent(getActivity(),grid1.class);
        final Intent intent2 = new Intent(getActivity(),grid2.class);
        final Intent intent3 = new Intent(getActivity(),grid3.class);
        final Intent intent4 = new Intent(getActivity(),grid4.class);
        final Intent intent5 = new Intent(getActivity(),grid5.class);

        final ImageView im1 = (ImageView) rootview1.findViewById(R.id.im1);
        final ImageView im2 = (ImageView) rootview1.findViewById(R.id.im2);
        final ImageView im3 = (ImageView) rootview1.findViewById(R.id.im3);
        final ImageView im4 = (ImageView) rootview1.findViewById(R.id.im4);
        final ImageView im5 = (ImageView) rootview1.findViewById(R.id.im5);
        final ImageView im6 = (ImageView) rootview1.findViewById(R.id.im6);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent5);
            }
        });

        return rootview1;
    }

}