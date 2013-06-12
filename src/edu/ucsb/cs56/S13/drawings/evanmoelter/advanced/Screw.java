package edu.ucsb.cs56.S13.drawings.evanmoelter.advanced;
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
   A nail with threading
      
   @author Evan Moelter
   @version for CS56, S13, UCSB
   
*/
public class Screw extends Nail implements Shape
{
    /**
     * Constructor for objects of class Screw
     */
    public Screw(double x, double y, double width, double height)
    {
	// construct the basic nail
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
        GeneralPath wholeScrew = this.get();

	//create an array of lines that will look like the threading on a screw.
	Line2D.Double[] lines = new Line2D.Double[9];

	//create and append each line to the GeneralPath
	for (int i = 0; i < 9; i++)
	    {
		lines[i] = new Line2D.Double (x+(5*width/6), y+ (i*height/10), x + (width/6), y + ((i+1)*height/10));
		wholeScrew.append(lines[i], false);
	    }
    }
}
