package edu.ucsb.cs56.S13.drawings.austinphillips.advanced;
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
   An adorable little puppy... kindof
      
   @author Austin Phillips
   @version for CS56, S13
   
*/

public class Dog extends Body implements Shape
{
    public Dog(double x, double y, double length, double width)
    {
	//make the basic dog body
	super(x,y,length, width);
	//add tail
	length=width*2;
	Ellipse2D.Double tail = new Ellipse2D.Double(x+length, y-width*.5, width, width*.3);

	GeneralPath fullDog = this.get();
	fullDog.append(tail,false);
    }
}
