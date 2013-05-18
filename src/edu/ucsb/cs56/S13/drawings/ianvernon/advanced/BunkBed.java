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

	// coordinates and sizes for different parts of bed
	double mattressHeight = .4*height;
        double mattressYPosition = y - height + .3*height;
        double pillowHeight = .3*pillowWidth;
        double pillowYPosition = mattressYPosition - pillowHeight;

	// make shapes for each bed part
        Rectangle2D.Double mattress = new Rectangle2D.Double(x, mattressYPosition, width, mattressHeight);
        Line2D.Double leftPost      = new Line2D.Double(x, y-height, x, y);
        Line2D.Double rightPost     = new Line2D.Double(x+width, y-height, x+width,y);
        Rectangle2D.Double pillow   = new Rectangle2D.Double(x + .9*width - pillowWidth , pillowYPosition, pillowWidth, pillowHeight);
	Line2D.Double ladder        = new Line2D.Double(x-.2*x, y+height, x, .8*y);

	// put all parts of bed into a General Path
        GeneralPath wholeBed = this.get();
        wholeBed.append(mattress, false);
        wholeBed.append(leftPost, false);
        wholeBed.append(rightPost, false);
        wholeBed.append(pillow, false);
	wholeBed.append(ladder, false);
    }
}
