package com.example.stepbooster_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button register=(Button)  findViewById(R.id.register);
        Toast.makeText(MainActivity.this,"Firebase connection Success",Toast.LENGTH_LONG).show();


    }

    public void mRegister1 (View v){

        Intent s= new Intent(this, Register.class);
        startActivity(s);


    }
}
