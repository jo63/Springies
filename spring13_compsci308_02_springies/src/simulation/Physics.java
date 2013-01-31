package simulation;

import util.*;
import physicsForces.*;

public class Physics {

	private Gravity myGravity;
	private Viscosity myViscosity;
	private CenterOfMass myCenterMass;
	//private wallRepulsion = ??
	
	public Physics()
	{
		myGravity = new Gravity();
		myViscosity = new Viscosity(new Vector());
		myCenterMass = new CenterOfMass();
		
	}
	
	public Gravity getGravity()
	{
		return myGravity;
	}
	public CenterOfMass getCenterMass()
	{
		return myCenterMass;
	}
	public Viscosity getViscosity()
	{
		return myViscosity;
	}
	
	public void print()
	{
		System.out.println("dir" + myGravity.getGravity().getDirection() + "magnitude" + myGravity.getGravity().getMagnitude());
		System.out.println("viscosity" + myViscosity.getViscosity());
	}
	
}
