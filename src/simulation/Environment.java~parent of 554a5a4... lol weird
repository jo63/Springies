package simulation;

import java.util.List;
import physicsForces.Force;
import physicsForces.Gravity;
import util.Vector;

public class Environment {
	
	public Environment() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Vector getEnvironmentVector(Physics physics, Mass m)
	{
		Vector result = new Vector();
		for(Force force : physics.getForces().values())
		{
			force.massInitialize(m);

			result.sum(force.returnForce());
		}
		
		return result;
	}
}
