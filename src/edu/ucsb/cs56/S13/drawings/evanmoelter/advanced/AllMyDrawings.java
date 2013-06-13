package edu.ucsb.cs56.S13.drawings.evanmoelter.advanced;

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
 * @author Phill Conrad 
 * @author Evan Moelter
 * @version for CS56, lab05, S13
 */


public class AllMyDrawings
{
    /** Draw a picture with a few nails and a couple screws 
     */

    public static void drawPicture1(Graphics2D g2) {

	Nail n1 = new Nail(100,250,20,100);
	g2.setColor(Color.CYAN); g2.draw(n1);
	
	// Make a black nail that's half the size, 
	// and moved over 150 pixels in x direction

	Shape n2 = ShapeTransforms.scaledCopyOfLL(n1,0.5,0.5);
	n2 = ShapeTransforms.translatedCopyOf(n2,150,0);
	g2.setColor(Color.BLACK); g2.draw(n2);
	
	// Here's a nail that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	n2 = ShapeTransforms.scaledCopyOfLL(n2,4,4);
	n2 = ShapeTransforms.translatedCopyOf(n2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(n2); 

	// Draw two screws
	g2.setStroke(orig); 

	Screw s1 = new Screw(50, 350, 10, 75);
	Screw s2 = new Screw(200, 350, 20, 100);
	
	g2.draw(s1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(s2);

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few nails by Evan Moelter", 20,20);
    }


    /** Draw a picture with some nails and screws
     */
    public static void drawPicture2(Graphics2D g2) {

	Nail n1 = new Nail(100,250,20,100);
	g2.setColor(Color.CYAN); g2.draw(n1);
	
	// Make a black nail that's half the size, 
	// and moved over 150 pixels in x direction

	Shape n2 = ShapeTransforms.scaledCopyOfLL(n1,0.5,0.5);
	n2 = ShapeTransforms.translatedCopyOf(n2,150,0);
	g2.setColor(Color.BLACK); g2.draw(n2);
	
	// Here's a nail that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	n2 = ShapeTransforms.scaledCopyOfLL(n2,4,4);
	n2 = ShapeTransforms.translatedCopyOf(n2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(n2); 

	// Draw two screws
	g2.setStroke(orig);	

	Screw s1 = new Screw(50, 350, 10, 75);
	Screw s2 = new Screw(200, 350, 20, 100);
	
	g2.draw(s1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(s2);
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of nails and screws by Evan Moelter", 20,20);
    }
  
    /** Draw a different picture with a few screws
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Screws by Phill Conrad", 20,20);

	
	// Draw some screws
	
       Screw large = new Screw(100,50,30,150);
       Screw small = new Screw(20,50,10,70);
       
       g2.setColor(Color.RED);
       g2.draw(large);
       g2.setColor(Color.GREEN);   
       g2.draw(small);
       
       
    }
    

}
