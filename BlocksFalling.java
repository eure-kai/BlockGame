//Step 2 - Implementing the Falling part

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class BlocksFalling extends Applet implements Runnable {
   Thread t = null;
   
   private int xVal = 0;
   private int yVal = 0;
   
   private int r1 = (int) (Math.random() * 20);
   private int prev = 0;
   private int r2 = 0;
   
   private int r = (int) (Math.random() * 256);
   private int gr = (int) (Math.random() * 256);
   private int b = (int) (Math.random() * 256);
   
   private Block blo = new Block(xVal, yVal, r, gr, b, 20);
   private Block[][] array = new Block[20][20];
   
   public void start() {
       t = new Thread(this);
       t.start();
   }
   
   public void init() {
       setBackground(Color.black);
   }
   
   public void run() {
       while (true) {
           xVal = 20 * r1;
           yVal = 20 * r2;
               
           blo = new Block(xVal, yVal, r, gr, b, 20);
           
           repaint();
           r2++;
           System.out.println(xVal);
           
           try {
                Thread.sleep(100);
            } catch (Exception e) {}
       }
       
   }
   
   public void paint(Graphics g) {
       while (true) {
           for (Block[] arr: array) {
               for (Block temp: arr) {
                       if (temp != null) temp.draw(g);
               }
           }
           
           if (r2 == 19 || array[r1][r2+1] != null) {
               array[r1][r2] = blo;
               
               r = (int) (Math.random() * 256);
               gr = (int) (Math.random() * 256);
               b = (int) (Math.random() * 256);
               
               prev = r1;
               
               while (true) {
                   r1 = (int) (Math.random() * 20);
                   r2 = 0;
                   
                   if (r1 != prev) break;
               }
           }
           
           else {
               blo.draw(g);
               break;
           }
       }
       
   }
       
   
}
