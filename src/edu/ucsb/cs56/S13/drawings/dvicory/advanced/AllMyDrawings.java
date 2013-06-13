package edu.ucsb.cs56.S13.drawings.dvicory.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 *
 * @author Daniel Vicory
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few bookshelfs
     */

    public static void drawPicture1(Graphics2D g2) {

	Bookshelf b1 = new Bookshelf(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(b1);

	// Make a black bookshelf that's half the size,
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);

	// Here's a bookshelf that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);

	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7));
	g2.draw(b2);

	// label the drawing
	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("A few bookshelves by Daniel Vicory", 20,20);
    }


    /** Draw a picture with a few bookshelves with books
     */
    public static void drawPicture2(Graphics2D g2) {

	// Draw some bookshelves with books

	BookshelfWithBooks large = new BookshelfWithBooks(100,50,225,150);
	BookshelfWithBooks smallBB = new BookshelfWithBooks(20,50,40,30);
	BookshelfWithBooks tallSkinny = new BookshelfWithBooks(20,150,20,40);
	BookshelfWithBooks shortFat = new BookshelfWithBooks(20,250,40,20);

	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallBB);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);

	// label the drawing
	g2.setColor(Color.BLACK);
	g2.drawString("A bunch of bookshelves with books by Daniel Vicory", 20,20);
    }

    /** Draw a different picture with a bookshelves with books
     */

    public static void drawPicture3(Graphics2D g2) {
	// label the drawing
	g2.drawString("A bunch of bookshelves with books by Daniel Vicory", 20,20);

	// Draw some bookshelves with books
	BookshelfWithBooks large = new BookshelfWithBooks(100,50,225,150);
	BookshelfWithBooks smallBB = new BookshelfWithBooks(20,50,40,30);

	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallBB);
    }
}
