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
 * than sorry!)
 */

public class PongGame implements Animator {

    // instance variables
    private boolean backwardsx = false; // whether clock is ticking backwards
    Random rand = new Random();
    int rColor=rand.nextInt(256);
    int gColor=rand.nextInt(256);
    int bColor=rand.nextInt(256);
    int speed= rand.nextInt(15);
    int midPaddle=500;// midpoint of paddle
    int midPaddleAI= 500;// midpoint of AI paddle
    int midPadToEnd=100;//distance from middle of paddle to edge


    ArrayList<Ball>allBalls= new ArrayList<>();
    Paddle paddleAI= new Paddle(30,midPaddle-midPadToEnd,40,
            midPaddle+midPadToEnd);

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

        Paint wall= new Paint();
        wall.setColor(Color.WHITE);
        //I hard coded the sizes of the walls because I wanted the game to be
        //smaller than the height of the screen
        g.drawRect(0f,0f,1770f,30f,wall);
        g.drawRect(30f,midPaddle-100,40f,midPaddle+100,wall);
        g.drawRect(0f,970f,1770f,1000f,wall);
        //paddle
        wall.setColor(Color.MAGENTA);
        g.drawRect(1750f,midPaddle-100,1760f,midPaddle+100,wall);

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
            if(ySpot>970 || ySpot<30){i.changeyBackwards();}
            if(xSpot<50){if (ySpot>midPaddleAI-midPadToEnd &&
                    ySpot<midPaddleAI+midPadToEnd){i.changexBackwards();}}
            if(xSpot>1740){if(ySpot>midPaddle-midPadToEnd &&
                    ySpot<midPaddle+midPadToEnd){i.changexBackwards();}}
            if(xSpot>1760){i.randCount(rand.nextInt(15)+5,
                    rand.nextInt(15)+5);
            }
            if(midPaddleAI<ySpot){paddleAI.getSpeed(20);}
            else if(midPaddleAI>ySpot){
                paddleAI.getSpeed(-20);
            }
        }
        //draws the balls
        for(Ball i: allBalls){
            wall.setColor(rgb(rColor,gColor,bColor));
            g.drawCircle(i.getxPos(), i.getyPos(), 20, wall);
        }

    }

    /**
     * EXTERNAL CITATION
     * Date: 3/28/2018
     * Problem: I couldn't get the paddle to move and still enforce
     * the bouncing off rule
     * Resource: Chris Fishback
     * Solution: He informed me of https://developer.android.com/training/
     * gestures/movement.html where I copied the code present
     */
    @Override
    public void onTouch(MotionEvent event) {
        //ability to move paddle
        int pos=event.getActionMasked();
        switch(pos) {
            case MotionEvent.ACTION_DOWN:
                midPaddle = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                midPaddle = (int) event.getY();
                break;
        }

    }
}