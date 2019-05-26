package com.example.bullying;

import android.content.Intent;
import android.os.Bundle;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Basic_Layout extends AppCompatActivity implements View.OnTouchListener  {

        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;

    //Need to have an array of colors that the boxes will become

    //Need it to be scrollable
    //Need to read in text from a txt file of qoutes
    String sDirection = "";//The direction of the swipe

    String[] sStory;
    String[] sQuotes;
List<Intent> iTQoutes;
    List<Intent> iTStories;

    int iFound=0;
    List<Integer>iAddedcolors = new ArrayList<Integer>();
    //The textboxes
    TextView TopRightBox;
    TextView BottomRightBox;
    TextView  TopLeftBox;
    TextView BottomLeftBox;

    TextView[] textV;
    TextView[] newText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }


    }

