package com.example.bullying;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
//                    mTextMessage.setText(R.string.title_home);
//                    setContentView(R.layout.home_main);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_tips: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(MainActivity.this, TipsActivity.class);
                    //start the new activity
                    startActivity(intent);
                }
                    return true;
                case R.id.navigation_quotes: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(MainActivity.this, Quotes.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_stories: {
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(MainActivity.this, Stories.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        //setContentView(R.layout.home_activity);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
