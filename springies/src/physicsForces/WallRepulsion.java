package physicsForces;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<Boolean> validWalls = new ArrayList<Boolean>();
	
	public WallRepulsion() {

	}

	public void addWall(int id, double magnitude, double exponent)
	{
		Value temp = new Value(magnitude, exponent);
		myWalls.put(new Integer(id), temp);
	}
	public void toggleWalls(int id)
	{
		Boolean temp = validWalls.get(id);
		validWalls.set(id, !temp);
	}
	private void distance(Mass mass)
	{
		for(Integer id : myWalls.keySet())
		{	
			switch(id.intValue())
			{
				case 1: if(!validWalls.get(1)) {
					this.sum(generateVector(mass.getY(), id));//top
				} break;
				case 2: if(!validWalls.get(2)){
					this.sum(generateVector(getBounds().getWidth() - mass.getX(), id));
				} break;//right
				case 3: if(!validWalls.get(3)){
					this.sum(generateVector(getBounds().getHeight() - mass.getY(), id)); //bottom
				} break;
				case 4: if(!validWalls.get(4)){
					this.sum(generateVector(mass.getX(), id)); 
				} break;//left
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
	
	public Vector returnForce()
	{
		return this;
	}

}
