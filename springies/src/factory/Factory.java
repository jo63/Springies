package factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import simulation.Model;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public abstract class Factory {
	private Model myModel;
	public Model getModel()
	{
		return myModel;
	}
	/**
	 * iterates through the file passed in and creates the assemblies listed in the file 
	 * @param model : this parameter is the model of the simulation
	 * @param modelFile : This is the file with the data of which assemblies should be loaded into the model
	 */
	public void loadModel(Model model, File modelFile)
	{
		myModel = model;
		initMaps();
		try {
			Scanner input = new Scanner(modelFile);
			while (input.hasNext()) {
				Scanner line = new Scanner(input.nextLine());
				create(model, line);
			}

			input.close();
		}
		catch (FileNotFoundException e) {
			// should not happen because File came from user selection
			e.printStackTrace();
		}
	}
	/**
	 * initiates that maps that are used to map the keyword of what is being loaded into the assembly to 
	 * the command that loads the specified object into the assmebly
	 */
	public abstract void initMaps();
	/**
	 * creates the specified object and adds it to the model
	 * @param model: the model where the simulation takes place
	 * @param line: this is a Scanner which reads from the data file 
	 */
	public abstract void create(Model model, Scanner line);
	
}
