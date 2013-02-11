package simulation;

import java.io.File;
import java.util.Map;

public abstract class Factory {
	//constants for sprite command
	private static final String MASS_KEYWORD = "mass";
	private static final String SPRING_KEYWORD = "spring";
	private static final String MUSCLE_KEYWORD = "muscle";
	
	//constants for physics command
	private static final String GRAVITY_KEYWORD = "gravity";
    private static final String VISCOSITY_KEYWORD = "viscosity";
    private static final String CENTERMASS_KEYWORD = "centermass";
    private static final String WALL_KEYWORD = "wall";
	
    //command maps
    Map<String, SpriteCommand> spriteCreator;
    Map<String, PhysicsCommand> physicsCreator;
    
    //has a instance of model
    private Model myModel;
    
    public Factory(Model model)
    {
    	myModel = model;
    	initMaps();
    }
    private void initMaps()
    {
    	//init sprite map
    	spriteCreator.put(MASS_KEYWORD, new SpriteCommand(this)); //can't instantiate abstract class...make all anonymous classes?
    	spriteCreator.put(SPRING_KEYWORD, new SpriteCommand(this));
    	spriteCreator.put(MUSCLE_KEYWORD, new SpriteCommand(this));
    	
    }
    
    
	public void loadModel(Model model, File modelFile)
	{
		
	}
	
	
	public Physics loadModel(File modelFile)
	{
		return new Physics();
	}
	
}
