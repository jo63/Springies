package physicsForces;

import simulation.Mass;
import util.Vector;

public class Viscosity {

	
	private Vector myViscosity;
	
	public Viscosity(Vector viscosity)
	{
		setViscosity(viscosity);
	}

	public Vector getViscosity() {
		return myViscosity;
	}

	public void setViscosity(Vector Viscosity) {
		this.myViscosity = Viscosity;
	}
	
	public void setDirection(double direction)
	{
		double mag = myViscosity.getMagnitude();
		myViscosity = new Vector(direction, mag);
	}
}
