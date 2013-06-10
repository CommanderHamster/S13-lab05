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
   A vector drawing of a bed that implements the Shape interface. This enables    it to be rotated, scaled, and more.
   @author Ian Vernon
   @version for CS56, S13, UCSB                                                                    
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
	drawingHelper(x, y, width, height, pillowWidth);

    }
    /** drawingHelper - helps draw the bed, provided so it can be called more than once in a subclass as opposed to not being able to if the code was in the const ructor
	@param x x coordinate of lower left post of bed
	@param y y coordinate of lower left post of bed
	@param width of the bed
	@param height of a post of the bed
	@param pillowWidth width of pillow on bed
    */
    public void drawingHelper(double x, double y, double width, double height, double pillowWidth)
    {
	// calculate positions for different parts of bed                                                                                                                                   
        double mattressHeight = .4*height;
        double mattressYPosition = y + .3*height;
        double pillowHeight = .3*pillowWidth;
        double pillowYPosition = mattressYPosition - pillowHeight;

        //make different parts of bed by scaling different location inputs                                                                                                                  
        Rectangle2D.Double mattress = new Rectangle2D.Double(x, mattressYPosition, width, mattressHeight);
        Line2D.Double leftPost =      new Line2D.Double(x, y, x, y + height);
        Line2D.Double rightPost =     new Line2D.Double(x+width, y, x+width,y + height);
        Rectangle2D.Double pillow =   new Rectangle2D.Double(x + .9*width - pillowWidth , pillowYPosition, pillowWidth, pillowHeight);
        Circle leftLegEnd =           new Circle(x, y+height, .1*width);
        Circle rightLegEnd =          new Circle(x+width, y+height, .1*width);

        //group bed parts together in a GeneralPath                                                                                                                                         
        GeneralPath wholeBed = this.get();
        wholeBed.append(mattress, false);
        wholeBed.append(leftPost, false);
        wholeBed.append(rightPost, false);
        wholeBed.append(pillow, false);
        wholeBed.append(leftLegEnd, false);
        wholeBed.append(rightLegEnd, false);

    }
}
