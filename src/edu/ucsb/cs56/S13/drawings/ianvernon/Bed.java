package edu.ucsb.cs56.S13.drawings.ianvernon;
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

/**
   A vector drawing of a bed that implements the Shape interface. This enables
   it to be rotated, scaled, and more.

   @author Ian Vernon
   @version for CS56, S11, UCSB
*/

public class Bed extends GeneralPathWrapper implements Shape
{
    /** Constructor

	@param x x coordinate of lower left  post of bed
	@param y y coordinate of lower left post of bed
	@param width of the bed
	@param height of a post of the bed
	@param pillowWidth width of pillow on bed
    */
    public Bed(double x, double y, double width, double height, double pillowWidth)
    {
	double mattressHeight = .6*height;
	double startingMattressPos = .8*x;
	double endingMattressPos = height - .2*x;
	double pillowHeight = .1*pillowWidth;
	
	Rectangle2D.Double mattress = new Rectangle2D.Double(startingMattressPos, startingMattressPos + endingMattressPos, width, height);
	Line2D.Double leftPost = new Line2D.Double(x, x, y, y + height);
	Line2D.Double rightPost = new Line2D.Double(x+width, x+width, y, y + height);
	Rectangle2D.Double pillow = new Rectangle2D.Double(pillowHeight, pillowWidth, x + .9*width, endingMattressPos);

	GeneralPath wholeBed = this.get();
	wholeBed.append(mattress, false);
	wholeBed.append(leftPost, false);
	wholeBed.append(rightPost, false);
	wholeBed.append(pillow, false);
    }
}
