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
	
	public CenterOfMass(int magnitude, int exponent)
	{
		myMagnitude = magnitude;
		myExponent = exponent;
	
		//;lkasdjf;lkajsdlf;j;lakjsdf;l
	}
	public double getExponent()
	{
		return myExponent;
	}
	
	public void calculateCenterOfMassPosistion(List<Mass> massList)
	{
		myCenterOfMass = new Point(calculateXCenterOfMass(massList), calculateYCenterOfMass(massList));
	}
	
	public int calculateXCenterOfMass(List<Mass> massList)
	{
		double totalMass = 0.0;
		double massSum = 0.0;
		for(Mass mass : massList)
		{
			massSum += mass.getX()*mass.getMass();
			totalMass += mass.getMass();
		}
		return (int)(massSum/totalMass);
	}
	
	public int calculateYCenterOfMass(List<Mass> massList)
	{
		double totalMass = 0.0;
		double massSum = 0.0;
		for(Mass mass : massList)
		{
			massSum += mass.getY()*mass.getMass();
			totalMass += mass.getMass();
		}
		return (int)(massSum/totalMass);
	}
	
	public double distance(Mass mass)
	{
		return new Location(myCenterOfMass.getX(), myCenterOfMass.getY()).distance(mass.getX(), mass.getY());
	}
	public void applyForce(Mass mass)
	{
		double distFromCenterOfMass = distance(mass);
		double xDiff = Math.abs(myCenterOfMass.getX() - mass.getX());
		double yDiff = Math.abs(myCenterOfMass.getY() - mass.getY());
		//figure out magnitude of force to apply
		mass.applyForce(new Vector((int)(Math.tan((xDiff)/(yDiff))), myMagnitude/Math.pow(distFromCenterOfMass,myExponent)));
	}
}
