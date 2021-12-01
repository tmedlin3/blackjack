package com.example.craps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;



import java.text.BreakIterator;
import java.util.Random;
/*
Ryan Medlin
Klarelle Kanyama
 */
public class MainActivity<housePoints> extends AppCompatActivity {
    public Button button;
    ImageView user, house, user1, house1;

    TextView userscore, housescore, bet, avail;

    Random r;

    EditText editText;
    /* creating the integers that i will be using and animation */
    int rollCounter = 0;
    int userPoints = 0 , housePoints = 0;
    int userPoints1 = 0, housePoints1 = 0;
    int counter = 0, counter1 = 0;
    int totalcount = 0;
    int pointtowin = 0;
    int pointtowin1 =0;
    int betammount =5;
    int total = 0;
    int userpoints;
    int housepoints;
    int totalHouse;

    Animation animation;
    @Override
    /*setting up the text view and image view */
    protected void onStart() {
        super.onStart();
        TextView avail1 = (TextView) findViewById(R.id.avail);
        avail1.setText("place a bet you have $" + total + " remaing");
    }
    protected void onCreate(Bundle savedInstanceState)
    {

       /*editText = (EditText) findViewById(R.id.editText);
        editText.setText(getIntent().getStringExtra("et"));
        Bundle values = getIntent().getExtras();*/
        String totals = getIntent().getStringExtra("et");

        try{

            int total1 = Integer.parseInt(totals);
            total = total1;


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        avail = (TextView) findViewById(R.id.avail);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (ImageView) findViewById(R.id.user);
        house = (ImageView) findViewById(R.id.house);
        user1 = (ImageView) findViewById(R.id.user1);
        house1 = (ImageView) findViewById(R.id.house1);
        Button rolls = (Button) findViewById(R.id.roll);
        userscore = (TextView) findViewById(R.id.userscore);
        housescore = (TextView) findViewById(R.id.housescore);


        button = (Button) findViewById(R.id.bttn);
        button.setOnClickListener(new View.OnClickListener() {

            //Resets variable values to default and returns to home screen
            @Override
            public void onClick(View view) {
                housepoints = 0;
                housescore.setText("House: " + housepoints);
                userpoints = 0;
                userscore.setText("User: " + userpoints);
                avail.setText("You have $" + total + " available");
                Intent intent=new Intent (MainActivity.this,Home.class);
                startActivity(intent);
                String value = button.getText().toString();

            }
        });

        r = new Random();

        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        /* implementing rolling with dice getting a random number and the dice pictures changing */
        rolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card1 = r.nextInt(13) + 1;
                int card2 = r.nextInt(13) + 1;
                int card3 = r.nextInt(13)+1;
                int card4 = r.nextInt(13)+1;

                setCard(card1, user);
                setCard(card2, user1);
                setCard(card3, house);
                setCard(card4, house1);
                totalHouse =  card3 + card4;
                totalcount = card1 + card2;
                rollCounter++;
                if (total > 0) {
                    /* sereis of ifs that make the logic of the games work */
                    if (rollCounter > 1) {

                    userscore.setText(totalcount + " score");
                    housescore.setText(totalHouse + " score");
                    }
                    if (rollCounter == 1) {




                        rollCounter++;
                    }


                }

                if (total == 0) {
                    TextView avail1 = (TextView) findViewById(R.id.avail);
                    avail1.setText("Sorry you have no more money left please deposit more to keep playing");
                }

            }
        });


    }
    public void incBet(View view){
        if(betammount > total){
            Toast.makeText(MainActivity.this, " Sorry but that is too big of a bet", Toast.LENGTH_SHORT).show();
        }
        if(betammount < total){
            betammount = betammount + 5;


            TextView betammount1 = (TextView) findViewById(R.id.bet);
            betammount1.setText("$"+betammount);
        }

    }
    public void decBet(View view){
        if(5 <= betammount && betammount <= total){
            betammount = betammount - 5;


            TextView betammount1 = (TextView) findViewById(R.id.bet);
            betammount1.setText("$"+betammount);

        }
        if(betammount > total){
            Toast.makeText(MainActivity.this, "You don't have enough", Toast.LENGTH_SHORT).show();

        }
        if(betammount < 5){
            Toast.makeText(MainActivity.this, "You cannot bet an amount less than 5.", Toast.LENGTH_SHORT).show();

        }

    }
    /*setting the images for the first dice to show the one i marked */
    public void setCard(int num, ImageView cardName){
        switch(num){
            case 1:
                cardName.setImageResource(R.drawable.c1);
                cardName.startAnimation(animation);
                counter=1;
                break;
            case 2:
                cardName.setImageResource(R.drawable.c2);
                cardName.startAnimation(animation);
                counter=2;
                break;
            case 3:
                cardName.setImageResource(R.drawable.c3);
                cardName.startAnimation(animation);
                counter = 3;
                break;
            case 4:
                cardName.setImageResource(R.drawable.c4);
                cardName.startAnimation(animation);
                counter = 4;
                break;
            case 5:
                cardName.setImageResource(R.drawable.c5);
                cardName.startAnimation(animation);
                counter = 5;
                break;
            case 6:
                cardName.setImageResource(R.drawable.c6);
                cardName.startAnimation(animation);
                counter = 6;
                break;
            case 7:
                cardName.setImageResource(R.drawable.c7);
                cardName.startAnimation(animation);
                counter = 7;
                break;
            case 8:
                cardName.setImageResource(R.drawable.c8);
                cardName.startAnimation(animation);
                counter = 8;
                break;
            case 9:
                cardName.setImageResource(R.drawable.c9);
                cardName.startAnimation(animation);
                counter = 9;
                break;
            case 10:
                cardName.setImageResource(R.drawable.c10);
                cardName.startAnimation(animation);
                counter = 10;
                break;
            case 11:
                cardName.setImageResource(R.drawable.c11);
                cardName.startAnimation(animation);
                counter = 10;
                break;
            case 12:
                cardName.setImageResource(R.drawable.c12);
                cardName.startAnimation(animation);
                counter = 10;
                break;
            case 13:
                cardName.setImageResource(R.drawable.c13);
                cardName.startAnimation(animation);
                counter = 10;
                break;
            case 14:
                cardName.setImageResource(R.drawable.c1);
                cardName.startAnimation(animation);
                counter = 11;
                break;
        }
    }


    /* setting up the image for dice 2 */
    public void setImagedice2(int num, int card){
        switch(num){
            case 1:
                user1.setImageResource(R.drawable.c1);
                user.startAnimation(animation);
                counter=1;
                break;
            case 2:
                user1.setImageResource(R.drawable.c2);
                user.startAnimation(animation);
                counter=2;
                break;
            case 3:
                user.setImageResource(R.drawable.c3);
                user.startAnimation(animation);
                counter = 3;
                break;
            case 4:
                user.setImageResource(R.drawable.c4);
                user.startAnimation(animation);
                counter = 4;
                break;
            case 5:
                user.setImageResource(R.drawable.c5);
                user.startAnimation(animation);
                counter = 5;
                break;
            case 6:
                user.setImageResource(R.drawable.c6);
                user.startAnimation(animation);
                counter = 6;
                break;
            case 7:
                user.setImageResource(R.drawable.c7);
                user.startAnimation(animation);
                counter = 7;
                break;
            case 8:
                user.setImageResource(R.drawable.c8);
                user.startAnimation(animation);
                counter = 8;
                break;
            case 9:
                user.setImageResource(R.drawable.c9);
                user.startAnimation(animation);
                counter = 9;
                break;
            case 10:
                user.setImageResource(R.drawable.c10);
                user.startAnimation(animation);
                counter = 10;
                break;
            case 11:
                user.setImageResource(R.drawable.c11);
                user.startAnimation(animation);
                counter = 10;
                break;
            case 12:
                user.setImageResource(R.drawable.c12);
                user.startAnimation(animation);
                counter = 10;
                break;
            case 13:
                user.setImageResource(R.drawable.c13);
                user.startAnimation(animation);
                counter = 10;
                break;
            case 14:
                user.setImageResource(R.drawable.c1);
                user.startAnimation(animation);
                counter = 11;
                break;
        }
    }
}