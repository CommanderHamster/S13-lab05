package edu.ucsb.cs56.S13.drawings.dvicory.advanced;
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
   A vector drawing of a bookshelf that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author Daniel Vicory
   @version CS56, S13, UCSB

*/
public class Bookshelf extends GeneralPathWrapper implements Shape {
    /**
       Constructor

       @param x x coord of lower left corner of bookshelf
       @param y y coord of lower left corner of bookshelf
       @param width width of the bookshelf
       @param height height of the bookshelf
    */
    public Bookshelf(double x, double y, double width, double height) {
	// need to add our line2d's to the path
	GeneralPath wholeBookshelf = this.get();

	// make the left and right side
	Line2D.Double left = new Line2D.Double(x, y,
					       x, y + height);
	Line2D.Double right = new Line2D.Double(x + width, y,
						x + width, y + height);

	wholeBookshelf.append(left, false);
	wholeBookshelf.append(right, false);

	// draw the shelves
	// we'll draw five shelves, starting from the top
	for (int i = 0; i < 5; ++i) {
	    Line2D.Double shelf = new Line2D.Double(x, y + (i * (height / 4)),
						    x + width, y + (i * (height / 4)));
	    wholeBookshelf.append(shelf, false);
	}
    }
}
