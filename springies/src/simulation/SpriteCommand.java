package simulation;



import java.util.Map;
import java.util.Scanner;


import util.Sprite;

public abstract class SpriteCommand {
	private Map<Integer, Mass> myMasses;
	
	public SpriteCommand(Map<Integer, Mass> masses)
	{
		myMasses = masses;
	}
	
	public abstract Sprite getCommand(Scanner line);
	
	public Map<Integer, Mass> getMasses()
	{
		return myMasses;
	}
}

class MassCommand extends SpriteCommand{
	public MassCommand(Map<Integer, Mass> masses){
		super(masses);
	}
	
	public Mass getCommand (Scanner line) {
		int id = line.nextInt();
		double x = line.nextDouble();
		double y = line.nextDouble();
		double mass = line.nextDouble();
		Mass result;
		if(mass < 0 ){
			result = new FixedMass(x,y,mass);
		}
		else{
			result = new Mass(x, y, mass);
		}
		getMasses().put(id,  result);
		return result;
	}
	
}

class MuscleCommand extends SpriteCommand
{
	public MuscleCommand(Map<Integer, Mass> masses)
	{
		super(masses);
	}
	@Override
	public Muscle getCommand(Scanner line) {
		Mass m1 = getMasses().get(line.nextInt());
		Mass m2 = getMasses().get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		double amplitude = line.nextDouble();

		return new Muscle(m1, m2, restLength, ks, amplitude);
	}

}
class SpringCommand extends SpriteCommand
{
	public SpringCommand(Map<Integer, Mass> masses)
	{
		super(masses);
	}
	
	public Spring getCommand(Scanner line) {
		Mass m1 = getMasses().get(line.nextInt());
		Mass m2 = getMasses().get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		return new Spring(m1, m2, restLength, ks);
	}
}


	
