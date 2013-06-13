package edu.ucsb.cs56.S13.drawings.mpnguyen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A CupOfWaterWithStraw (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
   
   @author Mark Nguyen
   @version for CS56, S13, UCSB, 05/15/2013
   
*/
public class CupOfWaterWithStraw extends CupOfWater
{
    
    /**
     * Constructor for objects of class CupOfWaterWithStraw
     */
    public CupOfWaterWithStraw(double x, double y, double width, double height)
    {
        super(x, y, width, height);
        
        // Specify the upper left corner, and the 
        // width and height of the original points used to 
        // plot the *hard-coded* cupOfWaterWithStraw
        
        final double ORIG_X = x;
        final double ORIG_Y = y;
        
        GeneralPath straw = new GeneralPath();
	
	// Draw left side
	straw.moveTo(ORIG_X - width / 20 , ORIG_Y - height / 3);
	straw.lineTo(ORIG_X, ORIG_Y);
	
	// Draw right Side
	straw.moveTo(ORIG_X, ORIG_Y - height / 3);
	straw.lineTo(ORIG_X + width / 10, ORIG_Y + height / 4);
	
	// Draw top side
	straw.moveTo(ORIG_X - width / 20, ORIG_Y - height / 3);
	straw.lineTo(ORIG_X, ORIG_Y - height / 3);
	
	// Add to the cup
	GeneralPath wholeCup = this.get();
	wholeCup.append(straw, false);
    }

}
