package com.anindamaulik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

//    https://abhiandroid.com/ui/textview

    TextView myEdit_text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        myEdit_text4 = findViewById(R.id.FibonacciView);
        Log.d("========","00000000");




                int num1 = 0;
                int num2 = 1;

                int range = 10;
                Log.d("!!!!!!!!!!!!!!","1111111111111111111");

                for (int i = 0; i < range; i++) {

                    Log.d("$$$$$$$$$$$$$","3333333333333333333");

//                    myEdit_text4.setText(Integer.toString(num1)+"\n");
                    StringBuffer sb = new StringBuffer();
                    String stringedNum1 = Integer.toString(num1);
                    ArrayList<String> stringedNum1TOlist =new ArrayList<String>();
                    stringedNum1TOlist.add(stringedNum1);



                    for (String s : stringedNum1TOlist) {
                        sb.append(s);

                    }
                    String str = sb.toString();
                    myEdit_text4.setText(str);
                    Log.d("##########","2222222222222222");
                    int num3 = num1 + num2;
                    num1 = num2;
                    num2 = num3;
                }


            }

    }
