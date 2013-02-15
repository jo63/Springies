package physicsForces;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import simulation.Mass;
import util.Location;
import util.Vector;
import view.Canvas;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public class CenterOfMass extends Force{

	private Point myCenterOfMass;
	private double myMagnitude;
	private double myExponent;
	private double distFromCenterOfMass;
	private double COMAngle; 

	/**
	 * Creates a default center of mass with magnitude and exponent of 0
	 */
	public CenterOfMass()
	{
		super(new Vector(0,0));
		myMagnitude = 0;
		myExponent = 0;
	}

	/**
	 * Creates a center of mass with the specified magnitude and exponent (the exponent
	 * determines how the center of mass decays with the distance from the center of mass).
	 * @param magnitude: The magnitude of the force for the center of mass
	 * @param exponent: The exponent that determines how the center of mass force decays with 
	 * distance
	 */
	public CenterOfMass(double magnitude, double exponent)
	{
		super(new Vector(0,0));
		myMagnitude = magnitude;
		myExponent = exponent;
	}

	/**
	 * 
	 * @return: The exponent that determines how the center of mass decays with distance
	 */
	public double getExponent()
	{
		return myExponent;
	}

	/**
	 * Iterates through the list of all the masses in the simulation to determine
	 * the position of the center of mass
	 * @param massList: The list of all the masses in the simulation
	 */
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

	/**
	 * initializes the mass that is passed in to find the distance of the mass from the 
	 * center of mass and finds the angle between the mass and the center of mass
	 * @param mass: takes in  mass to find the distance from the center of mass and the 
	 * angle between the mass and the center of mass
	 */
	@Override
	public void massInitialize(Mass mass)
	{
		distance(mass);
		getAngleForCOM(mass);
	}
	/**
	 * finds the angle between a mass and the center of mass
	 * @param mass: takes in a mass to find the angle between the mass and the center of mass 
	 */
    private void getAngleForCOM(Mass mass)
    {
    	double xDiff = myCenterOfMass.x - mass.getX();
    	double yDiff = myCenterOfMass.y - mass.getY();
    		
    	COMAngle = Vector.angleBetween(xDiff,yDiff);
    }

    /**
     * finds the distance between the mass passed in and the center of mass
     * @param mass: passes in a mass to find the distance between the mass and the center
     * of mass
     */
	private void distance(Mass mass)
	{
		distFromCenterOfMass = new Location(myCenterOfMass.x, myCenterOfMass.y).distance(mass.getX(), mass.getY());
	}
	/**
	 * @return: returns a vector that represents the force of the center of mass
	 */
	public Vector returnForce()
	{
		double magnitude = myMagnitude/Math.pow(distFromCenterOfMass/100,myExponent);
		return new Vector(COMAngle, magnitude);
	}
}
