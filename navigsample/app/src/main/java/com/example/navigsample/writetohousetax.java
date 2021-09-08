package com.example.navigsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class writetohousetax extends AppCompatActivity {
    private static final String TAG = "";
    EditText pname;
    EditText pnumber;
    EditText pamount;
    EditText pduedate;
    String qname;
    String qnumber;
    String qamount;
    String qduedate;
    Button paddbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writetohousetax);

        pname= findViewById(R.id.addhtname);
        pnumber= (EditText)findViewById(R.id.addhtnumber);
        pamount= (EditText)findViewById(R.id.addhtamount);
        pduedate= (EditText)findViewById(R.id.addhtdate);
        paddbtn= findViewById(R.id.addbtn);
        paddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qname= pname.getText().toString().trim();
                qnumber= pnumber.getText().toString().trim();
                qamount= pamount.getText().toString().trim();
                qduedate= pduedate.getText().toString().trim();


                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                String uniqueID = UUID.randomUUID().toString();
                DatabaseReference mRef =  database.getReference().child("property_tax").child(uniqueID);
                mRef.child("name").setValue(qname);
                mRef.child("number").setValue(qnumber);
                mRef.child("amount").setValue(qamount);
                mRef.child("duedate").setValue(qduedate);
                Toast.makeText(getApplicationContext(),"Added Successfully!",Toast.LENGTH_LONG).show();

            }
        });





    }



}