package simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public abstract class Factory {

	public void loadModel(Model model, File modelFile)
	{
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
	public abstract void initMaps();
	public abstract void create(Model model, Scanner line);
	
}