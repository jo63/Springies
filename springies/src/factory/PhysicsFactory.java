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
    
    
    private Map<String, PhysicsCommand> physicsCreator = new HashMap<String, PhysicsCommand>();

    
    @Override
	public void initMaps() {
    	physicsCreator.put(GRAVITY_KEYWORD, new GravityCommand());
    	physicsCreator.put(VISCOSITY_KEYWORD, new ViscosityCommand());
    	physicsCreator.put(CENTERMASS_KEYWORD, new CenterOfMassCommand());
		
	}
    @Override
    public void create(Model model, Scanner line)
    {
    	if (line.hasNext()) {
            String type = line.next();
            if(physicsCreator.containsKey(type))
            {
            	model.add(type, physicsCreator.get(type).getCommand(line));
            }
            else if(WALL_KEYWORD.equals(type))
            {
            	model.add(type, wallRepulsionCommand(line, model.getPhysics().getWall())); //need to fix
            }
        }
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
