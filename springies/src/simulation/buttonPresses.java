package simulation;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;

import physicsForces.CenterOfMass;
import physicsForces.Force;
import physicsForces.Gravity;

public class buttonPresses {
	
    private static final JFileChooser INPUT_CHOOSER = 
	            new JFileChooser(System.getProperties().getProperty("user.dir"));
	 
	private Model mySimulation;
	
	private static final int LOAD_ASSEMBLY = KeyEvent.VK_N;
	private static final int CLEAR_ASSEMBLY = KeyEvent.VK_C;
	private static final int TOGGLE_GRAVITY = KeyEvent.VK_G;
	private static final int TOGGLE_VISCOSITY = KeyEvent.VK_V;
	private static final int TOGGLE_CENTER_OF_MASS = KeyEvent.VK_M;
	private static final int TOGGLE_WALL_ONE = KeyEvent.VK_1;
	private static final int TOGGLE_WALL_TWO = KeyEvent.VK_2;
	private static final int TOGGLE_WALL_THREE = KeyEvent.VK_3;
	private static final int TOGGLE_WALL_FOUR = KeyEvent.VK_4;
	
	
	
	public buttonPresses(Set<Integer> keyPresses)
	{
		
		performAction(keyPresses);
	}
	
	public void performAction(Set<Integer> keyPresses)
	{
		for(Integer key : keyPresses)
		{
				loadAssembly(key);
				clearAssembly(key);
				toggleGravity(key);
				toggleViscosity(key);
				toggleCenterOfMass(key);
		}
	}
	
	public void loadAssembly(Integer key)
	{
		if(key == LOAD_ASSEMBLY)
			loadModel();
	}
	
	public void clearAssembly(Integer key)
	{
		if(key == CLEAR_ASSEMBLY)
		{
			// clear assembly
		}
	}
	
	public void toggleGravity(Integer key)
	{
		if(key == TOGGLE_GRAVITY)
		{
			Map<String, Force> forces = mySimulation.getPhysics().getForces();
			if(forces.get("gravity") != null)
			{
				Gravity g = (Gravity)(forces.get("gravity"));
				g.toggleForce();
			}
		}
	}
	
	public void toggleViscosity(Integer key)
	{
		if(key == TOGGLE_VISCOSITY)
		{
			
		}
	}
	
	public void toggleCenterOfMass(Integer key)
	{
		if(key == TOGGLE_CENTER_OF_MASS)
		{
			
		}
	}
	
	private void loadModel () {
        SpriteFactory factory = new SpriteFactory();
        int response = INPUT_CHOOSER.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
        	response = INPUT_CHOOSER.showOpenDialog(null);
            factory.loadModel(mySimulation, INPUT_CHOOSER.getSelectedFile());
            
        }
       
    }
}
