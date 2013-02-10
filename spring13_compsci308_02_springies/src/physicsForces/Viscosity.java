package physicsForces;

import simulation.Mass;
import util.Vector;

public class Viscosity extends Vector{
	private double _Maginitude;
	
	public Viscosity(Vector viscosity, double magnitude)
	{
		super(viscosity);
		_Maginitude = magnitude;
	}
//
//	public Vector getViscosity() {
//		return this;
//	}
//	
	public void initializeMass(Mass mass)
	{
		if(mass.getAcceleration().getDirection() != 0)
			this.setDirection(-mass.getAcceleration().getDirection());
		this.scale(_Maginitude);
	}
	
	public Vector applyForce()
	{
		return this;
	}
}
