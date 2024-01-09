package com.example.vehiclecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname,editType,editLocation,editDate;
    TextView btnReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.ename);
        editType = (EditText)findViewById(R.id.eType);
        editDate = (EditText)findViewById(R.id.edate);
        btnReserve = (TextView) findViewById(R.id.btnSaved);
        AddData();
    }

    public void AddData(){
        btnReserve = (TextView) findViewById(R.id.btnSaved);
        btnReserve.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtName = editname.getText().toString();
                String txtType = editType.getText().toString();
                String txtDate = editDate.getText().toString();

                boolean isInserted =  myDb.insertData(txtName,txtType,txtDate);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    editname.setText("");
                    editDate.setText("");
                    editType.setText("");

                }else{
                    Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}