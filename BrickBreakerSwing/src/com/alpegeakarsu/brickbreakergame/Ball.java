
package com.alpegeakarsu.brickbreakergame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    public static int ballCoordinateX;
    public static int ballCoordinateY;
    public static int ballDirectionX;
    public static int ballDirectionY;

    public Ball(int ballCoordinateX,int ballCoordinateY,int ballDirectionX,int ballDirectionY) {
        this.ballCoordinateX = ballCoordinateX;
        this.ballCoordinateY = ballCoordinateY;
        this.ballDirectionX = ballDirectionX;
        this.ballDirectionY = ballDirectionY;
    
    
    }
    
    public void paint(Graphics g){
    g.setColor(Color.yellow);
    g.fillOval(ballCoordinateX, ballCoordinateY, 20, 20);
    
    }

    
    
}
