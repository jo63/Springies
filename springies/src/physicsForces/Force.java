package physicsForces;

import simulation.Mass;
import util.Vector;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Force superclass
 */
public class Force{
	
	private boolean isValid;
	private Vector myForce;
	/**
	 * default constructor for force.  Sets the force to be valid when it is created
	 */
	public Force() {
		isValid = true;
	}
	/**
	 * Creates a Force and initializes the vector for the force
	 * @param vector is the vector that represents the force
	 **/
	public Force(Vector force) {
		this();
		myForce = force;
	}
	
	/**
	 * returns the vector that is the sum of all the forces
	 * @return: A vector that is the sum of all the forces
	 */
	public Vector getForce() {
		return myForce;
	}
	
	/**
	 * sets the force.
	 * @param force the vector that represents the force
	 */
	public void setForce(Vector force) {
		myForce = force;
	}
	/**
	 * This method is overridden in the subclasses of force so that the forces are applied
	 * correctly to each mass
	 * @param mass: takes in a mass to initialize the forces so that
	 * they can be properly applied to that mass
	 */
	public void massInitialize(Mass mass) { }
	/**
	 * If the force is valid, it becomes not valid
	 * If the force is not valid, it becomes valid
	 */
	public void toggleForce() {
		isValid = !isValid;
	}
	
	/**
	 * 
	 * @return: returns whether the force should be applied or not
	 */
	public boolean isValid() {
		return isValid;
	}

}
