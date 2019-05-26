package com.example.bullying;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.view.MenuItem;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] arr= {R.drawable.fighting,R.drawable.hands,R.drawable.fence,R.drawable.help};
    private ArrayList<Integer> theArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
//                    mTextMessage.setText(R.string.title_home);
//                    setContentView(R.layout.home_main);
                    Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                }
                case R.id.navigation_tips:
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(HomeActivity.this, TipsActivity.class);
                    //start the new activity
                    startActivity(intent);
                    return true;
                case R.id.navigation_quotes:
                    //mTextMessage.setText(R.string.title_tips);
                    return true;
                case R.id.navigation_stories:
                    //mTextMessage.setText(R.string.title_tips);
                    return true;
            }
            return false;
        }
    };

    private void init() {
        for(int i = 0;i<arr.length;i++)
            theArray.add(arr[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(HomeActivity.this,theArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == arr.length){
                    currentPage = 0;
                    mPager = (ViewPager) findViewById(R.id.pager);
                    mPager.setAdapter(new MyAdapter(HomeActivity.this,theArray)); }

                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

}
