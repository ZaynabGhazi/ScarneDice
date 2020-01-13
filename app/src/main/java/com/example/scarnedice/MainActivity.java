package com.example.scarnedice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button roll;
    private Button hold;
    private Button reset;
    private static int COMP_MIN = 20;
    //global vars:
    protected static int cTurnScore;
    protected static int cGlobScore;
    protected static int uTurnScore;
    protected static int uGlobScore;
    protected static boolean comp1=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll = findViewById(R.id.button2);
        roll.setOnClickListener(this);
        hold = findViewById(R.id.button);
        hold.setOnClickListener(this);
        reset = findViewById(R.id.button3);
        reset.setOnClickListener(this);
    }
    //Roll button:
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button2: {
                roll("user");
                break;
                }//end case_roll_button
            case R.id.button:{
                uTurnScore =0;
                TextView txt = (TextView) findViewById(R.id.textView);
                txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore);
                //computerTurn();
                delayRoll();
                break;
            }
            case R.id.button3:{
                uTurnScore=0;
                cTurnScore=0;
                uGlobScore=0;
                cGlobScore=0;
                TextView txt = (TextView) findViewById(R.id.textView);
                txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore);
                roll.setEnabled(true);
                hold.setEnabled(true);
                break;
            }//end_reset
            }//end_big_switch
        }//end_onClick
    private void roll(String player){
        int dieVal = (int)(Math.random()*6+1);
        switch(dieVal){
            case 1: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice1);
                if (player.equals("user")){
                    uGlobScore -= uTurnScore;
                    uTurnScore =0;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                    //computerTurn();
                    delayRoll();
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cGlobScore -= cTurnScore;
                    cTurnScore=0;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                    //userTurn:
                    roll.setEnabled(true);
                    hold.setEnabled(true);
                    txt.setText("Computer rolled a 1.Your turn!");
                    comp1=true;
                }
                break;
            }
            case 2: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice2);
                if (player.equals("user")){
                    uTurnScore +=2;
                    uGlobScore +=2;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cTurnScore+=2;
                    cGlobScore+=2;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                }
                break;
            }
            case 3: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice3);
                if (player.equals("user")){
                    uTurnScore +=3;
                    uGlobScore +=3;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cTurnScore+=3;
                    cGlobScore+=3;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                }
                break;
            }
            case 4: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice4);
                if (player.equals("user")){
                    uTurnScore +=2;
                    uGlobScore +=2;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cTurnScore+=4;
                    cGlobScore+=4;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                }
                break;
            }
            case 5: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice5);
                if (player.equals("user")){
                    uTurnScore +=2;
                    uGlobScore +=2;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cTurnScore+=5;
                    cGlobScore+=5;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                }
                break;
            }
            case 6: {
                ImageView img = (ImageView) findViewById(R.id.imageView2);
                img.setImageResource(R.drawable.dice6);
                if (player.equals("user")){
                    uTurnScore +=2;
                    uGlobScore +=2;
                    TextView txt = (TextView) findViewById(R.id.textView);
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Your turn score: "+uTurnScore);
                }
                if (player.equals("comp")){
                    TextView txt = (TextView) findViewById(R.id.textView);
                    cTurnScore+=6;
                    cGlobScore+=6;
                    txt.setText("Your score: "+uGlobScore+" Computer score: "+cGlobScore+" Computer turn score: "+cTurnScore);
                }
                break;
            }


        }//end_switch
        if (player.equals("comp")) {
            if (cTurnScore < COMP_MIN && !comp1) {
                roll("comp");
            } else comp1 = false;
        }
    }//end_roll
    public void computerTurn(){
        //disable roll and hold
        roll.setEnabled(false);
        hold.setEnabled(false);
       //do {
           roll("comp");

       //}while(cTurnScore < COMP_MIN && !comp1);
       if (!comp1) {
           TextView txt = (TextView) findViewById(R.id.textView);
           txt.setText("Computer chose to hold. Your turn!");
           roll.setEnabled(true);
           hold.setEnabled(true);
       }
       else{
           comp1 = false;
       }
    }
    //new function to delay:
    private void delayRoll(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                computerTurn();
            }
        }, 700);

    }


}
