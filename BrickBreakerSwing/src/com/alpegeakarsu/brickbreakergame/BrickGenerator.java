
package com.alpegeakarsu.brickbreakergame;

/* IMPORTS */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
/* IMPORTS */

public class BrickGenerator {
   /* ATTRIBUTES */
    public int map[][]; 
    public int brickWidth;
    public int brickHeight;
    public int count[][];
    Variables variable;
    /* ATTRIBUTES */
    
    public BrickGenerator(int row,int column){
        map = new int[row][column];         // Create a matrix 
        count = new int[row][column];        // Create a new matrix for the check
        for(int i=0; i< map.length; i++){ // map.length = 3 so i will turn 3 times
        
            for(int j=0; j< map[0].length; j++){ //  map[0].length =  7.
                map[i][j] = 1;
                count[i][j] = 1;    // fill all the rows and columns 1 to .
            }
        
        }
        brickWidth = 540/column; // 540/7 = 77 brickWidth = 77
        brickHeight = 150/row;  // 150/3 = 50 brickHeight = 50
    
    }
    
    public void draw(Graphics2D g){
      for(int i=0; i< map.length; i++){ // 3 kere dönecek
        
            for(int j=0; j< map[0].length; j++){  // 7 kere donecek
                if(map[i][j]>0){ // top did not intersects yet
               if(j % 2 == 0) {
                       g.setColor(Color.blue);
                    }else g.setColor(Color.white);   // this means box's color
                g.fillRect(j*brickWidth+80,i*brickHeight + 50 , brickWidth, brickHeight);
                 g.setStroke(new BasicStroke(3)); // Space between bricks
            g.setColor(Color.black); // colors between bricks
            g.drawRect(j*brickWidth+80,i*brickHeight + 50 , brickWidth, brickHeight);
                
                }
            }
           
        } 
    }
    @SuppressWarnings("static-access")
    public void setBrickValue(int value,int row,int column){
       
         if(Variables.level == 0 || Variables.level == 3){
         map[row][column] = value;
         Variables.totalBricks--;
         }
         if(Variables.level == 1 || variable.level == 2){
                
                if(count[row][column] == 1){  
                  map[row][column] = 1;
                  count[row][column] = 0;
                }
                 else{  
                map[row][column] = value;  
                Variables.totalBricks--;
                }
        }
        
    }
    
    
    
}
