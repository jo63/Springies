package simulation;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import physicsForces.CenterOfMass;
import physicsForces.Gravity;
import physicsForces.Viscosity;
import physicsForces.WallRepulsion;
import util.Vector;


/**
 * XXX
 * 
 * @author Junho Oh & Ryan Fishel
 */


public class PhysicsFactory extends Factory{
    // data file keywords
    private static final String GRAVITY_KEYWORD = "gravity";
    private static final String VISCOSITY_KEYWORD = "viscosity";
    private static final String CENTERMASS_KEYWORD = "centermass";
    private static final String WALL_KEYWORD = "wall";
    private Physics myPhysics;

    /**
     * XXX.
     * Could refactor this so that it uses a for loop instead of multiple if statements
     */
    public Physics loadModel (File modelFile) {
    	myPhysics = new Physics();
    	//myFactory = factory; //for later 
        try {
            Scanner input = new Scanner(modelFile);
            while (input.hasNext()) {
                Scanner line = new Scanner(input.nextLine());
                if (line.hasNext()) {
                    String type = line.next();
                    if (GRAVITY_KEYWORD.equals(type)) {
                        myPhysics.addForce(type, (gravityCommand(line)));
                    }
                    else if (VISCOSITY_KEYWORD.equals(type)) {
                        myPhysics.addForce(type, (viscosityCommand(line)));
                    }
                    else if(CENTERMASS_KEYWORD.equals(type))
                    {
                    	myPhysics.addForce(type, centerMassCommand(line));
                    }
                    else if(WALL_KEYWORD.equals(type))
                    {
                    	myPhysics.addForce(type, wallRepulsionCommand(line, myPhysics.getWall()));
                    }
                }
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            // should not happen because File came from user selection
            e.printStackTrace();
        }
        
        return myPhysics;
    }

    // create gravity from formatted data
    private Gravity gravityCommand (Scanner line) {
        double direction = line.nextDouble();
        double magnitude = line.nextDouble();
        return new Gravity(new Vector(direction, magnitude));
    }
    
    private Viscosity viscosityCommand(Scanner line)
    {
    	return new Viscosity(new Vector(0,line.nextDouble()));
    }
    
    private CenterOfMass centerMassCommand(Scanner line)
    {
    	double magnitude = line.nextDouble();
    	double exponent = line.nextDouble();
    	return new CenterOfMass(magnitude, exponent);
    }
    private WallRepulsion wallRepulsionCommand(Scanner line, WallRepulsion wall)
    {
    	int id = line.nextInt();
    	double magnitude = line.nextDouble();
    	double exponent = line.nextDouble();

    	wall.addWall(id, magnitude, exponent);
    	
    	return wall;
    }
    
}
