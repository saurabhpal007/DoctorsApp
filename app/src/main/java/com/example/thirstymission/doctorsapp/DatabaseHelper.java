package com.example.thirstymission.doctorsapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String  DATA_BASE = "patient.db";
    public static final String TABLE_NAME = "patient_table";
    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "AGE";
    public static final String col4 = "GENDER";




    public DatabaseHelper(Context context) {
        super(context, DATA_BASE , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public boolean save1(Custom custom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col2,custom.getName());
        values.put(col3,custom.getage());
        long result=db.insert(TABLE_NAME,null,values);
        if(result==-1)
            return false;

        else
            return true;



    }
    public Custom findOne(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, new String[]{col1,col2,col3},
                col1+"=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new Custom(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
    }

}
