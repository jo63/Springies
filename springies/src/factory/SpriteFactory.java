package factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import simulation.Mass;
import simulation.Model;



/**
 * This class is the factory that is used to create sprites.
 * 
 * @author Robert C. Duvall, Ryan Fishel, and Kevin Oh
 */
public class SpriteFactory extends Factory{
	
	private static final String MASS_KEYWORD = "mass";
	private static final String SPRING_KEYWORD = "spring";
	private static final String MUSCLE_KEYWORD = "muscle";
    Map<String, SpriteCommand> spriteCreator = new HashMap<String, SpriteCommand>();

	Map<Integer, Mass> myMasses = new HashMap<Integer, Mass>();

	/**
	 * @return a map of masses to the value of the masses
	 */
	public Map<Integer, Mass> getMasses()
	{
		return myMasses;
	}
	/**
	 * creates a map of keywords to commands to create the specified sprite
	 */
	@Override
	public void initMaps() {
		spriteCreator.put(MASS_KEYWORD, new MassCommand());
		spriteCreator.put(SPRING_KEYWORD, new SpringCommand());
		spriteCreator.put(MUSCLE_KEYWORD, new MuscleCommand());
	}
	
	/**
	 * creates the specified sprite and adds it to the model
	 */
	@Override
	public void create(Model model, Scanner line)
	{
		if (line.hasNext()) {
			String type = line.next();
			if(spriteCreator.containsKey(type))
			{
				model.add(spriteCreator.get(type).returnSprite(line,myMasses));
			}
		}
	}
}
