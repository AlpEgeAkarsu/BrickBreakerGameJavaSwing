/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpegeakarsu.brickbreakergame;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alpegemac
 */
public class PaddleIT {
    static Paddle paddle;
    static int paddleTestX = 20;
    
    @BeforeClass
    public static void setUpClass() { // hepsinden önce 1 kere
        Variables.level = 1;
        
    }
    
    
    @Before
    public void setUp() { // her metoddan önce
        paddle = new Paddle(paddleTestX);
     
    }
    
    @After
    public void tearDown() { // her method sonrası kod
        System.out.println(paddle.paddleX);
    }

    @Test
    public void testMoveLeft() {
        if(Variables.level == 0) {
            paddle.moveLeft();
        assertEquals(0,paddle.paddleX);
        }
    }
    
    @Test
    public void testMoveRight() {
       if(Variables.level == 0) {
       paddle.moveRight();
       assertEquals(40,paddle.paddleX);
       }
        
    }
    @Test
    public void testMoveLeftLevelOne(){
          if(Variables.level == 1){ 
              paddle.moveLeft();
            assertEquals(-10,paddle.paddleX);
            }
          
        }
    
      @Test
    public void testMoveRightLevelOne(){
          if(Variables.level == 1){ 
              paddle.moveRight();
            assertEquals(50,paddle.paddleX);
            }
          
        }
    
      @Test
    public void testMoveLeftLevelTwo(){
          if(Variables.level == 2){ 
              paddle.moveLeft();
            assertEquals(-20,paddle.paddleX);
            }
          
        }
    
      @Test
    public void testMoveRightLevelTwo(){
          if(Variables.level == 2){ 
              paddle.moveRight();
            assertEquals(60,paddle.paddleX);
            }
          
        }
    
    
}