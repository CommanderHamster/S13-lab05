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
   A drawing of a clock that implements the Shape interface, and so can be drawn, rotated, scaled, etc.
      
   @author Sam Dowell
   @version for CS56, Spring 13, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coordinate of top left corner of clock
       @param y y coordinate of top left corner of clock
       @param r radius of the clock
     */
    public Clock(double x, double y, double r)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        


	Ellipse2D.Double clock = new Ellipse2D.Double( x, y, 2*r, 2*r);
	Line2D.Double minutehand = new Line2D.Double(x+r, y+r, x+r, y+r*.25);
	Line2D.Double hourhand = new Line2D.Double(x+r, y+r, x+r*1.5, y+r);
	GeneralPath wholeClock = this.get();
	wholeClock.append(clock, false);
	wholeClock.append(minutehand, false);
	wholeClock.append(hourhand, false);
        
    }

}
