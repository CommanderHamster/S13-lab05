package edu.ucsb.cs56.S13.drawings.vinhle.advanced;

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
 * @author Vinh Le
 * @version for CS56, lab06, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few ice cream cones 
     */

    public static void drawPicture1(Graphics2D g2) {

	IceCreamCone c1 = new IceCreamCone(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	


	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
        
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
        
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	

	
	IceCreamSprinkles is1 = new IceCreamSprinkles(50,125,25,37);
	IceCreamSprinkles is2 = new IceCreamSprinkles(200,450,100,150);
	
	g2.draw(is1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(is2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some Cool Ice Cream Cones by Vinh Le", 20,20);
    }


    /** Draw a picture with a few ice cream cones with and without sprinkles
     */
    public static void drawPicture2(Graphics2D g2) {


	
	IceCreamSprinkles monsterSize = new IceCreamSprinkles(200,500,100,150);
	IceCreamSprinkles normalSize = new IceCreamSprinkles(100,250,50,75);
	IceCreamSprinkles babySize = new IceCreamSprinkles(50,125,25,37);
	IceCreamSprinkles tinySize = new IceCreamSprinkles(25,62,12,18);
	
	g2.setColor(Color.ORANGE);     g2.draw(monsterSize);
	g2.setColor(Color.RED);   g2.draw(normalSize);
	g2.setColor(Color.GREEN);    g2.draw(babySize);
	g2.setColor(Color.BLUE); g2.draw(tinySize);
	
	IceCreamCone c1 = new IceCreamCone(100,250,50,75);
	g2.setColor(Color.YELLOW); g2.draw(c1);
	
        
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.75,0.75);
	c2 = ShapeTransforms.translatedCopyOf(c2,200,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
      
	c2 = ShapeTransforms.scaledCopyOfLL(c2,2,2);
	c2 = ShapeTransforms.translatedCopyOf(c2,300,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two ice cream cone with sprinkles
	
	IceCreamSprinkles is1 = new IceCreamSprinkles(100,350,50,75);
	IceCreamSprinkles is2 = new IceCreamSprinkles(100,250,75,100);
	
	g2.draw(is1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second ice cream cone 60 degrees around its center.
	Shape is3 = ShapeTransforms.translatedCopyOf(is2, 150, 0);
	is3 = ShapeTransforms.rotatedCopyOf(is2, Math.PI/3.0);


	g2.draw(is3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Ice Cream Cones with and without sprinkles by Vinh Le", 20,20);
    }
  
    /** Draw nother picture with some Ice Cream COnes
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Colorful Ice Cream Cones by Vinh Le", 20,20);

	
	// Ice Cream Cones here.
	
       IceCreamCone monsterSize = new IceCreamCone(200,500,100,150);
       IceCreamCone babySize = new IceCreamCone(25,62,12,18);
       
       g2.setColor(Color.BLUE);     g2.draw(monsterSize);
       g2.setColor(Color.RED);   g2.draw(babySize);
       
       
    }
    

}
