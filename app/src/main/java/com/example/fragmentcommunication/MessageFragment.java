package com.example.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    EditText editText;
    Button button;
    OnMessageSend onMessageSend;
    public MessageFragment() {
        // Required empty public constructor
    }
    public interface OnMessageSend {
        public void onmessagesend(String message);
        }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        editText=view.findViewById(R.id.etMessage);
        button=view.findViewById(R.id.bn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                onMessageSend.onmessagesend(message);
            }
        });

        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity)context;
        onMessageSend=(OnMessageSend)activity;

    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}
