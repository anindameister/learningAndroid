package com.anindamaulik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {


    EditText myEditText, myEditText2;
    EditText myEditText3;
    EditText myEditText5;

    TextView textName;

    Button button5;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button button4 = findViewById(R.id.button4);

        button4.setOnClickListener(this);
//
        button5 = findViewById(R.id.button5);

        button5.setOnClickListener(this);

        myEditText3 = findViewById(R.id.armstrongNumber);

        myEditText2 = findViewById(R.id.palindromeString);

        myEditText = findViewById(R.id.palindromeNumber);



        textName = findViewById(R.id.textName);




        myEditText5 = findViewById(R.id.myEditText5);

        myEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String input = myEditText.getText().toString();

                int intedInput = Integer.parseInt(input);


                String userInput2string = input;
                ArrayList<String> userInput2string2list = new ArrayList<String>();
                ArrayList<String> userInput2string2list2 = new ArrayList<String>();
                for (String retval : userInput2string.split("")) {

                    int retvalInted = Integer.parseInt(retval);
                    String stringedRetvalInted = Integer.toString(retvalInted);
                    userInput2string2list.add(stringedRetvalInted);

                }
                for (int j = userInput2string2list.size() - 1; j >= 0; j--) {
                    userInput2string2list2.add(userInput2string2list.get(j));


                }
                StringBuffer sb = new StringBuffer();
                for (String s : userInput2string2list2) {
                    sb.append(s);
                }
                String str = sb.toString();
                int IntedStr = Integer.parseInt(str);
                if (intedInput == IntedStr) {

                    Toast.makeText(getApplicationContext(), "input palindrome", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "input NOT palindrome", Toast.LENGTH_LONG).show();

                }


            }
        });
        myEditText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input2 = myEditText2.getText().toString();

                ArrayList<String> userInput2string2list = new ArrayList<String>();
                ArrayList<String> userInput2string2list2 = new ArrayList<String>();
                for (String retval : input2.split("")) {


                    userInput2string2list.add(retval);

                }
                for (int j = userInput2string2list.size() - 1; j >= 0; j--) {
                    userInput2string2list2.add(userInput2string2list.get(j));


                }
                StringBuffer sb = new StringBuffer();

                for (String s : userInput2string2list2) {
                    sb.append(s);
                }
                String str = sb.toString();


                if (input2.contentEquals(str) == true) {
                    Toast.makeText(getApplicationContext(), "input palindrome", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "input NOT palindrome", Toast.LENGTH_LONG).show();
                }
            }


        });

        myEditText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input3 = myEditText3.getText().toString();

                ArrayList<String> userInput2string2list = new ArrayList<String>();
                for (String retval : input3.split("")) {

                    int retvalInted = Integer.parseInt(retval);
                    int cubeddRetvalInted = retvalInted * retvalInted * retvalInted;
                    String stringedCubeddRetvalInted = Integer.toString(cubeddRetvalInted);


                    userInput2string2list.add(stringedCubeddRetvalInted);

                }
                int lengthUserInput = userInput2string2list.size();

                ArrayList<Integer> userInput2string2listInteger = new ArrayList<Integer>();
                int i;
                for (i = 0; i < lengthUserInput; i++) {
                    userInput2string2listInteger.add(Integer.parseInt(userInput2string2list.get(i)));


                }
                int sum = 0;
                for (int j = 0; j < userInput2string2listInteger.size(); j++) {
                    sum += userInput2string2listInteger.get(j);
                }

                int intedInput3 = Integer.parseInt(input3);
                if (intedInput3 == sum) {


                    Toast.makeText(getApplicationContext(), "congrats, you have chosen an armstrong number", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "you have chosen a NON-armstrong number", Toast.LENGTH_LONG).show();

                }


            }


        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button4:

                Toast.makeText(getApplicationContext(), "click2viewFibonacci", Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(i);


        }
        switch (view.getId()) {
            case R.id.button5:


                String userInput = myEditText5.getText().toString();
                double curr = Double.valueOf(userInput);
                Double euro_value = (curr * 88.27);
                String show = Double.toString(euro_value);
                textName.setText("The euro value is:" + show);
        }
    }
}


