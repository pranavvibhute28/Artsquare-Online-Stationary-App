package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.example.artsquarestationery.HelpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HelpFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HelpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HelpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static com.example.artsquarestationery.HelpFragment newInstance(String param1, String param2) {
        com.example.artsquarestationery.HelpFragment fragment = new com.example.artsquarestationery.HelpFragment();
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
        View rootview=inflater.inflate(R.layout.fragment_help, container, false);

        TextView help1,help2,help3,help4,help5,help6,help7;

        help1=(rootview).findViewById(R.id.help1);
        help2=(rootview).findViewById(R.id.help2);
        help3=(rootview).findViewById(R.id.help3);
        help4=(rootview).findViewById(R.id.help4);
        help5=(rootview).findViewById(R.id.help5);
        help6=(rootview).findViewById(R.id.help6);
        help7=(rootview).findViewById(R.id.help7);

        final Intent intent1 = new Intent(getActivity(),helpact1.class);

        help1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });

        final Intent intent2 = new Intent(getActivity(),helpact2map.class);

        help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        final Intent intent3 = new Intent(getActivity(),helpact3.class);

        help3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

        final Intent intent4 = new Intent(getActivity(),helpact4.class);

        help4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });

        final Intent intent5 = new Intent(getActivity(),helpact5.class);

        help5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent5);
            }
        });

        final Intent intent6 = new Intent(getActivity(),helpact6.class);

        help6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent6);
            }
        });

        final Intent intent7 = new Intent(getActivity(),helpact7.class);

        help7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent7);
            }
        });

        return rootview;
    }
}