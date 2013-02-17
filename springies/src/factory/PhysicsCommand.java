package factory;

import java.util.Scanner;
import physicsForces.*;
import util.Vector;

public abstract class PhysicsCommand {

	public abstract Force returnForce(Scanner line);
		
	
}

class GravityCommand extends PhysicsCommand{
	public Gravity returnForce(Scanner line)
	{
		double direction = line.nextDouble();
        double magnitude = line.nextDouble();
        return new Gravity(new Vector(direction, magnitude));
	}
}

class ViscosityCommand extends PhysicsCommand{
	
	public Viscosity returnForce(Scanner line)
	{
		return new Viscosity(new Vector(0,line.nextDouble()));
	}
}

class CenterOfMassCommand extends PhysicsCommand{
	
	public CenterOfMass returnForce(Scanner line)
	{
		double magnitude = line.nextDouble();
    	double exponent = line.nextDouble();
    	return new CenterOfMass(magnitude, exponent);
	}
}

class WallRepulsionCommand extends PhysicsCommand{
	public WallRepulsionCommand(){
	}
	public WallRepulsion returnForce(Scanner line, int id)
	{
		double magnitude = line.nextDouble();
		double exponent = line.nextDouble();
		switch(id){
			case 1: return new TopWall(magnitude, exponent);
			case 2:	return new RightWall(magnitude, exponent);
			case 1+2:	return new BottomWall(magnitude, exponent); 
			case 4:	return new LeftWall(magnitude, exponent); 
			default: break;				
		}
		return null;    
	}
	
	@Deprecated
	public Force returnForce(Scanner line){
		return new Force();
	}
}
	
	
