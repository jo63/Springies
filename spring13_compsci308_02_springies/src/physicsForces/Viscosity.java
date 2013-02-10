package physicsForces;

import simulation.Mass;
import util.Vector;

public class Viscosity extends Vector{
	
	public Viscosity(Vector viscosity)
	{
		super(viscosity);
	}
//
//	public Vector getViscosity() {
//		return this;
//	}
//	
	private void setDirection(Mass mass)
	{
		this.setDirection(mass.getVelocity().getDirection());
	}
	
	public void applyForce(Mass mass)
	{
		setDirection(mass);
		mass.applyForce(this);
	}
}
