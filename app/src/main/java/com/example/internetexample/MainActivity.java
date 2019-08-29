package com.example.internetexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendInfo(View v){
        //getting references for text fields
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        String myNameStr = editText1.getText().toString();
        String myAgeStr = editText2.getText().toString();

        Intent intent = new Intent(this, InfoActivity.class);

        intent.putExtra(InfoActivity.MY_NAME, myNameStr);
        intent.putExtra(InfoActivity.MY_AGE, myAgeStr);

        startActivity(intent);
    }

    public void shareinfo(View v){
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        String myNameStr = editText1.getText().toString();
        String myAgeStr = editText2.getText().toString();
        String myMessage = "My name is " + myNameStr + " and I am " + myAgeStr + " years old";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, myMessage);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);

    }
}
