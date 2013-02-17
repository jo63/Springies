package factory;

import java.util.Scanner;
import physicsForces.*;
import util.Vector;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *These are the commands used to create physics objects
 */
public abstract class PhysicsCommand {

	/**
	 * This method returns the force that is created
	 * @param line is the line in the scanner that is being read
	 * @return the force that is being created
	 */
	public abstract Force returnForce(Scanner line);
		
	
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Creates gravity
 */
class GravityCommand extends PhysicsCommand{
	/**
	 * finds the direction and magnitude of the gravity and returns the gravity
	 */
	public Gravity returnForce(Scanner line) {
		double direction = line.nextDouble();
        double magnitude = line.nextDouble();
        return new Gravity(new Vector(direction, magnitude));
	}
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Creates Viscosity
 */
class ViscosityCommand extends PhysicsCommand{
	/**
	 * returns the viscosity
	 */
	public Viscosity returnForce(Scanner line) {
		return new Viscosity(new Vector(0, line.nextDouble()));
	}
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Creates Center of Mass
 */
class CenterOfMassCommand extends PhysicsCommand{
	
	/**
	 *reads in the magnitude and exponent for the center of mass and returns the center of mass
	 */
	public CenterOfMass returnForce(Scanner line) {
		double magnitude = line.nextDouble();
    	double exponent = line.nextDouble();
    	return new CenterOfMass(magnitude, exponent);
	}
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Creates Wall Repulsion
 */
class WallRepulsionCommand extends PhysicsCommand {
	public static final int TOP_ID = 1;
	public static final int RIGHT_ID = 2;
	public static final int BOTTOM_ID = 3;
	public static final int LEFT_ID = 4;
	/**
	 * defualt constructor for wallRepulsionCommand
	 */
	public WallRepulsionCommand() {
	}
	/**
	 * Returns the correct type of wall repulsion
	 * @param line is the line that the scanner is reading
	 * @param id tells which wall the wall repulsion is being created for
	 * @return returns the wall repulsion
	 */
	public WallRepulsion returnForce(Scanner line, int id) {
		double magnitude = line.nextDouble();
		double exponent = line.nextDouble();
		switch(id){
			case TOP_ID: return new TopWall(magnitude, exponent);
			case RIGHT_ID:	return new RightWall(magnitude, exponent);
			case BOTTOM_ID:	return new BottomWall(magnitude, exponent); 
			case LEFT_ID:	return new LeftWall(magnitude, exponent); 
			default: break;				
		}
		return null;    
	}
	
	/**
	 * this method is not used
	 * @return nothing is returned
	 */
	@Deprecated
	public Force returnForce(Scanner line) {
		return new Force();
	}
}
	
	
