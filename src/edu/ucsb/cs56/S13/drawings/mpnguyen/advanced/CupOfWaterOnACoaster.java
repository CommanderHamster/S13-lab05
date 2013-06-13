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
   A CupOfWaterOnACoaster (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
   
   @author Mark Nguyen
   @version for CS56, S13, UCSB, 05/15/2013
   
*/
public class CupOfWaterOnACoaster extends CupOfWater
{
    
    /**
     * Constructor for objects of class CupOfWaterOnACoaster
     */
    public CupOfWaterOnACoaster(double x, double y, double width, double height)
    {
        super(x, y, width, height);
        
        // Specify the upper left corner, and the 
        // width and height of the original points used to 
        // plot the *hard-coded* cupOfWaterOnACoaster
        
        final double ORIG_X = x;
        final double ORIG_Y = y;
        
        GeneralPath straw = new GeneralPath();
	
	// Draw left side
	straw.moveTo(ORIG_X - 12, ORIG_Y - 50);
	straw.lineTo(ORIG_X+2 , ORIG_Y + 2);
	
	// Draw right Side
	straw.moveTo(ORIG_X, ORIG_Y - 50);
	straw.lineTo(ORIG_X + 18, ORIG_Y+22);
	
	// Draw top side
	straw.moveTo(ORIG_X - 12, ORIG_Y - 50);
	straw.lineTo(ORIG_X, ORIG_Y - 50);
	
	// Add to the cup
	GeneralPath wholeCoaster = this.get();
	wholeCoaster.append(straw, false);
    }

}
