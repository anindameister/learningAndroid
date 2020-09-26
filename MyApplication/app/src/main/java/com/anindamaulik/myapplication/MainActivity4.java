package com.anindamaulik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    EditText myEditText;
    EditText MyEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        myEditText = findViewById(R.id.palindromeNumber);

        myEditText.setOnClickListener(new View.OnClickListener() {
            //            https://stackoverflow.com/questions/34665564/how-to-retrieve-user-input-in-android
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

    }
}

