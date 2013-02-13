package controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;
import simulation.Model;


public class ButtonController {
	 
	private Model mySimulation;
	private Set<Integer> myKeys;
	private Map<Integer, KeyAction> myActions;
	
	private static final int LOAD_ASSEMBLY = KeyEvent.VK_N;
	private static final int CLEAR_ASSEMBLY = KeyEvent.VK_C;
	private static final int TOGGLE_GRAVITY = KeyEvent.VK_G;
	private static final int TOGGLE_VISCOSITY = KeyEvent.VK_V;
	private static final int TOGGLE_CENTER_OF_MASS = KeyEvent.VK_M;
	private static final int TOGGLE_WALL_ONE = KeyEvent.VK_1;
	private static final int TOGGLE_WALL_TWO = KeyEvent.VK_2;
	private static final int TOGGLE_WALL_THREE = KeyEvent.VK_3;
	private static final int TOGGLE_WALL_FOUR = KeyEvent.VK_4;
	
	public ButtonController()
	{
		myActions = new HashMap<Integer, KeyAction>();
	}
	
	public void setModel(Model model)
	{
		initMap(model);
		myKeys = model.getCanvas().getKeysPressed();
	}
	
	private void initMap(Model model)
	{
		myActions.put(LOAD_ASSEMBLY, new LoadAssembly(model));
		myActions.put(CLEAR_ASSEMBLY, new ClearAssembly(model));
		myActions.put(TOGGLE_GRAVITY, new ToggleGravity(model));
		myActions.put(TOGGLE_VISCOSITY, new ToggleViscosity(model));
		myActions.put(TOGGLE_CENTER_OF_MASS, new ToggleCenterOfMass(model));
		
	}
	public void performAction()
	{
		for(Integer key : myKeys)
		{
			if(myActions.containsKey(key)){
				myActions.get(key).performAction();
			}
		}
	}
}
