package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import util.Vector;


/**
 * XXX
 * 
 * @author Junho Oh & Ryan Fishel
 */


public class LoadPhysicsConstants {
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
    	
        try {
            Scanner input = new Scanner(modelFile);
            while (input.hasNext()) {
                Scanner line = new Scanner(input.nextLine());
                if (line.hasNext()) {
                    String type = line.next();
                    if (GRAVITY_KEYWORD.equals(type)) {
                        myPhysics.getGravity().setGravity((gravityCommand(line)));
                    }
                    else if (VISCOSITY_KEYWORD.equals(type)) {
                        myPhysics.getViscosity().setViscosity((viscosityCommand(line)));
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
    private Vector gravityCommand (Scanner line) {
        double direction = line.nextDouble();
        double magnitude = line.nextDouble();
        return new Vector(direction, magnitude);
    }
    
    private double viscosityCommand(Scanner line)
    {
    	return line.nextDouble();
    }
    
    
}
