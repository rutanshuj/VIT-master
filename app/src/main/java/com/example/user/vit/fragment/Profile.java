package com.example.user.vit.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.vit.R;

import java.util.Properties;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    EditText phnum;
    EditText msg;
    Button send;
    String num, txt;
    String[] rec={ "anushkaanand.1998@gmail.com"};
    String subject= "Feedback";


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        phnum= (EditText)view.findViewById(R.id.phnum);
        msg=(EditText)view.findViewById(R.id.message);
        send=(Button)view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num= phnum.getText().toString();
                txt= msg.getText().toString() + "\nMobile number - " + num;


                String emailID = "akhilagarwal96@gmail.com";
                Log.d("asdfghjkl", num);
                Log.d("asdfghjkl", txt);

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", emailID, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                        subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        txt);
                startActivity(emailIntent);
            }
        });
        return view;
    }

}
