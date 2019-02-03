package com.example.thirstymission.doctorsapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class addnewmain extends AppCompatActivity {
     DatabaseHelper mydb;
     EditText name,age,gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew);
        mydb=new DatabaseHelper(this);
        name=findViewById(R.id.nam);
        age=findViewById(R.id.ag);
        gender=findViewById(R.id.gen);


    }
    public void save(View view)
    {
        boolean isinserted= mydb.save1(new Custom("saurabh","12"));
        if(isinserted=true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Not Inserted", Toast.LENGTH_SHORT).show();

    }

    public void view(View view)
    {
        Cursor res = mydb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Name :"+ res.getString(1)+"\n");
            buffer.append("Surname :"+ res.getString(2)+"\n");

        }

        // Show all data
        showMessage("Data",buffer.toString());

    }









    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}


