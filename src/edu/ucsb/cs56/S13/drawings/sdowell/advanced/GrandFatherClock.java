package edu.ucsb.cs56.S13.drawings.sdowell.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a GrandFatherClock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sam Dowell
   @version for CS56, Spring 13, UCSB
   
*/
public class GrandFatherClock extends Clock implements Shape
{
    /**
       Constructor

       @param x x coordinate of top left corner of clock
       @param y y coordinate of top left corner of clock
       @param r radius of the clock
     */
    public GrandFatherClock(double x, double y, double r)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	super(x,y,r);
	GeneralPath gp = this.get();
	Line2D.Double pendarm = new Line2D.Double(x+r,y+r*2,x+r*.5,y+r*4);
	Ellipse2D.Double ball = new Ellipse2D.Double(x+r*.25,y+r*3.75,r*.5, r*.5);
	gp.append(pendarm, false);
	gp.append(ball, false);

        
    }

}
