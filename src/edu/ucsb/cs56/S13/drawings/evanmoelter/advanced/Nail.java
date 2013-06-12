package edu.ucsb.cs56.S13.drawings.evanmoelter.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a construction nail that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Evan Moelter
   @author Phill Conrad
   @version for CS56, Spring '13, UCSB
   
*/
public class Nail extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of nail
       @param y y coord of lower left corner of nail
       @param width width of the nail
       @param height of nail
     */
    public Nail(double x, double y, double width, double height)
    {
            
        // Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
	Line2D.Double top = new Line2D.Double
	    (x, y, x+width, y);
	
        Line2D.Double left = 
            new Line2D.Double (x + (width/3), y,
                               x + (width/3), y + (9*height/10));
	
        Line2D.Double right =
            new Line2D.Double (x + (2*width/3), y,
                               x + (2*width/3), y + (9*height/10));
	
	Line2D.Double pointLeft =
            new Line2D.Double (x + width/3, y + 9*height/10, x + width/2, y+height);
	
	Line2D.Double pointRight =
	    new Line2D.Double (x + 2*width/3, y + 9*height/10, x + width/2, y+height);
	
	
	// put the whole nail together       
        GeneralPath wholeNail = this.get();
        wholeNail.append(top, false);
        wholeNail.append(left, false);
        wholeNail.append(right, false); 
        wholeNail.append(pointLeft, false);
        wholeNail.append(pointRight, false);

	
    }

}
