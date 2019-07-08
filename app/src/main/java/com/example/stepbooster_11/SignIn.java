package com.example.stepbooster_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
     Button tSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        tSignIn=(Button)findViewById(R.id.tSignIn);

    }
}
