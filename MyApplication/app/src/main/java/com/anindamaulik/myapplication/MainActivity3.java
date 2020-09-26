package com.anindamaulik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button page_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        page_three =findViewById(R.id.button3);
        page_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Button to go to the next page of the resume", Toast.LENGTH_LONG).show();

                Intent j=new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(j);

            }
});
    }
}