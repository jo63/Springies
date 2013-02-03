package physicsForces;

import simulation.Mass;
import util.Vector;

public class Gravity extends Vector{
	
	
	public Gravity(Vector gravity)
	{
		super(gravity);
	}

//	public Vector getForce()
//	{
//		return this;
//	}
	public void applyForce(Mass mass)
	{
		mass.applyForce(this);
	}
}
