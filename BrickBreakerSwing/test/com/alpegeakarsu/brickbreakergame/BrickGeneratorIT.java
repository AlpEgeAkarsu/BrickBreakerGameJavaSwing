/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpegeakarsu.brickbreakergame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BrickGeneratorIT {
     BrickGenerator brick;
     int row = 3;
     int column = 7;
     Graphics2D g;
    private BufferedImage img;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
  
    public BrickGeneratorIT() {
        img = new BufferedImage(400,600,BufferedImage.TYPE_INT_RGB);
        
        g = (Graphics2D) img.getGraphics();
         frame.setBounds(10,10,700,605);
    frame.setTitle("SimpleTry");
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    brick = new BrickGenerator(row,column);
    panel.setBackground(Color.red);
    frame.add(panel);
     frame.setVisible(true);
    }
    
    
    @Test
    public void testDraw() {
       
        brick.draw(g);
        
        
    }

   
    
}
