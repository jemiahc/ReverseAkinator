package com.example.jemiah.reverseakinator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int hidden;

    public void talk(View view){

        Toast.makeText(this, "Please stop touching me.", Toast.LENGTH_SHORT).show();

    }

    public void generateRandomNumber(){
        Random rand = new Random();
        hidden = rand.nextInt(100) + 1;
    }

    public void guess(View view){

        String message;
        EditText editText = findViewById(R.id.editText);

        if(editText.getText().toString().isEmpty()){
            message = "Please enter a number, idiot...";
        } else {
            int userGuess = Integer.parseInt(editText.getText().toString());

            if (userGuess > hidden)
                message = "Lower!";

            else if (userGuess < hidden)
                message = "Higher!";

            else
                message = "Yes, that's it! Again, again!";
                generateRandomNumber();
                Log.i("Info", Integer.toString(hidden));

        }

        editText.setText("");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
        Log.i("Secret_Number", Integer.toString(hidden));

    }
}
