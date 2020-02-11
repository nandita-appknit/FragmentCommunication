package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSend
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageFragment messageFragment = new MessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flFragmentContainer,messageFragment,null).commit();
    }

    @Override
    public void onmessagesend(String message) {
    DisplayFragment displayFragment=new DisplayFragment();
    Bundle bundle=new Bundle();
    bundle.putString("message",message);
    displayFragment.setArguments(bundle);
    getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentContainer,displayFragment,null).addToBackStack(null).commit();
    }
}
