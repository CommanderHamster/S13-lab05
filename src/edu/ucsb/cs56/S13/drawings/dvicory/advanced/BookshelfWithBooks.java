package edu.ucsb.cs56.S13.drawings.dvicory.advanced;
import java.util.Random; // for drawing randomized sizes
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
public class BookshelfWithBooks extends Bookshelf implements Shape {
    /**
       Constructor for Bookshelf with books

       @param x x coord of lower left corner of bookshelf
       @param y y coord of lower left corner of bookshelf
       @param width width of the bookshelf
       @param height height of the bookshelf
    */
    public BookshelfWithBooks(double x, double y, double width, double height) {
	super(x, y, width, height);

	// need to add our line2d's to the path
	GeneralPath wholeBookshelf = this.get();

	Random rand = new Random();

	// let's place books on all the shelfs
	for (int i = 0; i < 5; ++i) {
	    // so let's do somewhere between 12 and 16 books per shelf
	    int numBooks = rand.nextInt(16 - 12 + 1) + 12;

	    for (int j = 0; j < numBooks; ++j) {
		// let's do a slight variation in heights
		// so randomly choose between 55% and 80% of the height of a shelf
		double minHeight = 0.55 * (height / 4);
		double maxHeight = 0.8 * (height / 4);
		double bookHeight = minHeight + (maxHeight - minHeight) * rand.nextDouble();
		double bX1 = x + (j * (width / numBooks));
		double bX2 = x + (j * (width / numBooks)) + (width / numBooks);
		double bY1 = y + (i * (height / 4));
		double bY2 = y + (i * (height / 4)) - bookHeight;

		// draw the parts of the book
		// don't need to draw the bottom since it overlaps with shelf
		Line2D.Double top = new Line2D.Double(bX1, bY2, bX2, bY2);
		Line2D.Double left = new Line2D.Double(bX1, bY1, bX1, bY2);
		Line2D.Double right = new Line2D.Double(bX2, bY1, bX2, bY2);
		wholeBookshelf.append(top, false);
		wholeBookshelf.append(left, false);
		wholeBookshelf.append(right, false);
	    }
	}
    }
}
