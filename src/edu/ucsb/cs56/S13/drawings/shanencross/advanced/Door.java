package edu.ucsb.cs56.S13.drawings.shanencross.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a rectangular door with doorknob 
   that implements the Shape interface, and so can be 
   drawn, as well as rotated, scaled, etc.
      
   @author Shanen Cross
   @version for CS56, Spring 13, UCSB
   
*/
public class Door extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x  x position of top-left corner
       @param y  y position of top-left corner
       @param length of diagonal of door
     */
    public Door(double x, double y, double width, double height)
    {
	// Make the border frame for the door with given arguments
	Rectangle2D.Double border = new Rectangle2D.Double(x, y, width, height);
	
	double knob_x = x+width/15; // Get door knob placement coordinates
	double knob_y = y+height*1/2;
	double knob_radius = -1; // meaningless initialization to force compile

	// Scale door knob radius in proportion with smaller dimension;
	// that way he knob is always smaller than the door border frame
	if (width >= height) {
		knob_radius = height*1/7; 
	}
	else if (height >= width ) {
		knob_radius = width*1/7;
	}	
	// Make the door knob
	Ellipse2D.Double knob = new Ellipse2D.Double(knob_x, knob_y, knob_radius, knob_radius);
        
	// Combine the border and knob into a single complete door
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(border, false);
        wholeDoor.append(knob, false);
    }

}
