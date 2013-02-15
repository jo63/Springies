package factory;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import physicsForces.CenterOfMass;
import physicsForces.Gravity;
import physicsForces.Viscosity;
import physicsForces.WallRepulsion;
import simulation.Model;
import util.Vector;


/**
 * Reads in a data file and creates the specified forces
 * 
 * @author Ryan Fishel and Kevin Oh
 */


public class PhysicsFactory extends Factory{
    // data file keywords
    private static final String GRAVITY_KEYWORD = "gravity";
    private static final String VISCOSITY_KEYWORD = "viscosity";
    private static final String CENTERMASS_KEYWORD = "centermass";
    private static final String WALL_KEYWORD = "wall";
    
    
    private Map<String, PhysicsCommand> physicsCreator = new HashMap<String, PhysicsCommand>();

    /**
     * initializes a map that maps the keyword of a force to the command that creates that force
     */
    @Override
	public void initMaps() {
    	physicsCreator.put(GRAVITY_KEYWORD, new GravityCommand());
    	physicsCreator.put(VISCOSITY_KEYWORD, new ViscosityCommand());
    	physicsCreator.put(CENTERMASS_KEYWORD, new CenterOfMassCommand());
    	physicsCreator.put(WALL_KEYWORD, new WallRepulsionCommand(getModel()));
	}
    /**
     * creates the specified force and adds it to the model
     * @param model: this is the model where the simulation takes place
     * @param: line: this is a Scanner which reads in lines from a data file
     */
    @Override
    public void create(Model model, Scanner line)
    {
    	if (line.hasNext()) {
            String type = line.next();
            if(physicsCreator.containsKey(type))
            {
            	model.add(type, physicsCreator.get(type).getCommand(line));
            }
        }
    }
    
   

	
    
}
