package com.example.navigsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class removehousetax extends AppCompatActivity {
    EditText num;
    Button rem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removehousetax);
        num= (EditText)findViewById(R.id.rnum);
        rem= (Button)findViewById(R.id.rht);
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeht();

            }
        });
    }
    private void removeht() {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference().child("property_tax");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef = database.getReference().child("property_tax");
        ValueEventListener valueEventListener = databaseRef.addValueEventListener((new ValueEventListener() {
            private static final String TAG = "";

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    users mCategory = postSnapshot.getValue(users.class);
                    String mnumber = mCategory.getNumber();
                    mCategory.setRemoveValue("yes");


                    if ((num.toString().trim()).equals(mnumber))
                    {

                        mRef.child("remove").setValue(mCategory);

                        Toast.makeText(getApplicationContext(), "Removed Successfully!", Toast.LENGTH_LONG).show();


                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Not Removed Successfully!", Toast.LENGTH_LONG).show();


                    }


                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        }));
    }







}
