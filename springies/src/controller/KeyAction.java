package controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import factory.SpriteFactory;

import physicsForces.*;
import simulation.Model;
import view.Canvas;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public abstract class KeyAction {
	private Map<String, Force> myForces;
	private Canvas myCanvas;

	/**
	 * Creates a keyAction object that knows the model and the canvas where the simulation
	 * takes place.  A map of string to Force is also created so that the keyAction has a 
	 * map that contains all the forces and labels for the forces.
	 * @param model: passes in the model where the simulation takes place
	 */
	public KeyAction(Model model)
	{
		myForces = model.getPhysics().getForces();
		myCanvas = model.getCanvas();

	}

	/**
	 * This is an abstract method that is used in the subclasses to carry out the action
	 * that happens based on a certain press of a button.
	 */
	public abstract void performAction();

	/**
	 * Returns the map of strings (labels) to the corresponding force object
	 * @return: the map of strings to forces
	 */
	public Map<String, Force> getForces()
	{
		return myForces;
	}
	/**
	 * 
	 * @return: the canvas where the simulation takes place
	 */
	public Canvas getCanvas()
	{
		return myCanvas;
	}
}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends keyAction
 *Loads a new assembly when "n" is pressed
 */
class LoadAssembly extends KeyAction
{
	/**
	 * creates a loadAssembly object that has the model where the simulation occurs
	 * @param model: this is the model where the simulation occurs
	 */
	public LoadAssembly(Model model) {
		super(model);
	}

	/**
	 * Overrides the performAction from keyAction
	 * gets the canvas from the model and calls the loadAssembly method from 
	 * the canvas to load a new assembly into the simulation
	 */
	@Override
	public void performAction() {
		getCanvas().loadModel();
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *clears the assembly if "c" is pressed
 */
class ClearAssembly extends KeyAction
{
	Model myModel;
	/**
	 * creates a ClearAssembly that has the model where the simulation takes place
	 * @param model: the model where the simulation takes place
	 */
	public ClearAssembly(Model model) {
		super(model);
		myModel = model;
	}

	/**
	 * Overrides the performAction from KeyAction
	 * calls the clear method from the model.  This clears the list of masses and
	 * the list of springs that exist in the model
	 */
	@Override
	public void performAction() {
		myModel.clear();
	}
}

class ToggleForce extends KeyAction{

	private String myId;
	public ToggleForce(Model model, String id) {
		super(model);
		myId = id;
	}
	@Override
	public void performAction() {
		if(getForces().get(myId) != null)
			(getForces().get(myId)).toggleForce();
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *Increases the size of the bounds if the up arrow is pressed
 */
class changeBounds extends KeyAction
{

	public static final int INCREASE_FACTOR = 10;
	private Map<String, Integer> boundMap;
	private String myId;
	private Dimension myDimension;

	public changeBounds(Model model, String id) {
		super(model);
		myDimension = model.getBounds();
		myId = id;
		boundMap = new HashMap<String, Integer>();
		initBoundMap();
	}

	public void initBoundMap(){
		boundMap.put("increase", INCREASE_FACTOR);
		boundMap.put("decrease", -INCREASE_FACTOR);
	}

	/**
	 * if the up arrow is pressed, increase the width and the height of the dimensions of the canvas by 10
	 */
	@Override
	public void performAction() {
		double width = myDimension.getWidth();
		double height = myDimension.getSize().getHeight();
		System.out.println("factor" + boundMap.get(myId));
		myDimension.setSize(width + boundMap.get(myId), 
				height + boundMap.get(myId));
	}
}










