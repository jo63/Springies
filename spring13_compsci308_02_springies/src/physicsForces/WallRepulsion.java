package physicsForces;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import simulation.Mass;
import util.Location;
import util.Vector;

class Value
{
	double magnitude;
	double exponent;
	Value(double magnitude, double exponent)
	{
		this.magnitude = magnitude;
		this.exponent = exponent;
	}
	
}
public class WallRepulsion extends CenterOfMass {
	
    private Map<Integer, Value> myWalls = new HashMap<Integer, Value>();
    private Dimension myBounds;
    
    public static final int[] DIRECTIONS = 
    	{
    		90,
    		180,
    		270,
    		0
    	};
    
	//private int myID;
	public void setBounds(Dimension bounds)
	{
		myBounds = bounds;
	}
	
	public WallRepulsion() {

	}

	public void addWall(int id, double magnitude, double exponent)
	{
		Value temp = new Value(magnitude, exponent);
		myWalls.put(new Integer(id), temp);
	}
	
	private void distance(Mass mass)
	{
		for(Integer id : myWalls.keySet())
		{	
			switch(id.intValue())
			{
				case 1: this.sum(generateVector(mass.getY(), id)); break;//top
				case 2: this.sum(generateVector(myBounds.getWidth() - mass.getX(), id)); break;//right
				case 3: this.sum(generateVector(myBounds.getHeight() - mass.getY(), id)); break;//bottom
				case 4: this.sum(generateVector(mass.getX(), id)); break;//left
				default: break;
			}
		}
	}
	
	private Vector generateVector(double distanceFromWall, Integer id)
	{
		Vector result = new Vector(0,0);
		double magnitude = myWalls.get(id).magnitude;
		double exponent = myWalls.get(id).exponent;
		result.setDirection(DIRECTIONS[id.intValue()-1]);
		result.setMagnitude((magnitude)/(Math.pow(distanceFromWall, exponent)));
		
		return result;
	}
	@Override
	public void massInitialize(Mass mass)
	{
		this.reset();
		distance(mass);
	}
	
	@Override
	public Vector returnForce()
	{
		System.out.println(this.getDirection());
		return this;
	}
}
