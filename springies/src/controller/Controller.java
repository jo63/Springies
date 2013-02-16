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
import view.Canvas;


public class Controller {
	 
	private Canvas myCanvas;
	private Set<Integer> myKeys;
	private Map<Integer, KeyAction> myKeyActions;
	private NewSpringHandler myMouseActions;
	private int lastMouseButton;
	
	private static final int LOAD_ASSEMBLY = KeyEvent.VK_N;
	private static final int CLEAR_ASSEMBLY = KeyEvent.VK_C;
	private static final int TOGGLE_GRAVITY = KeyEvent.VK_G;
	private static final int TOGGLE_VISCOSITY = KeyEvent.VK_V;
	private static final int TOGGLE_CENTER_OF_MASS = KeyEvent.VK_M;
	private static final int TOGGLE_WALL_TOP = KeyEvent.VK_1;
	private static final int TOGGLE_WALL_RIGHT = KeyEvent.VK_2;
	private static final int TOGGLE_WALL_BOTTOM = KeyEvent.VK_3;
	private static final int TOGGLE_WALL_LEFT = KeyEvent.VK_4;
	private static final int INCREASE = KeyEvent.VK_UP;
	private static final int DECREASE = KeyEvent.VK_DOWN;
	private static final int TOP_WALL = 1;
	private static final int RIGHT_WALL = 2;
	private static final int BOTTOM_WALL = 3;
	private static final int LEFT_WALL = 4;
	
	public Controller(Model model)
	{
		myCanvas = model.getCanvas();
		setKeysMouse(myCanvas);
		
	}
	
	private void setKeysMouse(Canvas canvas)
	{
		myKeys = myCanvas.getKeysPressed();
		lastMouseButton = myCanvas.getMouseButton();
	}
	private void init(Model model)
	{
		initKeyMap(model);
		myMouseActions = new NewSpringHandler(model);
	}
	private void initKeyMap(Model model)
	{
		myKeyActions.put(LOAD_ASSEMBLY, new LoadAssembly(model));
		myKeyActions.put(CLEAR_ASSEMBLY, new ClearAssembly(model));
		myKeyActions.put(TOGGLE_GRAVITY, new ToggleGravity(model));
		myKeyActions.put(TOGGLE_VISCOSITY, new ToggleViscosity(model));
		myKeyActions.put(TOGGLE_CENTER_OF_MASS, new ToggleCenterOfMass(model));
		myKeyActions.put(TOGGLE_WALL_TOP, new ToggleWallRepulsion(model, TOP_WALL));
		myKeyActions.put(TOGGLE_WALL_RIGHT, new ToggleWallRepulsion(model, RIGHT_WALL));
		myKeyActions.put(TOGGLE_WALL_BOTTOM, new ToggleWallRepulsion(model, BOTTOM_WALL));
		myKeyActions.put(TOGGLE_WALL_LEFT, new ToggleWallRepulsion(model, LEFT_WALL));
		myKeyActions.put(INCREASE, new changeBounds(model, "increase"));
		myKeyActions.put(DECREASE, new changeBounds(model, "decrease"));
	}
	public void performAction(){
		myMouseActions.setMouseButton(lastMouseButton);
		myMouseActions.performAction();
			
		for(Integer key : myKeys){
			if(myKeyActions.containsKey(key)){
				
				myKeyActions.get(key).performAction();
				if (key == LOAD_ASSEMBLY){
					myCanvas.clearInput();
				}
			}
		}
	}
	
}
