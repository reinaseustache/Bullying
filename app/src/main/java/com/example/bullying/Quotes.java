package com.example.bullying;

import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quotes extends Basic_Layout implements View.OnClickListener {



    //Create google docs

    //Get the text
    //Add text to it
    //Get the text from google docs
    //Store the intents into an array
    TextView TheTitle;
    TextView theText;
int iCurrentColor;
int iColorPos;
int iTextPos;
ImageButton forward ;
ImageButton back;
String[] sQuotes;

    List<Integer> lColors= new ArrayList<Integer>();



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
iColorPos =0;
iTextPos =0;

    theText = (TextView)findViewById(R.id.text);
forward = (ImageButton)findViewById(R.id.forward);
        back = (ImageButton)findViewById(R.id.back);

        forward.setOnClickListener(this);
        back.setOnClickListener(this);
    theText.setMovementMethod(new ScrollingMovementMethod());


iCurrentColor = R.color.blue;
lColors.add(iCurrentColor);


sQuotes = new String[]{"Bullying is never fun, it's a cruel and terrible thing to do to someone. If you are being bullied it is not your fault. No one deserves to be bullied, ever. -Raini Rodriguez",
        "Look at the sky. We are not alone. The whole universe is friendly to us and conspires only to give the best to those who dream and work. -A. P. J. Abdul Kalam ",
        "You can control two things: your work ethic and your attitude about anything.-Ali Krieger"
};

////Include sample stories that we will write and add


    theText.setText(sQuotes[0]);
    }
//

    public void ChangeColor() {
      int[] iPastels= new int[]{R.color.pink, R.color.yellow, R.color.blue, R.color.green,R.color.purple};

        int iPos = 0;
        //int[] iPastels= {R.color.pink, R.color.yellow, R.color.blue, R.color.green,R.color.purple};

        //ADD THE COLORS TO EACH OF THE BOTTUNS
        //The array of pastel colors
        //Random array so that  will choose four colors and color the boxes
int iIndex =0;

           //lLook for and find the current color and then set the new color as long as it is not equal
        while(iPastels[iIndex] != iCurrentColor) {
            if (iIndex == 4) {
                iIndex = 0;
            } else {
                //Generate a new index
                iIndex = iIndex + 1;
            }
        }
        if (iIndex == 4){
            iIndex = 0;//Resets the index
            iColorPos =iIndex;
            iCurrentColor = iPastels[iColorPos];
        }else{
            iIndex = iIndex + 1;
            iColorPos =iIndex;
            iCurrentColor = iPastels[iColorPos];

        }
        //Out of the while. Set the Text to the new color
        theText.setBackgroundResource(iPastels[iIndex]);
//TheTitle.setBackgroundResource(darkColors[iIndex]);
           }

           //Changes the text of the text button
           public void ChangeText(){
        String sText = "" + theText.getText();
        int iIndex =0;
        while(!sText.equals(sQuotes[iIndex])) {
            if (iIndex == 2) {
                iIndex = 0;
               // sText = sStories[iIndex];
            } else {
                iIndex = iIndex + 1;
                //sText = sStories[iIndex];
                //HANDLE IF IT GOES OUTSIDE THE ARRAY

            }
        }
        //NEED TO KNOW HOW MANY STORIES. MAYBE 7
               if(iIndex == 2){
                   iIndex =0;//Reset the value
                   iTextPos =iIndex;
               }else{
                   iIndex = iIndex +1;
                   iTextPos =iIndex;

               }
        theText.setText(sQuotes[iTextPos]);
        //Will find the index of the text and  will increment it to the next one
    }




    //To Go Back
    public void ColorTextPrev(){

       int[] iPastels= new int[]{R.color.pink, R.color.yellow, R.color.blue, R.color.green,R.color.purple};
      //  int[] iPastels= {R.color.pink, R.color.yellow, R.color.blue, R.color.green,R.color.purple};
int iPos = 0;
        //Uses the position of the color and text and sets the textbox back to it
        if(iTextPos ==0){
            iPos = 2;
        }else{
            iPos = iTextPos -1;
        }

        //Set the text to the prev text
        theText.setText(sQuotes[iPos]);


        //Change the value of textPos
        iTextPos = iPos;


        if(iColorPos ==0){
            iPos = 4;
        }else{
            iPos = iColorPos -1;
        }
        //Set the color to the prev color
        theText.setBackgroundResource(iPastels[iPos]);

        iColorPos = iPos;

    }


    @Override
    public void onClick(View v) {
        //Call on the change color and story when the person clicks the arrow
        switch (v.getId()) {
            case R.id.forward:
this.ChangeColor();
this.ChangeText();
                break;
            case R.id.back:
                this.ColorTextPrev();//Change Back to the old text
                    break;
        }

    }
}

//}
//
//
//        //Store the text for swiping

