package physicsForces;

import util.Vector;

public class Gravity extends Force{
	private static final int MY_DIRECTION = 90;
	
	public Gravity()
	{
		
	}
	public void setGravity(Vector gravity)
	{
		myGravity = gravity; 
	}
	public Vector getGravity()
	{
		return myGravity;
	}
}
