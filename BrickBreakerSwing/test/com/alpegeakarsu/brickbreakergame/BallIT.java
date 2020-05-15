
package com.alpegeakarsu.brickbreakergame;

import java.awt.Graphics;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BallIT {
    Ball ball;
    JFrame frame;
    public BallIT() {
        ball = new Ball(20,30,-1,-1);
        frame = new JFrame();
         frame.setBounds(5, 5, 400, 700);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    public void paint(Graphics g){
    ball.paint(g);
    g.fillRect(200, 300, 221, 444);
    }
    
    /**
     * Test of paint method, of class Ball.
     */
    @Test
    public void testPaint() {
       
    }
    
    
}
