package com.example.thirstymission.doctorsapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Appointment extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        RecyclerView recycler= findViewById(R.id.recycle);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        String[] name={"Saurabh","love","your", "pubg","somil","shubg"};
        String[] age={"12","32","78", "09","89","80"};
        String[] gender={"M","M","F", "F","M","F"};
        recycler.setAdapter(new adapter(name,age,gender));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.addnew)
        {
            Intent intent = new Intent(getApplicationContext(),addnewmain.class);
            startActivity(intent);

            Toast.makeText(this, "ADD NEW", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.Delete)
        {
            Toast.makeText(this, "Delte", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}