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
@author Austin Phillips
@version S13, CS56, UCSB
*/

public class Body extends GeneralPathWrapper implements Shape
{
    /**
       @param x the lower left coord
       @param y the lower left coord
       @param width of the body
       @param length of the body
    */
    public Body(double x, double y, double length, double width)
    {
	double bodyWidth=width;
	double bodyLength=width*2;
	double leg=.75*width;
	Rectangle2D.Double body = new Rectangle2D.Double(x,y-width,bodyLength,bodyWidth);
	Rectangle2D.Double firstLeg = new Rectangle2D.Double(x,y,bodyLength*.1,leg);
	Rectangle2D.Double secondLeg = new Rectangle2D.Double(x+bodyLength*.25,y,bodyLength*.1,leg);
	Rectangle2D.Double thirdLeg = new Rectangle2D.Double(x+bodyLength*.75,y,bodyLength*.1,leg);
	Rectangle2D.Double fourthLeg = new Rectangle2D.Double(x+bodyLength*.9,y,bodyLength*.1,leg);
	Ellipse2D.Double head = new Ellipse2D.Double(x-width*.75,y-width*.75, bodyWidth*.8,bodyWidth*.6);


	GeneralPath fullBody = this.get();
	fullBody.append(body,false);
	fullBody.append(firstLeg,false);
	fullBody.append(secondLeg,false);
	fullBody.append(thirdLeg,false);
	fullBody.append(fourthLeg,false);
	fullBody.append(head,false);
    }
}
