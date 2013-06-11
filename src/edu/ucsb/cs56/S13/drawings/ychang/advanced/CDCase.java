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
   A vector drawing of a CD case that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Yun Suk Chang
   @version for CS56, Spring 13, UCSB
   
*/
public class CDCase extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of CD case
       @param y y coord of lower left corner of CD case
       @param width width of the case
       @param height of case 
     */
    public CDCase(double x, double y, double width, double height)
    {
    
       //frame of the CD case 
        Rectangle2D.Double  frame= 
            new Rectangle2D.Double(x, y,
                          width, height);
        
	//line that separates big rectangle from small one of the CD case
        Line2D.Double divide = 
            new Line2D.Double (x+width/9.0, y,
                               x + width/9.0, y+height);
	//outer ellipse of the CD case
	Ellipse2D.Double outer = new Ellipse2D.Double(x+width/9.0,y,width*8.0/9,height);
	//inner ellipse of the CD case
	Ellipse2D.Double inner = new Ellipse2D.Double(x+4.0*width/9,y+3*height/8.0,width*8.0/9/4,height/4.0);


	
        // put the CD case components together
       
        GeneralPath  cdCase= this.get();
        cdCase.append(frame, false);
        cdCase.append(divide, false);
        cdCase.append(inner, false); 
	cdCase.append(outer,false);
        
    }
}
