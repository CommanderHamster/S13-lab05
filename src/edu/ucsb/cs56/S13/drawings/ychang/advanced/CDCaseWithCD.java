package edu.ucsb.cs56.S13.drawings.ychang.advanced;
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
   A vector drawing of a CD case (with a CD inside) that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Yun Suk Chang
   @version for CS56, Spring 13, UCSB
   
*/
public class CDCaseWithCD extends CDCase implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of CD case
       @param y y coord of lower left corner of CD case
       @param width width of the case
       @param height of case 
     */
    public CDCaseWithCD(double x, double y, double width, double height)
    {
        //creates an empty CD case
	super(x,y,width,height);

	//outer ellipse of the CD
	Ellipse2D.Double outer = new Ellipse2D.Double(x+width/9.0+width*4.0/9*0.1,y+height*0.1/2,width*8.0/9*0.9,height*0.9);
	//inner middle ellipse of the CD
	Ellipse2D.Double inner = new Ellipse2D.Double(x+5.0*width/9-width*8.0/9/4,y+height/2.0-height/4.0,width*8.0/9/4*2,height/4.0*2);


	
        // put the CD components together
       
        GeneralPath  cd= this.get();
        cd.append(inner, false);
        cd.append(outer, false);
        
    }
}
