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
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
class Value
{
	double magnitude;
	double exponent;
	/**
	 * creates a value for the wall repulsion based on the given magnitude and exponent
	 * @param magnitude: the magnitude of the wall repulsion force
	 * @param exponent: the exponent that determines how the force decays with distance
	 */
	Value(double magnitude, double exponent)
	{
		this.magnitude = magnitude;
		this.exponent = exponent;
	}
	
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public class WallRepulsion extends CenterOfMass {
	
    private Map<Integer, Value> myWalls = new HashMap<Integer, Value>();
    private List<Boolean> validWalls = new ArrayList<Boolean>();
	
    /**
     * creates a default wall repulsion
     */
	public WallRepulsion() {

	}
	
	/**
	 * adds the wall repulsion of a certain wall to a list of the wall repulsions for all the walls
	 * @param id: the ID of the specific wall
	 * @param magnitude: the magnitude of the force
	 * @param exponent: the exponent that determines how the force decays with distance
	 */
	public void addWall(int id, double magnitude, double exponent)
	{
		Value temp = new Value(magnitude, exponent);
		myWalls.put(new Integer(id), temp);
	}
	/**
	 * If the force for a certain wall is not valid, make it valid
	 * If the force for a certain wall is valid, make it not valid
	 * @param id: the ID of the specific wall 
	 */
	public void toggleWalls(int id)
	{
		Boolean temp = validWalls.get(id);
		validWalls.set(id, !temp);
	}
	/**
	 * This method takes in a Mass and finds the distance between that mass and a certain wall.  It then adds the vector created by
	 * the wall repulsion from each wall.
	 * @param mass: a Mass that is used to find the distance between where it is and a certain wall 
	 */
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
	
	/**
	 * This method takes in the distance that a mass is from a specific wall and returns a vector
	 * that represents the wall repulsion from that specific wall to a mass.
	 * @param distanceFromWall: the distance between a mass and a specific wall
	 * @param id: the specific wall that is applying the force
	 * @return: a vector that represents the wall repulsion
	 */
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
		return this;
	}

}
