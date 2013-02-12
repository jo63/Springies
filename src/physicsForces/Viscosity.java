package physicsForces;

import simulation.Mass;
import util.Vector;

public class Viscosity extends Force{
	
	public Viscosity(Vector viscosity)
	{
		super(viscosity);
	}
	public void massInitialize(Mass mass)
	{
		this.setDirection(mass.getVelocity().getDirection()+180);
	}
}
