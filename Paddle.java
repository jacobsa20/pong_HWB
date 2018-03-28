package com.example.jacobsa20.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by jacobsa20 on 3/27/2018.
 */

public class Paddle {

    private int pStartX;
    private int pStartY;
    private int pEndX;
    private int pEndY;
    Paint padCol= new Paint();

    public Paddle(int initStartXp, int initStartYp, int initEndXp,
                       int initEndYp, int initMid, int initMTE) {

        initStartXp = pStartX;
        initStartYp = pStartY;
        initEndXp = pEndX;
        initEndYp = pEndY;
        initMid = (pEndY-pStartY)/2;
        initMTE = initMid-pStartY;
    }
    public boolean paddleMove(){

        return false;
    }
    public void drawPaddle(Canvas g){
        padCol.setColor(Color.CYAN);
        g.drawRect(pStartX,pStartY,pEndX,pEndY,padCol);
    }

    public int getEndX() {return pEndX;}
    public int getEndY() {return pEndY;}
    public int getStartX() {return pStartX;}
    public int getStartY() {return pStartY;}

    public void setEndX(int endX) {this.pEndX = endX;}
    public void setEndY(int endY) {this.pEndY = endY;}
    public void setStartX(int startX) {this.pStartX = startX;}
    public void setStartY(int startY) {this.pStartY = startY;}
}
