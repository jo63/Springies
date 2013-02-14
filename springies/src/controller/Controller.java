package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;
import simulation.Model;
import util.Location;


public class Controller {
	 
	private Model mySimulation;
	private Set<Integer> myKeys;
	private Map<Integer, KeyAction> myKeyActions;
	private Map<Integer, MouseAction> myMouseActions;
	private int lastMouseButton;
	
	private static final int LOAD_ASSEMBLY = KeyEvent.VK_N;
	private static final int CLEAR_ASSEMBLY = KeyEvent.VK_C;
	private static final int TOGGLE_GRAVITY = KeyEvent.VK_G;
	private static final int TOGGLE_VISCOSITY = KeyEvent.VK_V;
	private static final int TOGGLE_CENTER_OF_MASS = KeyEvent.VK_M;
	private static final int TOGGLE_WALL_ONE = KeyEvent.VK_1;
	private static final int TOGGLE_WALL_TWO = KeyEvent.VK_2;
	private static final int TOGGLE_WALL_THREE = KeyEvent.VK_3;
	private static final int TOGGLE_WALL_FOUR = KeyEvent.VK_4;
	private static final int INCREASE_UP = KeyEvent.VK_UP;
	private static final int INCREASE_DOWN = KeyEvent.VK_DOWN;
	private static final int INCREASE_RIGHT = KeyEvent.VK_RIGHT;
	private static final int INCREASE_LEFT = KeyEvent.VK_LEFT;
	
	
	
	public Controller()
	{
		myKeyActions = new HashMap<Integer, KeyAction>();
		myMouseActions = new HashMap<Integer, MouseAction>();
	}
	
	public void setModel(Model model)
	{
		initMap(model);
		myKeys = model.getCanvas().getKeysPressed();
		lastMouseButton = model.getCanvas().getMouseButton();
	}
	
	private void initMap(Model model)
	{
		myKeyActions.put(LOAD_ASSEMBLY, new LoadAssembly(model));
		myKeyActions.put(CLEAR_ASSEMBLY, new ClearAssembly(model));
		myKeyActions.put(TOGGLE_GRAVITY, new ToggleGravity(model));
		myKeyActions.put(TOGGLE_VISCOSITY, new ToggleViscosity(model));
		myKeyActions.put(TOGGLE_CENTER_OF_MASS, new ToggleCenterOfMass(model));
		myKeyActions.put(TOGGLE_WALL_ONE, new ToggleWallRepulsion(model, 1));
		myKeyActions.put(TOGGLE_WALL_TWO, new ToggleWallRepulsion(model, 2));
		myKeyActions.put(TOGGLE_WALL_THREE, new ToggleWallRepulsion(model, 3));
		myKeyActions.put(TOGGLE_WALL_FOUR, new ToggleWallRepulsion(model, 4));
		
		myMouseActions.put(MouseEvent.BUTTON1, new CreateSpring(model));
		myMouseActions.put(MouseEvent.NOBUTTON, new RemoveSpring(model));
		
	}
	public void performAction()
	{
		if (myMouseActions.containsKey(lastMouseButton))
		{
			myMouseActions.get(lastMouseButton).performAction();
		}
		
		for(Integer key : myKeys)
		{
			if(myKeyActions.containsKey(key)){
				myKeyActions.get(key).performAction();
			}
		}
	}
	
}
