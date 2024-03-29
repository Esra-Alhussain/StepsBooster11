package com.example.stepbooster_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Security;

import static com.example.stepbooster_11.StepsUsers.*;

public class Update extends AppCompatActivity {

    EditText tID,tName,tEmail,tPassword,tConfirmPassword;
    Button btnUpdate,btnCancel;
    DatabaseReference databaseReference;
    private TextView result;
    Module module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        result=(TextView)findViewById(R.id.textView2);
        tID=(EditText) findViewById(R.id.tID);
        tName=(EditText) findViewById(R.id.tName);
        tEmail=(EditText) findViewById(R.id.tEmail);
        tPassword=(EditText) findViewById(R.id.tPassword);
        tConfirmPassword=(EditText) findViewById(R.id.tconfirmPassword);
        btnUpdate=(Button) findViewById(R.id.btnUpadate);
        btnCancel= (Button) findViewById(R.id.btnCancel) ;
        databaseReference= FirebaseDatabase.getInstance().getReference("Students");
        module=((Module)getApplicationContext());
        final String str = module.getGvalue_id().substring(0,6);
        tID.setText(str);
        tID.setEnabled(false);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StepsUsers stepsUsers = dataSnapshot.child(str).getValue(StepsUsers.class);
                tEmail.setText(StepsUsers.getEmail());
                tName.setText(StepsUsers.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateArrayList();
                Cleartxt();
                Intent intphto =new Intent(getApplicationContext(),Showdata.class);
                startActivity(intphto);


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cleartxt();
            }
        });
    }
    private void Cleartxt(){
        tID.setText("");
        tEmail.setText("");
        tName.setText("");
        tPassword.setText("");
        tConfirmPassword.setText("");
        result.setText("");
        tID.requestFocus();

    }

    private void  updateArrayList() {
        final String ID = tID.getText().toString().trim();
        final String email = tEmail.getText().toString().trim();
        final String name = tName.getText().toString().trim();
        final String password = tPassword.getText().toString().trim();
        String comfirmpassword = tConfirmPassword.getText().toString().trim();
        String resulthash = result.getText().toString().trim();

        if (TextUtils.isEmpty(ID)) {
            tID.setError("Please enter your ID!");
        } else if (TextUtils.isEmpty(name)) {
            tName.setError("Please enter your Name!");
        } else if (TextUtils.isEmpty(email)) {
            tEmail.setError("Please enter your Email!");
        } else if (TextUtils.isEmpty(password)) {
            tPassword.setError("Please enter your Password!");
        } else if (!password.equals(comfirmpassword)) {
            tConfirmPassword.setError("Please put the same password");
        } else {

            StepsUsers stepsUsers = new StepsUsers(ID, email, name, password);
            databaseReference.child("Students").child(ID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    databaseReference = FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("Students").child(ID).child("email").setValue(email);
                    databaseReference.child("Students").child(ID).child("name").setValue(name);
                   /** try {
                        databaseReference.child("Students").child(ID).child("password").setValue(Security.encrypt(password));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }**/

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            Toast.makeText(this, "Student is updated", Toast.LENGTH_LONG).show();
            Cleartxt();

        }
    }
}