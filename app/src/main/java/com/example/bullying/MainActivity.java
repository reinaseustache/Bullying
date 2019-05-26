package com.example.bullying;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
   // Button myButton = (Button) findViewById(R.id.button);


    Button myButton;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       myButton = (Button)findViewById(R.id.button);
       myButton.setOnClickListener(this);
   }
    @Override
    public void onClick(View v) {
        switch(v.getId())

        {

            //The song category option
            case R.id.button:
                //Create the intent
               Intent intent = new Intent(this, Stories.class);
                startActivity(intent);
                break;
        }

    }
}