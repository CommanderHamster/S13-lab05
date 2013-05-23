package edu.ucsb.cs56.S13.drawings.vinhle.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Ellipse2D;

import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of an Ice Cream Cone with Sprinkles that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Vinh Le
   @version for CS56, Spring 13, UCSB
   
*/
public class IceCreamSprinkles extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of ice cream
       @param y y coord of lower left corner of ice cream
       @param width width of the ice cream
       @param height of ice cream
     */
    public IceCreamSprinkles(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double IceCreamWidth = width;
	double IceCreamHeight = height/2;
	double iceCreamY = y;
	double iceCreamX = x;
        double coneHeight = height;
        
        
        // Makes the ice cream on top
        
        Ellipse2D.Double IceCream = 
            new Ellipse2D.Double(iceCreamX - height/1.80, iceCreamY-(height*1.5),IceCreamWidth+width/1.5, IceCreamHeight*2);
                          
        // makes the cone and the sprinkles.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftCone = 
            new Line2D.Double (x, y,
                               x + width, y - coneHeight);
                               
        Line2D.Double rightCone =
            new Line2D.Double (x, y,
                               x - width, y - coneHeight);
	Rectangle2D.Double sprinkle1 =
	    new Rectangle2D.Double(x-(width/2), y-height,
				   x/10, y/15);
	Ellipse2D.Double sprinkle2 =
	    new Ellipse2D.Double(x-(width/10), y - (height*.75),
				 x/20, y/20);

	Rectangle2D.Double sprinkle3 =
	    new Rectangle2D.Double (x-(width/18), y-height*1.2,
				    x/10, y/15);
        // put the whole ice cream with sprinkles and everything together
       
        GeneralPath iceCreamCone = this.get();
        iceCreamCone.append(IceCream, false);
	iceCreamCone.append(leftCone, false);
        iceCreamCone.append(rightCone, false); 
        iceCreamCone.append(sprinkle1, false);
	iceCreamCone.append(sprinkle2, false);
	iceCreamCone.append(sprinkle3, false);
    }

}
