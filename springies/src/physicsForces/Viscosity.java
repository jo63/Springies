package physicsForces;

import simulation.Mass;
import util.Vector;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * 
 *
 */
public class Viscosity extends Force{
	
	/**
	 * Creates a Viscosity object
	 * @param viscosity: a vector that represents the viscosity force
	 */
	public Viscosity(Vector viscosity)
	{
		super(viscosity);
	}
	/**
	 * sets the direction of viscosity for the mass that is passed in
	 * @param mass: a mass that is used to determine the direction for the viscosity vector
	 */
	public void massInitialize(Mass mass)
	{
		this.setDirection(mass.getVelocity().getDirection()+180);
	}
}
