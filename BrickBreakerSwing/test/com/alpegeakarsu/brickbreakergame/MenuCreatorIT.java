/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpegeakarsu.brickbreakergame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuCreatorIT {
    static MenuCreator menu;
    static JMenuBar menubar;
     static JFrame frame;
    public MenuCreatorIT() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
         menu = new MenuCreator();
        frame = new JFrame();
         frame.setBounds(5, 5, 400, 700);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         
         frame.setVisible(true);
    }
    
    @AfterClass
    public static void tearDownClass() {
        frame.setJMenuBar(menubar);
    }
    

    @Test
    public void testCreateMenuBar() throws Exception {
       menubar = menu.createMenuBar();
    }
    
}
