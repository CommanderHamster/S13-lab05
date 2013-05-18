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
   A Door with a window.
      
   @author Shanen Cross 
   @version for CS56, 13, UCSB
   
*/
public class DoorWithWindow extends Door implements Shape
{
    /**
     * Constructor for DoorWithWindow
     * @param x  x coordinate of top-left corner
     * @param y  y coordinate of top-left corner
     * @param width  width of door
     * @param height  height of door
     */
    public DoorWithWindow(double x, double y, double width, double height)
    {
	// construct the basic door shell
	super(x,y,width,height);

	// Create window
	Rectangle2D.Double window = new Rectangle2D.Double(x+width/13, y+height/20, width*11/13, height/3);

	// Add the window to the door
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(window, false);
    }

}
