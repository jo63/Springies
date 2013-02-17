package physicsForces;

import java.awt.Dimension;
import simulation.Mass;
import util.Vector;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Wall Repulsion superclass
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
	/**
	 * creates WallRepulsion with a given maginitude and exponent
	 * @param magnitude is the magnitude of the force
	 * @param exponent is the amount by which the wall repulsion decays with distance
	 */
	public WallRepulsion(double magnitude, double exponent) {
		super();
		myMagnitude = magnitude;
		myExponent = exponent;
	}
	/**
	 * 
	 * @return the magnitude of the wall repulsion
	 */
	public double getMagnitude() {
		return myMagnitude;
	}
	/**
	 * 
	 * @return the exponent of the wall repulsion
	 */
	public double getExponent() {
		return myExponent;
	}
	/**
	 * Sets the bounds for the force
	 * @param bounds passes in the bounds of the simulation
	 */
	public void setBounds(Dimension bounds) {
		myBounds = bounds;
	}
	/**
	 * returns the myBounds instance variable which is the area the 
	 * simulation takes place in
	 * @return: the area that the simulation is taking place in
	 */
	public Dimension getBounds() {
		return myBounds;
	}
	/**
	 * This method takes in the distance that a mass is from a specific wall and returns a vector
	 * that represents the wall repulsion from that specific wall to a mass.
	 * @return: a vector that represents the wall repulsion
	 */
	@Override
	public void massInitialize(Mass mass) {
			Vector result = new Vector(0,0);
			result.setDirection(returnDirection());
			result.setMagnitude(myMagnitude / 
					(Math.pow(distanceFromWall(mass), myExponent)));
			setForce(result);
	}
	/**
	 * 
	 * @return the direction of the wall's wall repulsion force
	 */
	public abstract double returnDirection();
	/**
	 * 
	 * @param mass that is being acted on by the wall repulsion
	 * @return the distance between the mass passed in and the wall
	 */
	public abstract double distanceFromWall(Mass mass);
		
}
