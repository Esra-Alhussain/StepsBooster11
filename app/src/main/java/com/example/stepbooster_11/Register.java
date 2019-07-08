package com.example.stepbooster_11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.lang.String;

public class Register extends AppCompatActivity {
    //FirebaseDatabase database = FirebaseDatabase.getInstance();

    EditText tID,tEmail,tPassword,tName,tconfirmPassword;
    Button tregister;
    ListView ListUser;
    private TextView result;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tEmail=(EditText) findViewById(R.id.tEmail);
        tPassword=(EditText) findViewById(R.id.tPassword);
        tconfirmPassword=(EditText) findViewById(R.id.tconfirmPassword);
        tName=(EditText) findViewById(R.id.tName);
        tID=(EditText) findViewById(R.id.tID);
        tregister=(Button)findViewById(R.id.tregister);

        databaseReference=FirebaseDatabase.getInstance().getReference("Users");
        tregister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //addArrayList();
                //Intent intphto = new Intent(getApplicationContext(), showdata.class);
               //startActivity(intphto);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });
       // btnShow.setOnClickListener(new View.OnClickListener() {
           // @Override
         //   public void onClick(View v) {
               // Intent intphto =new Intent(getApplicationContext(),Showdata.class);
              //  startActivity(intphto);

           // }
       // });
    }
    private void  addArrayList(){
        String ID = tID.getText().toString().trim();
        String email=tEmail.getText().toString().trim();
        String name =tName.getText().toString().trim();
        String password =tPassword.getText().toString().trim();
        String comfirmpassword =tconfirmPassword.getText().toString().trim();
        String resulthash = result.getText().toString().trim();

        if(TextUtils.isEmpty(ID)) {
            tID.setError("Please enter your ID!");
        }else if (TextUtils.isEmpty(name)){
            tName.setError("Please enter your Name!");
        }else if(TextUtils.isEmpty(email)){
            tEmail.setError("Please enter your Email!");
        }else if(TextUtils.isEmpty(password)){
            tPassword.setError("Please enter your Password!");
        }else if(!password.equals(comfirmpassword)){
            tconfirmPassword.setError("Please put the same password");
        }else{

            //String id=  databaseReference.push().getKey();
            StepsUsers stepsUsers= new StepsUsers(ID,name,email);
            databaseReference.child(ID).child("id").setValue(ID.toString());
            databaseReference.child(ID).child("email").setValue(email.toString());
            databaseReference.child(ID).child("name").setValue(name.toString());
           /** try {
                databaseReference.child(ID).child("password").setValue(Security.encrypt(password));
            } catch (Exception e) {
                e.printStackTrace();
            }**/
            Toast.makeText(this,"Student is added",Toast.LENGTH_LONG).show();
            Cleartxt();

        }

    }
    private void Cleartxt(){
        tID.setText("");
        tEmail.setText("");
        tName.setText("");
        tPassword.setText("");
        tconfirmPassword.setText("");
        result.setText("");
        tID.requestFocus();

    }
    public void computeMD5Hash(String password) {

        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                MD5Hash.append(h);
            }

            result.setText(MD5Hash);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
