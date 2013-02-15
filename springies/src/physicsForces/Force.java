package physicsForces;

import java.awt.Dimension;

import simulation.Mass;
import util.Vector;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public class Force extends Vector{
	
	boolean isValid;
	
	public static final int[] DIRECTIONS = 
    	{
    		90,
    		180,
    		270,
    		0
    	};
	private Dimension myBounds;
	/**
	 * Creates a Force with bounds that is valid and allowed to be act
	 * @param vector
	 */
	public Force(Vector vector) {
		super(vector);
		myBounds = new Dimension();
		isValid = true;
	}
	/**
	 * Sets the bounds for the force
	 * @param bounds: Passes in the bounds of the simulation
	 */
	public void setBounds(Dimension bounds)
	{
		myBounds = bounds;
	}
	/**
	 * returns the myBounds instance variable which is the area the 
	 * simulation takes place in
	 * @return: the area that the simulation is taking place in
	 */
	public Dimension getBounds()
	{
		return myBounds;
	}
	/**
	 * returns the vector that is the sum of all the forces
	 * @return: A vector that is the sum of all the forces
	 */
	public Vector returnForce()
	{
		return this;
	}
	/**
	 * This method is overridden in the subclasses of force so that the forces are applied
	 * correctly to each mass
	 * @param mass: takes in a mass to initialize the forces so that
	 * they can be properly applied to that mass
	 */
	public void massInitialize(Mass mass){}
	/**
	 * If the force is valid, it becomes not valid
	 * If the force is not valid, it becomes valid
	 */
	public void toggleForce()
	{
		isValid = !isValid;
	}
	
	/**
	 * 
	 * @return: returns whether the force should be applied or not
	 */
	public boolean isValid()
	{
		return isValid;
	}

}
