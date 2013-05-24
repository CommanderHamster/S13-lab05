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
   A CupOfWater (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Mark Nguyen
   @version for CS56, S13, UCSB, 05/15/2013
   
*/
public class CupOfWater extends GeneralPathWrapper implements Shape
{
    
    /**
     * Constructor for objects of class CupOfWater
     */
    public CupOfWater(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        // width and height of the original points used to 
        // plot the *hard-coded* cupOfWater
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 100.0; 
        final double ORIG_WIDTH = 100.0; 
                
        GeneralPath bottomOfTop = new GeneralPath();
        
        // bottom of top
        
        bottomOfTop.moveTo(ORIG_ULX,ORIG_ULY);
        bottomOfTop.curveTo(ORIG_ULX, ORIG_ULY + ORIG_WIDTH, 600, ORIG_ULY + ORIG_WIDTH, 600, ORIG_ULY);
        
        
        Shape topOfTop = ShapeTransforms.verticallyFlippedCopyOf(bottomOfTop);
	
	
        
        // now we put the whole thing together ino a single path.
        
        GeneralPath wholeCupOfWater = new GeneralPath ();
        wholeCupOfWater.append(bottomOfTop, false);
        wholeCupOfWater.append(topOfTop, false);
        
        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeCupOfWater, -ORIG_ULX + x, -ORIG_ULY + y);
        
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cupOfWater
        
	this.set(new GeneralPath(s));
        
    }

}
