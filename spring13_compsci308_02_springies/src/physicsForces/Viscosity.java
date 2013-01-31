package physicsForces;

import simulation.Mass;
import util.Vector;

public class Viscosity {

	
	private double myViscosity;
	
	public Viscosity(double viscosity)
	{
		setViscosity(viscosity);
	}

	public double getViscosity() {
		return myViscosity;
	}

	public void setViscosity(double myViscosity) {
		this.myViscosity = myViscosity;
	}
	
	public void applyForce(Mass mass)
	{
		Vector velocity = mass.getVelocity();
		velocity.negate();
		velocity.scale(myViscosity);
		
	}
	
}
