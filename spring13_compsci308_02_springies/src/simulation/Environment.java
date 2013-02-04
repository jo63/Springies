package simulation;

import java.util.List;

import physicsForces.WallRepulsion;

public class Environment {
	
	public Environment() {
		// TODO Auto-generated constructor stub
		
//		myPhysics = physics;
//		myMasses = masses;
	}
	

	public void setEnvironment(Physics physics, List<Mass> masses)
	{
		
		physics.getCenterOfMass().setCenterMassPosition(masses);
		for(Mass m : masses)
		{
			for(WallRepulsion wall : physics.getWalls())
			{
				wall.applyForce(m);
			}
			
			physics.getGravity().applyForce(m);
			physics.getViscosity().applyForce(m);
			physics.getCenterOfMass().applyForce(m);
		}
	}
}
