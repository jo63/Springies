package factory;



import java.util.Map;
import java.util.Scanner;


import simulation.FixedMass;
import simulation.Mass;
import simulation.Muscle;
import simulation.Spring;
import util.Sprite;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *An abstraCt class that can be extended to create different types of sprites depending on what is specified in a data file
 */
public abstract class SpriteCommand {
	
	/**
	 * creates a SpriteCommand object and creates a map that maps and Integer to a Mass
	 * @param masses: a map of Integers (the id of the mass) to Masses
	 */
	public SpriteCommand()
	{
		
	}
	/**
	 *
	 * @param masses a map of masses to the value of the mass
	 * @param line a scanner that reads a data file
	 **/
	public abstract Sprite returnSprite(Scanner line, Map<Integer, Mass> masses);
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends SpriteCommand
 *Contains the commands to create a Mass
 */
class MassCommand extends SpriteCommand{
	/**
	 * Creates a MassCommand object
	 *
	 */
	public MassCommand(){
	}
	
	/**
	 * Reads the id, x position, y position, and mass from a file.
	 * If the mass is less than 0, a fixed mass is created in the position specified by the x and y positions
	 * that were read in.  Otherwise, a mass is created at the correct x and y positions.  The mass (or fixed mass) is put
	 * into a map of the id of the mass to the Mass or FixedMass object and returned.
	 * @param line: This is a Scanner which reads in lines from a data file
	 * @return: the mass (or fixed mass) that is created is returned  
	 **/
	public Mass returnSprite (Scanner line, Map<Integer, Mass> masses) {
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
		masses.put(id,  result);
		return result;
	}
	
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * Extends SpriteCommand
 * Contains the commands to create a muscle
 *
 */
class MuscleCommand extends SpriteCommand
{
	/**
	 * creates a MuslceCommand object
	 * 
	 */
	public MuscleCommand()
	{
	}
	/**
	 * The scanner reads in two ints which refer to masses that have been created, a rest length, a k value(the springiness of the 
	 * muscle), and an amplitude.  Using the values that were read in, a new muscle is created.
	 * @param line This is a Scanner which reads in lines from a data file
	 * @return The muscle that is created is returned
	 */
	@Override
	public Muscle returnSprite(Scanner line, Map<Integer, Mass> masses) {
		Mass m1 = masses.get(line.nextInt());
		Mass m2 = masses.get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		double amplitude = line.nextDouble();

		return new Muscle(m1, m2, restLength, ks, amplitude);
	}

}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * Extends SpriteCommand
 * Contains the commands to create a Spring
 *
 */
class SpringCommand extends SpriteCommand
{
	/**
	 * creates a Spring object
	 * 
	 */
	public SpringCommand()
	{
	}
	/**
	 * The scanner reads in two ints that represent masses that have already been created, a rest length, and a k value
	 * (the springiness of the spring).  A new Spring is then created and returned using the values that were read in.
	 * @param line: This is a Scanner which reads in lines from a data file
	 * @return: returns the Spring that was created
	 */
	public Spring returnSprite(Scanner line, Map<Integer, Mass> masses) {
		Mass m1 = masses.get(line.nextInt());
		Mass m2 = masses.get(line.nextInt());
		double restLength = line.nextDouble();
		double ks = line.nextDouble();
		return new Spring(m1, m2, restLength, ks);
	}
}


	
