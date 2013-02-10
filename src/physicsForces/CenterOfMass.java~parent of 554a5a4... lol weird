package physicsForces;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import simulation.Mass;
import util.Location;
import util.Vector;
import view.Canvas;

public class CenterOfMass extends Force{

	private Point myCenterOfMass;
	private double myMagnitude;
	private double myExponent;
	private double distFromCenterOfMass;
	private double COMAngle; 

	public CenterOfMass()
	{
		super(new Vector(0,0));
		myMagnitude = 0;
		myExponent = 0;
	}

	public CenterOfMass(double magnitude, double exponent)
	{
		super(new Vector(0,0));
		myMagnitude = magnitude;
		myExponent = exponent;
	}

	public double getExponent()
	{
		return myExponent;
	}

	public void setCenterMassPosition(List<Mass> massList)
	{
		if(massList == null)
		{
			return;
		}
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

	public void massInitialize(Mass mass)
	{
		distance(mass);
		getAngleForCOM(mass);
	}
    private void getAngleForCOM(Mass mass)
    {
    	double xDiff = myCenterOfMass.x - mass.getX();
    	double yDiff = myCenterOfMass.y - mass.getY();
    		
    	COMAngle = Vector.angleBetween(xDiff,yDiff);
    }

	private void distance(Mass mass)
	{
		distFromCenterOfMass = new Location(myCenterOfMass.x, myCenterOfMass.y).distance(mass.getX(), mass.getY());
	}
	public Vector returnForce()
	{
		double magnitude = myMagnitude/Math.pow(distFromCenterOfMass/100,myExponent);
		return new Vector(COMAngle, magnitude);
	}
}
