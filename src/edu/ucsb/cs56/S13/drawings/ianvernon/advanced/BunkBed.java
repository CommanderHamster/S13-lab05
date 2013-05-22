package edu.ucsb.cs56.S13.drawings.ianvernon.advanced;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
import java.awt.Shape;

import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.S13.drawings.ianvernon.simple.Circle;

/**
   A vector drawing of a bunk bed that implements the Shape interface and extends the Bed class. This enables 
   it to be rotated, scaled, and more.                                                                  
   @author Ian Vernon
   @version for CS56, S13, UCSB                  
*/

public class BunkBed extends Bed implements Shape
{
    /** Constructor
        @param x x coordinate of lower left  post of bed 
        @param y y coordinate of lower left post of bed
        @param width of the bed 
        @param height of each bed 
        @param pillowWidth width of pillows on bed   
    */

    public BunkBed(double x, double y, double width, double height, double pillowWidth)
    {
	// call Bed constructor to create bottom bed
	super(x, y, width, height, pillowWidth);
	drawingHelper(x, y-height, width, height, pillowWidth);
    }
}
