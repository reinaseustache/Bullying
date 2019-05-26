package com.example.bullying;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TipsActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView mTextMessage;
    private TextView tipMessage;
    private static final String[] paths = {"I need help because...", "I feel hopeless.", "I am being bullied.", "Someone is acting differently."};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_main);

        spinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TipsActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
//                    mTextMessage.setText(R.string.title_home);
//                    setContentView(R.layout.home_main);
                    Intent intent = new Intent(TipsActivity.this, HomeActivity.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_tips: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(TipsActivity.this, TipsActivity.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_quotes: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(TipsActivity.this, Quotes.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_stories: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(TipsActivity.this, Stories.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        tipMessage = (TextView) findViewById(R.id.theTip);
        mTextMessage = (TextView) findViewById(R.id.theTip1);

        switch (position) {
            case 1:
                tipMessage.setTextSize(18f);
                tipMessage.setText(R.string.depressed);
                mTextMessage.setTextSize(18f);
                mTextMessage.setText(R.string.depressed2);
                break;
            case 2:
                tipMessage.setTextSize(18f);
                tipMessage.setText(R.string.bully);
                mTextMessage.setTextSize(18f);
                mTextMessage.setText(R.string.bully2);
                break;
            case 3:
                tipMessage.setTextSize(18f);
                tipMessage.setText(R.string.someone);
                mTextMessage.setTextSize(18f);
                mTextMessage.setText(R.string.someone2);
                break;

        }
    }

    public void onClick(View view)
    {
        int id = view.getId();

        switch(id)
        {
            case R.id.theTip:
                if (tipMessage.getText().equals(R.string.depressed)){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:18002738255"));
                    startActivity(intent);}
                break;
            case R.id.theTip1:
                if (tipMessage.getText().equals(R.string.depressed)){
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("plain/text");
                intent1.putExtra(Intent.EXTRA_EMAIL, new String[] { "example@email.address" });
                intent1.putExtra(Intent.EXTRA_SUBJECT, "");
                intent1.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent1, ""));}
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}