package simulation;

import java.io.File;

public abstract class Factory {

	//
	public void loadModel(Model model, File modelFile)
	{
		
	}
	public Physics loadModel(File modelFile)
	{
		return new Physics();
	}
	
	//private Map<String, Command> myCommands;
	
	
	

}
