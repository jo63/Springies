package physicsForces;

import simulation.Mass;
import util.Vector;

public class Gravity extends Force{
	
	
	public Gravity(Vector gravity)
	{
		super(gravity);
	}

	@Override
	public Vector returnForce() {
		return this;
	}


}
