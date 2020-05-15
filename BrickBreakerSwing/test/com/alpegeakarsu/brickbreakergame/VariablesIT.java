/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpegeakarsu.brickbreakergame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VariablesIT {
    Variables variables;
    static int testBrick;
    static int testDelay;
    static int testLevel;
    static boolean testIsPlaying;
    public VariablesIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        testBrick = Variables.totalBricks;
        testDelay = Variables.delay;
        testLevel = Variables.level;
        testIsPlaying = Variables.isPlaying;
    }
    
    @Test
    public void testVariables() {
        assertEquals(21,testBrick);
        assertEquals(8,testDelay);
        assertEquals(0,testLevel);
        assertEquals(false,testIsPlaying);
        
    }
    
}
