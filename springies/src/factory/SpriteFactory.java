package factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import simulation.Mass;
import simulation.Model;



/**
 * XXX
 * 
 * @author Robert C. Duvall
 */
public class SpriteFactory extends Factory{
	
	private static final String MASS_KEYWORD = "mass";
	private static final String SPRING_KEYWORD = "spring";
	private static final String MUSCLE_KEYWORD = "muscle";
    Map<String, SpriteCommand> spriteCreator = new HashMap<String, SpriteCommand>();

	Map<Integer, Mass> myMasses = new HashMap<Integer, Mass>();

	/**
	 * XXX.
	 */
	public Map<Integer, Mass> getMasses()
	{
		return myMasses;
	}
	@Override
	public void initMaps() {
		spriteCreator.put(MASS_KEYWORD, new MassCommand(myMasses));
		spriteCreator.put(SPRING_KEYWORD, new SpringCommand(myMasses));
		spriteCreator.put(MUSCLE_KEYWORD, new MuscleCommand(myMasses));
	}
	
	@Override
	public void create(Model model, Scanner line)
	{
		if (line.hasNext()) {
			String type = line.next();
			if(spriteCreator.containsKey(type))
			{
				model.add(spriteCreator.get(type).getCommand(line));
			}
		}
	}
}
