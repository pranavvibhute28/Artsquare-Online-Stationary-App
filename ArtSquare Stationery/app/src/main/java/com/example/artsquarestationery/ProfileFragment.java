package com.example.artsquarestationery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.example.artsquarestationery.ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private FirebaseUser user;
    private DatabaseReference reference;
    public FirebaseAuth mAuth;

    private String userId;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static com.example.artsquarestationery.ProfileFragment newInstance(String param1, String param2) {
        com.example.artsquarestationery.ProfileFragment fragment = new com.example.artsquarestationery.ProfileFragment();
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
        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);
        final Intent intent = new Intent(getActivity(),edit_info.class);
        final Intent intent1 = new Intent(getActivity(),empty_cart.class);
        final Intent intent2 = new Intent(getActivity(),cart.class);

        final Button buttonedit = (Button) rootview.findViewById(R.id.buttonedit);
        final Button cartbtn = (Button) rootview.findViewById(R.id.cartbtn);
        final Button logout = (Button) rootview.findViewById(R.id.logout);
        mAuth=FirebaseAuth.getInstance();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent2 = new Intent(getActivity(),user_login.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(getActivity(),"Logged Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(intent2);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userId = user.getUid();

        final TextView sn = rootview.findViewById(R.id.sn);
        final TextView nm = rootview.findViewById(R.id.nm);
        final TextView unm = rootview.findViewById(R.id.unm);
        final TextView sa = rootview.findViewById(R.id.sa);
        final TextView cn = rootview.findViewById(R.id.cn);
        final TextView em = rootview.findViewById(R.id.em);

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);
                if(userprofile!=null){
                    String sname = userprofile.shop_name;
                    String name = userprofile.name;
                    String usernm = userprofile.username;
                    String shopadd = userprofile.shop_address;
                    String contact = userprofile.phone_no;
                    String email = userprofile.e_mail;

                    sn.setText(sname);
                    nm.setText(name);
                    unm.setText(usernm);
                    sa.setText(shopadd);
                    cn.setText(contact);
                    em.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went Wrong..", Toast.LENGTH_LONG).show();
            }
        });

        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                rootRef.child("Favourites");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.getValue() == null) {
                            startActivity(intent1);
                        }
                        else{
                            startActivity(intent2);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return rootview;
    }
}



