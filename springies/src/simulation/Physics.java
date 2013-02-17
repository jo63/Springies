package simulation;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.*;
import physicsForces.CenterOfMass;
import physicsForces.Force;
import physicsForces.WallRepulsion;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public class Physics {

	private Map<String, Force> myForces;
	
	/**
	 * creates a physics object with a map of the forces
	 */
	public Physics() {
		myForces = new HashMap<String, Force>();

	}
	/**
	 * adds a force and a label for that force to the map of forces
	 * @param forceType a string that labels the force that is added. Allows for the 
	 * forces to be accessed by entering a string that represents the force 
	 * @param force: A Force object, which is the superclass for all the forces.  This 
	 * allows the map to contain every type of force
	 */
	public void addForce(String forceType, Force force) {
		myForces.put(forceType, force);
	}
	
	/**
	 * returns the instance of the map of forces
	 * @return a map of labels to forces
	 */
	public Map<String, Force> getForces() {
		return myForces;
	}
	/**
	 * This method updates the position of the center of mass and the bounds for wall repulsion 
	 * @param massList: A list of all the masses that exist.  Used to determine the 
	 * center of mass
	 * @param bounds: The bounds of simulation. Needed for wall repulsion
	 */
	public void update(List<Mass> massList, Dimension bounds){
		for (Force force : myForces.values()) {
			if(force instanceof CenterOfMass) {
				((CenterOfMass)force).setCenterMassPosition(massList);
			}
			if(force instanceof WallRepulsion) {
				((WallRepulsion)(force)).setBounds(bounds);
			}
		}
	}

	/**
	 * This method returns a vector that is the sum of all the forces that act on the mass passed in
	 * @param m: a mass is passed in so that all the forces can correctly be applied to each mass
	 * @return a vector that is the sum of all the forces
	 */
	public Vector getEnvironmentVector(Mass m) {
		Vector result = new Vector();
		for (String id : myForces.keySet()) {
			if (myForces.get(id).isValid()) {
				myForces.get(id).massInitialize(m);
				result.sum(myForces.get(id).getForce());
			}
		}
		return result;
	}

}
