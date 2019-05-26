package com.example.bullying;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class Stories extends  Basic_Layout implements View.OnClickListener {
public class Stories extends  Basic_Layout implements View.OnClickListener {


//    ///This will read the qoutes from a txt file and add it to the buttons

    TextView Title ;
    TextView theText;
    String[] sStories = new String[20];//Modify that later
    int iTextPos;
    ImageButton forward;
    ImageButton back;
    int iPos =0;
    ImageButton add;
    ImageButton eraser ;
    Button addStory;
    EditText comment;
    String[] sComments;
    int iCommentAmount=0;
    boolean bComments;

    protected void onCreate(Bundle savedInstanceState) {
        iPos =0;
        bComments =true;
        super.onCreate(savedInstanceState);
sComments = new String[]{"This helped me so much!", "This made me cry","I hate bullying"};
        setContentView(R.layout.basic_layout);
forward = (ImageButton)findViewById(R.id.forward);
back =(ImageButton)findViewById(R.id.back);
forward.setOnClickListener(this);
back.setOnClickListener(this);
theText = (TextView) findViewById(R.id.text);
theText.setMovementMethod(new ScrollingMovementMethod());
comment =(EditText)findViewById(R.id.comment);
comment.setOnClickListener(this);
comment.setEnabled(false);
add=(ImageButton)findViewById(R.id.add);//chalk
        eraser=(ImageButton)findViewById(R.id.eraser);
        addStory =(Button)findViewById(R.id.addStory) ;//Button

        add.setOnClickListener(this);
        eraser.setOnClickListener(this);
        addStory.setOnClickListener(this);


        iTextPos =0;
        sStories = new String[]{
"In my first year of middle school, kids taunted me and spit on me in hallways. It didn’t occur to me to tell my parents or teachers. Finally, when a group of 20 kids threatened to beat me up at the carwash the next day, I told my older brother, who in turn informed my parents. My dad looked up my main tormentor’s phone number in the phone book and told her dad to make his daughter stop or he’d contact the police. It worked.",
                "When I was in elementary school, I was a very happy and outgoing kid and had lots of friends. But when I started secondary school, some older kids started to bully and tease me. All my friends from elementary school left me because they didn’t want to be seen with me. At my school, everything was all about money and clothes. I had huge glasses and I was really ugly and everyone laughed at me. Then a boy (he was in 8th grade I think) started to follow me around. He called me names, took my stuff and made up rumors about me. One day he and his friends beat me up on the bus. No one wanted to be friends with me anymore. The n I became friends with two girls in my class. They started making up rumors about me. Everyone kept telling me what a bad person I was. In 6th grade, the bullying got even worse. Everyone said I was ugly and I should just kill myself. In 7th grade my mom made me attend afternoon classes (full-time school was voluntary at my school). The kids in afternoon class started bullying me, too. They followed me around and took photos of me in the bathroom to send them to the whole school. When I got home from school, I would go to my room and cry all evening. I never talked to anyone. My grades dropped and my teachers started to talk to my parents. They told them I was lazy and refused to participate. They knew I was bullied but they never did anything to stop it. Everyone hated me and I didn’t have a single friend. I just want to tell everyone who is going through the same: It gets better. I know it’s really hard, and you might feel like giving up sometimes, but you have to be yourself and stay confident. Don’t let them get to you. I know you’re suffering, but at some point you’ll be proud of yourself for all that you’ve been through. And if anyone judges you, it is their own problem. Those people have no idea what you’ve been through. They probably couldn’t even take it. But you had to take it. And you’re still here going on with your life.And that’s why you can be proud of yourself."
        };
        theText.setText(sStories[0]);

    }

    //Changes the text of the text button
    public void ChangeText(){
        int i =0;
        //Clear out the text
        while(sStories[i].equals("")||(sStories!= null)){
            i=i+1;
        }

        //Use
        theText.setText(sStories[iPos]);
        if((iPos>0)&&(iPos<i)){
            iPos =iPos = iPos+1;
        }if(iPos==i){
            iPos=0;
        }
    }


    //To Go Back
    public void TextPrev(){
        int i =0;
        //Clear out the text
        while(sStories[i].equals("")||(sStories!= null)){
            i=i+1;
        }
        if(iPos == 0){
            iPos =i;
            theText.setText(sStories[iPos]);
        }
        else{
            iPos=i-1;
            theText.setText(sStories[iPos]);
        }
    }


    @Override
    public void onClick(View v) {
        //Call on the change color and story when the person clicks the arrow
        switch (v.getId()) {
            case R.id.forward:
                this.ChangeText();
                break;
            case R.id.back:
                this.TextPrev();//Change Back to the old text
                break;


            case R.id.addStory: //button
comment.setEnabled(false);
//Display you story
                int k=0;
                //Clear out the text
                while(sStories[k].equals("")||(sStories!= null)){
                    k=k+1;
                }
theText.setText(sStories[k]);

                break;
            case R.id.add://plus
                addStory.setVisibility(View.VISIBLE);
                theText.setText("");
                comment.setEnabled(true);
                int i =0;
                //Clear out the text
                while(sStories[i].equals("")||(sStories!= null)){
                    i=i+1;
                }

                //Use the i index to add to the array
                sStories[i]=""+comment.getText();
                theText.setText(sStories[i]);
                addStory.setVisibility(View.VISIBLE);

                break;


            case R.id.eraser://Add a comment
                if(bComments) {
                    theText.setText("");//Get rid of the text
                    String sComment = new String();
                    //Make it edible
                    for (int j = 0; j < sComments.length; j++) {
                        sComment += sComments[j] + "/n";
                    }
                    comment.setText(sComment);
                    bComments = false;
                }else{
                    //Display the stories
                    theText.setText(sStories[0]);
                }
                break;
        }

    }
}

//}
//
//
//        //Store the text for swiping

