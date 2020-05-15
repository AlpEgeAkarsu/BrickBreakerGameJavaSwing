
package com.alpegeakarsu.brickbreakergame;

/* IMPORTS */
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
/* IMPORTS */


public class MenuCreator{
         Variables variable;

    /* Returning a Menubar To Frame */
    public JMenuBar createMenuBar() {
         /* ATTRIBUTES */
        JMenuBar menuBar;
        JMenu menu,menu2;
        JMenuItem menuItem,menuItem2;
        /* ATTRIBUTES */
        
        // create first menu 
        menuBar = new JMenuBar(); //
        menu = new JMenu("Level");
        menu2 = new JMenu("Help");
        // create menu items for first menu
        menuItem = new JMenuItem("Increase Level");
        menuItem2 = new JMenuItem("Start Page");
        menuItem.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        // add actionListeners for first menuItems
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActionPerformed(evt);
            }
            public void menuItemActionPerformed(ActionEvent evt) {
               if(Variables.level <= 2){ 
            	   Variables.level++;
            	   Variables.delay = Variables.delay -2;
            	   Variables.isPlaying = false;
                  if(Variables.level == 1){
                   String message = "***LEVEL 2*** \n"
                           + "In This Stage Ball Must Hit 2 Times To Break Bricks..\n"
                           +"PRESS RIGHT-LEFT BUTTONS TO CONTINUE ";
                   JOptionPane.showMessageDialog(null, message);
               }
                    if(Variables.level == 2){
                   String message = "***LEVEL 3*** \n"
                           + "In This Stage Ball Must Hit 2 Times To Break Bricks..\n"
                           +"PRESS RIGHT-LEFT BUTTONS TO CONTINUE ";
                   JOptionPane.showMessageDialog(null, message);
               }
                      if(Variables.level == 3){
                   String message = "***LEVEL 4*** \n"
                           + "This stage Similar To Level 1 Because Ball Is Too Fast Good Luck..\n"
                           +"PRESS RIGHT-LEFT BUTTONS TO CONTINUE ";
                   JOptionPane.showMessageDialog(null, message);
               }
               }
            }
        });
         menuItem2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem2ActionPerformed(evt);
            }

            public void menuItem2ActionPerformed(ActionEvent evt) {
                String message = "To Pause : SPACE \n"
                        + "To Continue : RIGHT-LEFT BUTTONS\n"
                        + "To Restart : ENTER\n"
                        +"To Increase Level : CTRL or COMMAND + L"   ;
                Variables.isPlaying = false;
                JOptionPane.showMessageDialog(null, message);
                
            }
        });
      
        // add items to first menu 
        menu.add(menuItem);
        menu2.add(menuItem2);
        
        menuBar.add(menu);
        menuBar.add(menu2);
        return menuBar;
 
    }
   






}