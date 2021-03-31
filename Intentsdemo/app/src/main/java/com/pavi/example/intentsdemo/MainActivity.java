
package com.pavi.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button explicit;


    protected void onCreate(Bundle savedInstanceState, View explicit) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explicit=findViewById(R.id.v1);

        explicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,second.class);
                startActivity(i1);

            }


        });



    }

    public void browser(View view) {
        Uri uri=Uri.parse("https://classroom.google.com/");

        Intent i2=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i2);
    }
}