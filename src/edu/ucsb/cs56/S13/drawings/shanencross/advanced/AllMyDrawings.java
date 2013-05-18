package edu.ucsb.cs56.S13.drawings.shanencross.advanced;

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
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Door d1 = new Door(100, 100, 100, 250);
	g2.draw(d1);
	Shape d2 = ShapeTransforms.scaledCopyOfLL(d1, 0.5, 0.5);
	d2 = ShapeTransforms.translatedCopyOf(d2, 300, -100);
	g2.draw(d2);

	Shape d3 = ShapeTransforms.scaledCopyOfLL(d1, 0.75, 0.75);
	d3 = ShapeTransforms.translatedCopyOf(d3, 150, -50);
	g2.draw(d3);
     }

    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	Door d1 = new Door(100, 100, 100, 250);
	g2.draw(d1);
	Door d2 = new Door (400, 400, 250, 250);
	g2.draw(d2);

	Shape d3 = ShapeTransforms.scaledCopyOfLL(d2, 1.25, 1.25);
	d3 = ShapeTransforms.translatedCopyOf(d3, 0, -300);
	g2.draw(d3);

    }
       

    /** Draw a different picture with a few houses and coffee cups
     */
    public static void drawPicture3(Graphics2D g2) {
	/*
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);
	
	// Draw some coffee cups.
	
       CoffeeCup large = new CoffeeCup(100,50,225,150);
       CoffeeCup smallCC = new CoffeeCup(20,50,40,30);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
	*/
       
    }
    

}
