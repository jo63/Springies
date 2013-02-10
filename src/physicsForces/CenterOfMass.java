package physicsForces;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import simulation.Mass;
import util.Location;
import util.Vector;
import view.Canvas;

public class CenterOfMass {
	private static int DISTANCE_OFFSET = 100;
	private Point myCenterOfMass;
	private double myMagnitude;
	private double myExponent;
	private Canvas myCanvas;
	private double distanceFromCenter;
	private double angleFromCenter;
	

	public double getMagnitude()
	{
		return myMagnitude;
	}
	public Canvas getCanvas()
	{
		return myCanvas;
	}
	public CenterOfMass()
	{
		myMagnitude = 0;
		myExponent = 0;
	}
	
	public CenterOfMass(double magnitude, double exponent)
	{
		myMagnitude = magnitude;
		myExponent = exponent;
	}

	public void setCanvas(Canvas canvas) //kinda messed up...need to change
	{
		myCanvas = canvas;
	}

	public void setValues(double[] values)
	{
		setMagnitude(values[0]);
		setExponent(values[1]);
	}
	
	private void setExponent(double exponent)
	{
		myExponent = exponent;
	}
	public void setMagnitude(double magnitude)
	{
		myMagnitude = magnitude;
	}

	public void setCenterMassPosition(List<Mass> massList)
	{
		double totalMass = 0;
		double massXSum = 0;
		double massYSum = 0;
		
		for(Mass mass : massList)
		{
			massXSum += mass.getX()*Math.abs(mass.getMass());
			massYSum += mass.getY()*Math.abs(mass.getMass());
			totalMass += Math.abs(mass.getMass());
		}
		myCenterOfMass = new Point((int)(massXSum/totalMass), (int)(massYSum/totalMass));
	}
	
	public void draw(Graphics2D lolz)
	{
		//lolz.drawOval(myCenterOfMass.x, myCenterOfMass.y, 25, 25);
	}
    private double getAngleForCOM(Mass mass)
    {
    	/*Point M = new Point((int)this.getX(),(int)this.getY());
    	Vector v1 = new Vector(M, CM);
    	Vector v2 = new Vector(M, new Point(CM.x, M.y));*/
    	double xDiff = myCenterOfMass.x - mass.getX();
    	double yDiff = myCenterOfMass.y - mass.getY();
    		
    	return Vector.angleBetween(xDiff,yDiff);
    }

	private double distance(Mass mass)
	{
		return new Location(myCenterOfMass.x, myCenterOfMass.y).distance(mass.getX(), mass.getY());
	}
	
	public void initializeMass(Mass mass)
	{
		distanceFromCenter = distance(mass);
		angleFromCenter = getAngleForCOM(mass);
	}
	public Vector applyForce()
	{
		double distFromCenterOfMass = distanceFromCenter/DISTANCE_OFFSET;
		double angle = angleFromCenter;
		double magnitude = myMagnitude/Math.pow(distFromCenterOfMass,myExponent);
		return new Vector(angle, magnitude);
	}

}
