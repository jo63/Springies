package simulation;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.*;
import physicsForces.Bounce;
import physicsForces.CenterOfMass;
import physicsForces.Force;
import physicsForces.WallRepulsion;

public class Physics {

	private Map<String, Force> myForces;
	private WallRepulsion myWall = new WallRepulsion();

	public Physics()
	{
		myForces = new HashMap<String, Force>();
		//addBounce();

	}
	private void addBounce()
	{
		Bounce b = new Bounce(new Vector());
		myForces.put("bounce", b);
	}
	public void addForce(String forceType, Force force)
	{
		//if(!(force instanceof WallRepulsion)) 
		myForces.put(forceType, force);
	}

	public Map<String, Force> getForces()
	{
		return myForces;
	}

	public WallRepulsion getWall()
	{
		return myWall;
	}
	public void update(List<Mass> massList, Dimension bounds)
	{
		if((myForces.get("centermass")) != null)
		{
			((CenterOfMass)(myForces.get("centermass"))).setCenterMassPosition(massList);
		}
		if((myForces.get("wall")) != null)
		{
			((WallRepulsion)(myForces.get("wall"))).setBounds(bounds);
		}
	}

	public Vector getEnvironmentVector(Mass m)
	{
		Vector result = new Vector();
		for(Force force : myForces.values())
		{
			/*if(gravityOk && force instanceof Gravity)
			{

			}*/
			if(force.isValid()){
				force.massInitialize(m);
				result.sum(force.returnForce());
			}
		}

		return result;
	}

}
