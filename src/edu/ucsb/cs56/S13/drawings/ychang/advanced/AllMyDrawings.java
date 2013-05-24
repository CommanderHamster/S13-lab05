package edu.ucsb.cs56.S13.drawings.ychang.advanced;

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

import java.util.*;

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
    /** Draw a picture with a few CD cases 
     */

    public static void drawPicture1(Graphics2D g2) {

	CDCase c1 = new CDCase(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black CD case that's half the size, 
	// and moved over 150 pixels in x direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a CD case that's 4x as big (2x the original)
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
	
	// Draw CD cases with CDs
	
	CDCaseWithCD cd1 = new CDCaseWithCD(50,350,40,75);
	CDCaseWithCD cd2 = new CDCaseWithCD(200,350,200,100);
	
	g2.draw(cd1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cd2);
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few CD cases by Yun Suk Chang", 20,20);
    }


    /** Draw a picture with a few empty CD cases rotated for flipped
     */
    public static void drawPicture2(Graphics2D g2) {
	CDCase c1 = new CDCase(150,300,70,75);
	g2.setColor(Color.RED); g2.draw(c1);
	
	// Make a Blue CD case that's rotated 2 radians, 
	// and moved over 120 pixels in x direction and 50 pixels in y direction

	Shape c2 = ShapeTransforms.rotatedCopyOf(c1,2);
	c2 = ShapeTransforms.translatedCopyOf(c2,120,50);
	g2.setColor(Color.BLUE); g2.draw(c2);
	
	// Here's a CD case that's horizontally flipped
	// and moved over 50 more pixels to left and 200 pixels to North.
	c2 = ShapeTransforms.horizontallyFlippedCopyOf(c2);
	c2 = ShapeTransforms.translatedCopyOf(c2,-50,-200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FB8)); 
	g2.draw(c2); 
	
	

	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few empty cd cases that are rotated or flipped", 20,20);
    }
  
    /** Draw bunch of random CD cases
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("20 randomly generated CD cases by Yun Suk Chang", 20,20);

	//draw 20 random CD cases
	for(int i =0;i<20;i++){
		//choose CD case type
		CDCase cd;
		Shape cd2;
		int w=110,h=100,n;
		double d;
		int num = (int)(Math.random()*2);
		if(num==0)
		cd= new CDCase(0,0,110,100);
		else
		cd = new CDCaseWithCD(0,0,110,100);
		//rotated
		double dnum = Math.random()*2*Math.PI;
		cd2 = (ShapeTransforms.rotatedCopyOf(cd,dnum));

		num = (int)(Math.random()*5);
		
		switch(num){
		case 0://horizontal flip
			
			cd2 = (ShapeTransforms.horizontallyFlippedCopyOf(cd2));
			break;
		case 1://vertical flip
			
			cd2 =(ShapeTransforms.verticallyFlippedCopyOf(cd2));
			break;
  		case 2://scaled
			 n = (int)(Math.random()*2);
			if(n==0)
			d = Math.random()*3 +1;
			else
			d = Math.random()*0.9 +0.1;
			w*=d;
			h*=d;
			cd2 = (ShapeTransforms.scaledCopyOf(cd2,d,d));
			break;
		case 3://scaled horizontal flip
			 n = (int)(Math.random()*2);
			if(n==0)
			d = Math.random()*3 +1;
			else
			d = Math.random()*0.9 +0.1;
			w*=d;
			h*=d;
			cd2 = (ShapeTransforms.scaledCopyOf(cd2,d,d));
			
			cd2 = (ShapeTransforms.horizontallyFlippedCopyOf(cd2));
			break;
		case 4://scaled vertical flip
			 n = (int)(Math.random()*2);
			if(n==0)
			d = Math.random()*3 +1;
			else
			d = Math.random()*0.9 +0.1;
			cd2 = (ShapeTransforms.scaledCopyOf(cd2,d,d));
			w*=d;
			h*=d;
			cd2 = (ShapeTransforms.verticallyFlippedCopyOf(cd2));
			break;
		}
		
		//translate
		int x = (int)(Math.random()*(640-(int)w));
		int y = (int) (Math.random()*(480-(int)h));
		cd2 = (ShapeTransforms.translatedCopyOf(cd2,x,y));
		//random color	
		g2.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256))); 
		g2.draw(cd2);
	
	}
	
       
    }
    

}
