package simulation;

import java.awt.Point;

import util.*;
import physicsForces.*;

public class Physics {

	//
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
	
	public CenterOfMass getCenterOfMass()
	{
		return myCenterMass;
	}
	
	public Gravity getGravity()
	{
		return myGravity;
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
