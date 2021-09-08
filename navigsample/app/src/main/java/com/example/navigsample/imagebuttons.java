package com.example.navigsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class imagebuttons extends AppCompatActivity {
    ImageButton p,q,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagebuttons);
        p=(ImageButton)findViewById(R.id.imageView7);
        q=(ImageButton)findViewById(R.id.imageView8);
        r=(ImageButton)findViewById(R.id.imageView9);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(imagebuttons.this, housetax.class);
                startActivity(intent);

            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(imagebuttons.this, watertax.class);
                startActivity(intent);

            }
        });





    }

}
