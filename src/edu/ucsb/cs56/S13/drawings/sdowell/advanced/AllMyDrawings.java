package edu.ucsb.cs56.S13.drawings.sdowell.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Sam Dowell
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few clocks
     */

    public static void drawPicture1(Graphics2D g2) {

	Clock c1 = new Clock(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black clock that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a clock that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two grandfather clocks
	
	GrandFatherClock gfc1 = new GrandFatherClock(50,100,75);
	GrandFatherClock gfc2 = new GrandFatherClock(200,100,50);
	
	g2.draw(gfc1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(gfc2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few clocks by Sam Dowell", 20,20);
    }


    /** Draw a picture with a few clocks
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some coffee cups.
	
	Clock large = new Clock(100,50,225);
	Clock small = new Clock(20,50,60);
	Clock medium = new Clock(20,150,125);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	g2.setColor(Color.BLUE);    g2.draw(medium);
	
	Clock c1 = new Clock(100,250,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black clock that's half the size, 
	// and moved over 150 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a clock that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two grandfather clocks
	
	GrandFatherClock gfc1 = new GrandFatherClock(50,50,40);
	GrandFatherClock gfc2 = new GrandFatherClock(200,75,110);
	
	g2.draw(gfc1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second clock 45 degrees around its center.
	Shape gfc3 = ShapeTransforms.rotatedCopyOf(gfc2, Math.PI/4.0);

	g2.draw(gfc3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch clocks by Sam Dowell", 20,20);
    }
  
    /** Draw a different picture with a couple clocks
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Clocks by Sam Dowell", 20,20);

	
	// Draw some clocks.
	
       Clock large = new Clock(100,50,225);
       Clock small = new Clock(50,50,40);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(small);
       
       
    }
    

}
