package physicsForces;

import simulation.Mass;
import util.Vector;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * Viscosity force
 *
 */
public class Viscosity extends Force{
	
	/**
	 * Creates a Viscosity object
	 * @param viscosity a vector that represents the viscosity force
	 */
	public Viscosity(Vector viscosity)
	{
		super(viscosity);
	}
	/**
	 * sets the direction of viscosity for the mass that is passed in and scales the vector
	 * @param mass a mass that is used to determine the direction for the viscosity vector
	 */
	@Override
	public void massInitialize(Mass mass)
	{
		mass.getVelocity().scale(getForce().getMagnitude());
		getForce().setDirection((mass.getVelocity().getDirection()+180));
	}
}
