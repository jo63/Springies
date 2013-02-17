package controller;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import simulation.Model;
import view.Canvas;


public class Controller {
	 
	private Canvas myCanvas;
	private Set<Integer> myKeys;
	private Map<Integer, KeyAction> myKeyActions;
	private MouseAction myMouseActions;
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

	
	public Controller(Model model)
	{
		myCanvas = model.getCanvas();
		init(model);
		setKeysMouse();
	}
	
	private void setKeysMouse()
	{
		myKeys = myCanvas.getKeysPressed();
		lastMouseButton = myCanvas.getMouseButton();
	}
	private void init(Model model)
	{
		myKeyActions = new HashMap<Integer, KeyAction>();
		initKeyMap(model);
		myMouseActions = new MouseAction(model);
	}
	private void initKeyMap(Model model) {
		myKeyActions.put(LOAD_ASSEMBLY, new LoadAssembly(model));
		myKeyActions.put(CLEAR_ASSEMBLY, new ClearAssembly(model));
		myKeyActions.put(TOGGLE_GRAVITY, new ToggleForce(model, "gravity"));
		myKeyActions.put(TOGGLE_VISCOSITY, new ToggleForce(model, "viscosity"));
		myKeyActions.put(TOGGLE_CENTER_OF_MASS, new ToggleForce(model, "centermass"));
		myKeyActions.put(TOGGLE_WALL_TOP, new ToggleForce(model, "top"));
		myKeyActions.put(TOGGLE_WALL_RIGHT, new ToggleForce(model, "right"));
		myKeyActions.put(TOGGLE_WALL_BOTTOM, new ToggleForce(model, "bottom"));
		myKeyActions.put(TOGGLE_WALL_LEFT, new ToggleForce(model, "left"));
		myKeyActions.put(INCREASE, new changeBounds(model, "increase"));
		myKeyActions.put(DECREASE, new changeBounds(model, "decrease"));
	}
	public void performAction() {
		setKeysMouse();
		myMouseActions.setMouseButton(lastMouseButton);
		myMouseActions.performAction();
			
		for (Integer key : myKeys) {
			if(myKeyActions.containsKey(key)){
				
				myKeyActions.get(key).performAction();
				if (key == LOAD_ASSEMBLY){
					myCanvas.clearInput();
				}
			}
		}
	}
	
}
