package simulation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.*;
import physicsForces.*;

public class Physics {

	//list of forces
	//private Map<String, Force> myForces;
	private Gravity myGravity;
	private Viscosity myViscosity;
	private CenterOfMass myCenterMass;
	private List<WallRepulsion> myWalls;
	
	public Physics()
	{
		//myForces = new HashMap<String , Force>();
		myGravity = new Gravity(new Vector());
		myViscosity = new Viscosity(new Vector());
		myCenterMass = new CenterOfMass();
		myWalls = new ArrayList<WallRepulsion>();
	}
	public void setGravity(Gravity gravity)
	{
		myGravity = gravity;
	}
	public void setViscosity(Viscosity viscosity)
	{
		myViscosity = viscosity;
	}
	public void setCenterMassMagEx(double[] values)
	{
		myCenterMass.setValues(values);
	}
	public void addWall(WallRepulsion wall)
	{
		myWalls.add(wall);
	}
	public CenterOfMass getCenterOfMass()
	{
		return myCenterMass;
	}
	
	public void addForce(String ID, Force force)
	{
		//myForces.put(ID, force);
	}

	public Viscosity getViscosity()
	{
		return myViscosity;
	}
	public Gravity getGravity()
	{
		return myGravity;
	}
	public List<WallRepulsion> getWalls()
	{
		return myWalls;
	}
	
}
