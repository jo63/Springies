package physicsForces;

import java.awt.Dimension;
import simulation.Mass;
import util.Vector;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public abstract class WallRepulsion extends Force {
	
	private Dimension myBounds;
	private double myMagnitude;
	private double myExponent;
	
    /**
     * creates a default wall repulsion
     */
	public WallRepulsion()
	{
		
	}
	public WallRepulsion(double magnitude, double exponent) {
		super();
		myMagnitude = magnitude;
		myExponent = exponent;
	}
	public double getMagnitude(){
		return myMagnitude;
	}
	public double getExponent(){
		return myExponent;
	}
	/**
	 * Sets the bounds for the force
	 * @param bounds: Passes in the bounds of the simulation
	 */
	public void setBounds(Dimension bounds){
		myBounds = bounds;
	}
	/**
	 * returns the myBounds instance variable which is the area the 
	 * simulation takes place in
	 * @return: the area that the simulation is taking place in
	 */
	public Dimension getBounds(){
		return myBounds;
	}
	/**
	 * This method takes in the distance that a mass is from a specific wall and returns a vector
	 * that represents the wall repulsion from that specific wall to a mass.
	 * @param distanceFromWall: the distance between a mass and a specific wall
	 * @param id: the specific wall that is applying the force
	 * @return: a vector that represents the wall repulsion
	 */
	@Override
	public void massInitialize(Mass mass) {
			Vector result = new Vector(0,0);
			result.setDirection(returnDirection());
			result.setMagnitude(myMagnitude/(Math.pow(distanceFromWall(mass), myExponent)));
			setForce(result);
	}
	
	public abstract double returnDirection();
	public abstract double distanceFromWall(Mass mass);
		

}
