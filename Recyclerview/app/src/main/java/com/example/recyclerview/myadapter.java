package com.example.recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class myadapter extends RecyclerView.Adapter<myadapter.MyDataViewHolder> {
    Context ct;
    String[] uname,urollno,uphone,umailid;
    public myadapter(MainActivity mainActivity, String[] names, String[] rollno, String[] phone, String[] mailid) {
        ct=mainActivity;
        uname=names;
        urollno=rollno;
        uphone=phone;
        umailid=mailid;
    }

    @NonNull
    @Override
    public myadapter.MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.design,parent,false);
        return new
                MyDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.MyDataViewHolder holder, int position) {
        holder.tv1.setText(uname[position]);
        holder.tv2.setText(urollno[position]);
        holder.tv3.setText(uphone[position]);
        holder.tv4.setText(umailid[position]);

    }

    @Override
    public int getItemCount() {
        return uname.length;
    }

    public class MyDataViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        public MyDataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.username);
            tv2=itemView.findViewById(R.id.userrollnumber);
            tv3=itemView.findViewById(R.id.userphone);
            tv4=itemView.findViewById(R.id.usermailid);
        }
    }
}

