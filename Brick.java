package com.example.jacobsa20.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by jacobsa20 on 3/27/2018.
 */

public class Brick {

    private int bStartX;
    private int bStartY;
    private int bEndX;
    private int bEndY;
    Paint brickCol= new Paint();

    public Brick(int initStartXb, int initStartYb, int initEndXb,
                      int initEndYb){
        bStartX=initStartXb;
        bStartY=initStartYb;
        bEndX=initEndXb;
        bEndY=initEndYb;
    }
    public void drawBrick(Canvas g){
        brickCol.setColor(Color.MAGENTA);
        g.drawRect(bStartX,bStartY,bEndX,bEndY,brickCol);
    }

    public int getbEndX() {return bEndX;}
    public int getbEndY() {return bEndY;}
    public int getbStartX() {return bStartX;}
    public int getbStartY() {return bStartY;}

    public void setbEndX(int bEndX) {this.bEndX = bEndX;}
    public void setbEndY(int bEndY) {this.bEndY = bEndY;}
    public void setbStartX(int bStartX) {this.bStartX = bStartX;}
    public void setbStartY(int bStartY) {this.bStartY = bStartY;}
}
