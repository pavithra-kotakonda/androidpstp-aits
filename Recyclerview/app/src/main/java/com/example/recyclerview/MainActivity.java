package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    String[] names={"sai","pavithra","bhanu","sasi","keerthi"};
    String[] rollno={"576","577","578","579","580"};
    String[] phone={"7659876436","8520821955","9014301255","8297677989","9767898976"};
    String[] mailid={"sasi75342","pavithra123","chinni576","sasi123","keerthi123"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new myadapter(this,names, rollno,phone,mailid));
    }
}
