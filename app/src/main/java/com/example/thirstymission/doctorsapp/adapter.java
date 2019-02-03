package com.example.thirstymission.doctorsapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class adapter extends RecyclerView.Adapter<adapter.Programholder>{
    private  String[] name,age,gender;
    public adapter(String[] name,String[] age,String[] gender)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;

    }
    @NonNull
    @Override
    public Programholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.pateint,viewGroup,false);
        return new Programholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Programholder programholder, int i) {
        String name1=name[i];
        String age1=age[i];
        String gender1=gender[i];
        programholder.name.setText(name1);
        programholder.age.setText(age1);
        programholder.gender.setText(gender1);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class Programholder extends RecyclerView.ViewHolder{

        TextView name;
        TextView age;
        TextView gender;
        public Programholder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            age= itemView.findViewById(R.id.age);
            gender= itemView.findViewById(R.id.gender);


        }
    }

}