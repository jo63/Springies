package physicsForces;

import util.Vector;

public class Gravity {

	private Vector myGravity;
	
	public Gravity()
	{
		myGravity = new Vector();
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
