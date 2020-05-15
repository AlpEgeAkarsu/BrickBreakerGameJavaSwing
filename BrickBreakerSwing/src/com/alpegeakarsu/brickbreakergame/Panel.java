
package com.alpegeakarsu.brickbreakergame;

/*    IMPORTS      */   
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*    IMPORTS      */  
 
public class Panel extends JPanel  implements KeyListener,ActionListener {
    /*    ATTRIBUTES      */  
    private int score = 0;
    private Timer timer;
    private BrickGenerator bricks;
    Variables variable;
    Paddle paddle;
    Ball ball;
    /*    ATTRIBUTES      */  
    
   /* DEFAULT CONSTRUCTOR */
    public Panel(){
        bricks = new BrickGenerator(3,7); // kaça kaçlık bir matris oluşturmak isteniyorsa... 3 satır 7 sütun 
        paddle = new Paddle(310);
        ball = new Ball(120,350,-1,-2);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(Variables.delay,this);
        timer.start();   
    }
    /* DEFAULT CONSTRUCTOR */
    
    
    /*    PAINT METHOD TO PREPARE PANEL      */    
    @Override
    public void paint(Graphics g){
    // background
    g.setColor(Color.black);
    g.fillRect(1,1, 692, 592); 
    // drawing map
    bricks.draw((Graphics2D)g);
    // borders
    g.setColor(Color.black);
    g.fillRect(0,0,3,592);
    g.fillRect(0,0,692,3);
    g.fillRect(691,0,3,592);
    // scores
    g.setColor(Color.white);
    g.setFont(new Font("serif",Font.BOLD,25));
    g.drawString(""+score,590,30);
    // the paddle
    paddle.paint(g);
    // the ball
    ball.paint(g);
   
    // If all the bricks are breaked
    if(Variables.totalBricks <= 0){
    	Variables.isPlaying = false;
        Ball.ballDirectionX = 0;
        Ball.ballDirectionY = 0;
        g.setColor(Color.RED);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("You Won,Total score:" + score,260,300);
        
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Press enter the Restart",230,350);
    
    }
     
    // If the ball out of borders
    if(Ball.ballCoordinateY > 570){
    	Variables.isPlaying = false;
        Ball.ballDirectionX = 0;
        Ball.ballDirectionY = 0;
        g.setColor(Color.RED);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("Game over,Total score:"+ score,190,300);
        
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Press enter the Restart",230,350);
       
    }
   
    
    g.dispose();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(Paddle.paddleX >= 600){
                Paddle.paddleX = 600;
            }else paddle.moveRight();
           
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
             if(Paddle.paddleX < 10){
                Paddle.paddleX = 10;
            }else paddle.moveLeft();
               
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!Variables.isPlaying){
            	Variables.isPlaying = true;
                ball = new Ball(120,350,-1,-2);
                Paddle.paddleX = 310;
                score = 0;
                Variables.totalBricks = 21;
                bricks = new BrickGenerator(3,7);
                repaint();
            }
        
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        	Variables.isPlaying = false;
      
           
        if(e.getKeyCode()== KeyEvent.VK_Q){
            timer.stop();
            System.exit(0);
        }
        

        
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        timer.setDelay(variable.delay);
        repaint(); // its call paint method again and draw everything again. to use moveright and moveleft functions. (to see on program actually)
        if(Variables.isPlaying){
           if(new Rectangle(Ball.ballCoordinateX,Ball.ballCoordinateY,20,20).intersects(new Rectangle(Paddle.paddleX,550,100,8))){ // if the ball intersects paddle
    
               Ball.ballDirectionY = -Ball.ballDirectionY;
               
           }
           A: for(int i=0; i<bricks.map.length; i++){
               for(int j=0; j<bricks.map[0].length; j++){
                   if(bricks.map[i][j] > 0 ){ // second map is in brick generator
                       int brickX = j* bricks.brickWidth + 80;
                       int brickY = i* bricks.brickHeight + 50;
                       int brickWidth = bricks.brickWidth;
                       int brickHeight = bricks.brickHeight;
                       
                       Rectangle compRect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                       Rectangle ballRect = new Rectangle(Ball.ballCoordinateX,Ball.ballCoordinateY,20,20);
                       Rectangle brickRect = compRect;
                       if(ballRect.intersects(brickRect)){
                         
                         
                           bricks.setBrickValue(0, i, j);
                           if(Variables.level == 0) score+= 5;
                           if(Variables.level == 1) score+=10;
                           if(Variables.level == 2) score+=15;
                           if(Variables.level == 3) score+=20;
                           
                           if(Ball.ballCoordinateX + 19 <= brickRect.x || Ball.ballCoordinateX + 1 >= brickRect.x + brickRect.width){
                          Ball.ballDirectionX  = -Ball.ballDirectionX;
                           }else{
                               Ball.ballDirectionY = -Ball.ballDirectionY;
                           }
                           break A;
                       }
                       
                       
                   }
                   
               }
           
           }
            Ball.ballCoordinateX += Ball.ballDirectionX; 
            Ball.ballCoordinateY += Ball.ballDirectionY;
            if(Ball.ballCoordinateX < 0){           // this is for the left border
                Ball.ballDirectionX = -Ball.ballDirectionX;   
            }
            if(Ball.ballCoordinateY < 0){       // this is for the top border
                Ball.ballDirectionY = -Ball.ballDirectionY;
            }
            if(Ball.ballCoordinateX > 670){       // this is for the right border
                Ball.ballDirectionX = -Ball.ballDirectionX;
            }
        
        
        
        }
        repaint();
        
        
    }
    
}
