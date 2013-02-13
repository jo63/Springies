package physicsForces;

import java.awt.Dimension;

import simulation.Mass;
import util.Vector;

public class Force extends Vector{
	
	boolean isValid;
	
	public static final int[] DIRECTIONS = 
    	{
    		90,
    		180,
    		270,
    		0
    	};
	private Dimension myBounds;
	
	public Force(Vector vector) {
		super(vector);
		myBounds = new Dimension();
	}
	public void setBounds(Dimension bounds)
	{
		myBounds = bounds;
	}
	public Dimension getBounds()
	{
		return myBounds;
	}
	public Vector returnForce()
	{
		return this;
	}
	public void massInitialize(Mass mass){}
	public void toggleForce()
	{
		isValid = !isValid;
	}
	public boolean isValid()
	{
		return isValid;
	}

}
