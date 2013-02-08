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
				m.applyForce(wall.applyForce());
			}
			
			m.applyForce(physics.getGravity().applyForce());
			m.applyForce(physics.getViscosity().applyForce());
			m.applyForce(physics.getCenterOfMass().applyForce());
		}
	}
}
