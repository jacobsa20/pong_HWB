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

    private double initMid;//middle of paddle
    private double initMTE;//middle to either end of paddle

    private int speed;

    public Paddle(int initStartX, int initStartY, int initEndX,
                       int initEndY) {

        pStartX=initStartX;
        pStartY=initStartY;
        pEndX=initEndX;
        pEndY=initEndY;
        initMid = (pEndY-pStartY)/2;
        initMTE = initMid-pStartY;
    }

    public boolean paddleMove(){
        return false;
    }

    public void newPos(int pos){
        initMid= pos;
        pStartY=pos-(int) initMTE;
        pEndY= pos+(int) initMTE;
    }

    //getters and setters
    public int getEndX() {return pEndX;}
    public int getEndY() {return pEndY;}
    public int getStartX() {return pStartX;}
    public int getStartY() {return pStartY;}
    public double getInitMid(){return initMid;}
    public double getInitMTE() {return initMTE;}
    public int getSpeed() {return speed;}

    public void setEndX(int endX) {this.pEndX = endX;}
    public void setEndY(int endY) {this.pEndY = endY;}
    public void setStartX(int startX) {this.pStartX = startX;}
    public void setStartY(int startY) {this.pStartY = startY;}
}
