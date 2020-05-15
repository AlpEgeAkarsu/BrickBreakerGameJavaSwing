
package com.alpegeakarsu.brickbreakergame;

/* IMPORTS */
import java.awt.Color;
import java.awt.Graphics;
/* IMPORTS */

public class Paddle {
   /* ATTRIBUTES */
    public static int paddleX;
    
    /* ATTRIBUTES */
    
    /* CONSTRUCTOR */
    public Paddle(int paddleX){
        Paddle.paddleX = paddleX;
    }
    /* CONSTRUCTOR */
    
    public void paint(Graphics g){
     g.setColor(Color.green);
    g.fillRect(paddleX, 550, 100, 8);
    
        
    }
    public void moveRight(){
       if(Variables.level == 0){
    	   Variables.isPlaying = true;
           paddleX += 20;
       }
       else if(Variables.level == 1){
    	   Variables.isPlaying = true;
           paddleX += 30;
       }
       else if(Variables.level == 2){
    	   Variables.isPlaying = true;
           paddleX += 40;
       }
       else if(Variables.level == 3){
    	   Variables.isPlaying = true;
           paddleX += 60;
       }
       else {}
    }
    public void moveLeft(){
       if(Variables.level == 0){
    	   Variables.isPlaying = true;
           paddleX -= 20;
       }
       if(Variables.level == 1){
    	   Variables.isPlaying = true;
           paddleX -= 30;
       }
       if(Variables.level == 2){
    	   Variables.isPlaying = true;
           paddleX -= 40;
       }
        if(Variables.level == 3){
        	Variables.isPlaying = true;
           paddleX -= 60;
       }
       
    }





}
