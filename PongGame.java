package com.example.jacobsa20.pong;

import android.graphics.*;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.jacobsa20.animation.Animator;

import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.rgb;

/**
 * Created by jacobsa20 on 3/19/2018.
 **/

/**
 * EXTERNAL CITATION
 * Date: 3/19/2018
 * Problem: needed help getting started on PongGame class
 * Because I'm supposed to delete the testAnimator class
 * Resource: TestAnimator code by Nux and Vegdahl.
 * Solution: I used the code present
 * (I don't know if this is citation worthy, but better safe
 * than sorry!!)
 */

public class PongGame implements Animator {

    // instance variables
    private int xnums;
    private int ynums;
    private boolean backwardsx = false; // whether clock is ticking backwards
    private boolean backwardsy= false;
    Random rand = new Random();
    int speed= rand.nextInt(15);

    ArrayList<Ball>allBalls= new ArrayList<>();

    @Override
    public int interval() {
        return 0;
    }

    @Override
    public int backgroundColor() {
        //makes background color black
        return Color.BLACK;
    }
    public void goBackwards(boolean b) {
        // set the instance variable
        backwardsx = b;
    }

    @Override
    public boolean doPause() {//don't care about this
        return false;
    }

    @Override
    public boolean doQuit() {//don't care about this
        return false;
    }

    @Override
    public void tick(Canvas g){//draws walls, ball, and controls motion of ball
        //puts ball on screen
        if(allBalls.isEmpty()){
            allBalls.add(new Ball(rand.nextInt(15)+5,rand.nextInt(15)+5,speed,
                    rand.nextBoolean(),rand.nextBoolean()));
        }

      //  int j= rand.nextInt(1000);
        Paint wall= new Paint();
        wall.setColor(Color.WHITE);
        //I hard coded the sizes of the walls because I wanted the game to be
        //smaller than the height of the screen
        g.drawRect(0f,0f,1770f,30f,wall);
        g.drawRect(0f,0f,30f,1000f,wall);
        g.drawRect(0f,970f,1770f,1000f,wall);
        //paddle
        g.drawRect(1750f,400f,1760f,600f,wall);

        //changing direction of ball
        for(Ball i: allBalls){
            if(i.isxBackwards()){i.subxCount();}
            else{i.addxCount();}
            if(i.isyBackwards()){i.subyCount();}
            else{i.addyCount();}
        }
        //sets positions of balls
        for(Ball i: allBalls){
            int xSpot=(i.getxCount()*i.getSpeed());
            int ySpot=(i.getyCount()*i.getSpeed());
            if(xSpot>10 && xSpot<=1760 && ySpot>10 && ySpot<=1010){}
            else{i.randCount(rand.nextInt(15)+5, rand.nextInt(15)+5);}
            i.setxPos(xSpot);
            i.setyPos(ySpot);
            //ensures balls bounce off walls
            if(ySpot>1000 || ySpot<30){i.changeyBackwards();}
            if(xSpot<30){i.changexBackwards();}
            if(xSpot>1740){if(ySpot>400 && ySpot<600){i.changexBackwards();}}
            if(xSpot>1760){i.randCount(rand.nextInt(15)+5,
                    rand.nextInt(15)+5);
            }
        }
        //draws the balls
        for(Ball i: allBalls){
            wall.setColor(rgb(255, 122, 186));
            g.drawCircle(i.getxPos(), i.getyPos(), 20, wall);
        }

    }

    @Override
    public void onTouch(MotionEvent event) {
        //when user clicks mouse or touches tablet a new ball is drawn
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            allBalls.add(new Ball(rand.nextInt(15)+5,rand.nextInt(15)+5,
                    rand.nextInt(15)+5,rand.nextBoolean(),
                    rand.nextBoolean()));
        }

    }
}

