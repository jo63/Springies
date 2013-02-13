package factory;

import java.util.Scanner;
import physicsForces.*;
import util.Vector;

public abstract class PhysicsCommand {

	public abstract Force getCommand(Scanner line);
}

class GravityCommand extends PhysicsCommand{
	public Gravity getCommand(Scanner line)
	{
		double direction = line.nextDouble();
        double magnitude = line.nextDouble();
        return new Gravity(new Vector(direction, magnitude));
	}
}

class ViscosityCommand extends PhysicsCommand{
	
	public Viscosity getCommand(Scanner line)
	{
		return new Viscosity(new Vector(0,line.nextDouble()));
	}
}

class CenterOfMassCommand extends PhysicsCommand{
	
	public CenterOfMass getCommand(Scanner line)
	{
		double magnitude = line.nextDouble();
    	double exponent = line.nextDouble();
    	return new CenterOfMass(magnitude, exponent);
	}
}
	
	
