package physicsForces;

import util.Vector;

public class Gravity {

	private Vector myGravity;
	
	public Gravity()
	{
		myGravity = new Vector(0,0);
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
