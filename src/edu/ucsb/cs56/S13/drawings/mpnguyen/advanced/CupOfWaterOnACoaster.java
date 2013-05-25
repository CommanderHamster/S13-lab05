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
     * Constructor for objects of class CupOfWater
     */
    public CupOfWater(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        // width and height of the original points used to 
        // plot the *hard-coded* cupOfWater
        
        final double ORIG_X = 50;
        final double ORIG_Y = 100;
        final double ORIG_WIDTH = 150;
        final double ORIG_CIRC_HEIGHT = 0.275 * ORIG_WIDTH;
        final double ORIG_HEIGHT = 1 * ORIG_WIDTH;
        
        GeneralPath bottomOfTop = new GeneralPath();
        bottomOfTop.moveTo(ORIG_X, ORIG_Y);
        bottomOfTop.curveTo(ORIG_X, ORIG_Y + ORIG_CIRC_HEIGHT, ORIG_X + ORIG_WIDTH, ORIG_Y + ORIG_CIRC_HEIGHT, ORIG_X + ORIG_WIDTH, ORIG_Y);
        
        Shape topOfTop = ShapeTransforms.verticallyFlippedCopyOf(bottomOfTop);
        
        GeneralPath topOfCup = new GeneralPath ();
        topOfCup.append(bottomOfTop, false);
        topOfCup.append(topOfTop, false);

       	Shape bottomOfCup = ShapeTransforms.scaledCopyOf(bottomOfTop, 0.65, 0.65);
	bottomOfCup = ShapeTransforms.translatedCopyOf(bottomOfCup, ORIG_WIDTH * (1 - 0.65) / 2, ORIG_HEIGHT);
	
	GeneralPath leftLine = new GeneralPath();
	leftLine.moveTo(ORIG_X, ORIG_Y);
	leftLine.lineTo(ORIG_X + ORIG_WIDTH * ( 1 - 0.65 ) * 0.5, ORIG_Y + ORIG_HEIGHT);
	
	GeneralPath rightLine = new GeneralPath();
	rightLine.moveTo(ORIG_X + ORIG_WIDTH, ORIG_Y);
	rightLine.lineTo(ORIG_X + ORIG_WIDTH * (1 - (( 1 - 0.65 ) * 0.5 ) ), ORIG_Y + ORIG_HEIGHT);
	
	GeneralPath wholeCup = new GeneralPath();
	wholeCup.append(topOfCup, false);
	wholeCup.append(bottomOfCup, false);
	wholeCup.append(rightLine, false);
	wholeCup.append(leftLine, false);
	
        this.set(wholeCup);
    }

}
