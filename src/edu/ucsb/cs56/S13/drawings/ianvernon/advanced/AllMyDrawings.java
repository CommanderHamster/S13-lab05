package edu.ucsb.cs56.S13.drawings.ianvernon.advanced;

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
 * @author Ian Vernon
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a single black bed
     */
    public static void drawPicture1(Graphics2D g2) {
	//make a bed, change the stroke to draw it
	Bed b1 = new Bed(300,300,100,80,30);
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
        g2.setStroke(thick);                                                                                                  
        g2.setColor(new Color(0x002FA7));
	g2.setColor(Color.BLACK);
	g2.draw(b1);
	g2.drawString("a lonely bed, by Ian Vernon", 20, 30);
    }


    /** Draw a picture with some red, white, and black bunk beds
     */
    public static void drawPicture2(Graphics2D g2) {
	// set stroke to be thick for all beds
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2.setStroke(thick);
	BunkBed b2 = new BunkBed(100, 300, 50, 80, 20);
	Shape sb2 = ShapeTransforms.scaledCopyOfLL(b2,2,2);  
        sb2 = ShapeTransforms.translatedCopyOf(sb2,300,0);                                                                     
	// set colors, draw different beds, do some more transforms
        g2.setColor(Color.RED); 
	g2.draw(sb2);  
        g2.setColor(Color.CYAN);
        g2.draw(b2);
	g2.setColor(Color.BLACK);
	sb2 = ShapeTransforms.translatedCopyOf(sb2,400,40);
	sb2 = ShapeTransforms.rotatedCopyOf(sb2, Math.PI/4.0);
	g2.draw(sb2);
        g2.drawString("red white and black bunk beds, by Ian Vernon", 20,20);
    }
  
    /** Draw a bed and a bunk bed, scale them different ways, and draw the scaled versions
     */

    public static void drawPicture3(Graphics2D g2) {
	// 
	Bed anotherBed = new Bed(230,70,70, 70, 30);
	BunkBed thick  = new BunkBed(70,230,90,50,10);
	
	Shape scaledThick = ShapeTransforms.scaledCopyOfLL(thick, 2, .6);
	scaledThick = ShapeTransforms.rotatedCopyOf(scaledThick, -Math.PI/4.0);
	scaledThick = ShapeTransforms.translatedCopyOf(scaledThick, 0, 50); 
	g2.setColor(new Color(0x012F23));
	g2.draw(scaledThick);

	Shape s = ShapeTransforms.rotatedCopyOf(anotherBed, 1.6);
	g2.setColor(Color.MAGENTA);
	g2.draw(anotherBed);

	Stroke thicker = new BasicStroke (2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2.setStroke(thicker);
        g2.setColor(Color.GREEN);
	g2.draw(thick);
       
       
    }
    

}
