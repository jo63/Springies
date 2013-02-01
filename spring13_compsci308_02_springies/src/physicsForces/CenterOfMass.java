package physicsForces;

import java.awt.Point;
import java.util.List;

import simulation.Mass;
import util.Location;
import util.Vector;

public class CenterOfMass {
		
	private Point myCenterOfMass;
	private double myMagnitude;
	private double myExponent;

	
	public CenterOfMass()
	{
		myMagnitude = 0;
		myExponent = 0;
	}
	
	public CenterOfMass(int magnitude, int exponent)
	{
		myMagnitude = magnitude;
		myExponent = exponent;
	}
	public double getExponent()
	{
		return myExponent;
	}
	public void setMagEx(double[] values)
	{
		setMagnitude(values[0]);
		setExponent(values[1]);
	}
	private void setExponent(double exponent)
	{
		myExponent = exponent;
	}
	private void setMagnitude(double magnitude)
	{
		myMagnitude = magnitude;
	}
	public double getMagnitude()
	{
		return myMagnitude;
	}
	public Point getCenterOfMassPosition()
	{
		return myCenterOfMass;
	}
	public void setCenterMassPosition(List<Mass> massList)
	{
		myCenterOfMass = new Point(calculateXCenterOfMass(massList), calculateYCenterOfMass(massList));
	}
	private int calculateXCenterOfMass(List<Mass> massList)
	{
		double totalMass = 0.0;
		double massSum = 0.0;
		for(Mass mass : massList)
		{
			massSum += mass.getX()*Math.abs(mass.getMass());
			totalMass += mass.getMass();
		}
		return (int)(massSum/totalMass);
	}
	
	private int calculateYCenterOfMass(List<Mass> massList)
	{
		double totalMass = 0.0;
		double massSum = 0.0;
		for(Mass mass : massList)
		{
			massSum += mass.getY()*Math.abs(mass.getMass());
			totalMass += mass.getMass();
		}
		return (int)(massSum/totalMass);
	}
	
//	public double distance(Mass mass)
//	{
//		return new Location(myCenterOfMass.getX(), myCenterOfMass.getY()).distance(mass.getX(), mass.getY());
//	}
//	
//	public void applyForce(Mass mass)
//	{
//		double distFromCenterOfMass = distance(mass);
//		double xDiff = Math.abs(myCenterOfMass.getX() - mass.getX());
//		double yDiff = Math.abs(myCenterOfMass.getY() - mass.getY());
//		//figure out magnitude of force to apply
//		double angle = (Math.tan((xDiff)/(yDiff)));
//		double magnitude = myMagnitude/Math.pow(distFromCenterOfMass,myExponent);
//		mass.applyForce(new Vector(angle, magnitude));
//	}
}