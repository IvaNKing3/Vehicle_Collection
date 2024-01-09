package com.example.vehiclecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    RelativeLayout btnadd,btnview;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnadd = (RelativeLayout) findViewById(R.id.badd);
        btnview = (RelativeLayout) findViewById(R.id.vall);

        DB = new DatabaseHelper(this);
        Toast.makeText(Menu.this,"Login Successfully",Toast.LENGTH_LONG).show();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openReservation(); }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openCustomerData(); }
        });

    }

    public void openReservation (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openCustomerData (){
        Intent intent = new Intent(this, CollectionList.class);
        startActivity(intent);
    }

}