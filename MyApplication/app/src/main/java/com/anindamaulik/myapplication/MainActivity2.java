package com.anindamaulik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button page_two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        page_two=(Button) findViewById(R.id.button2);
        page_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button to go to the next page of the resume", Toast.LENGTH_LONG).show();

                Intent j=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(j);



            }
        });
    }
}