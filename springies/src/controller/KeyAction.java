package controller;

import java.awt.Dimension;
import java.util.Map;

import physicsForces.*;
import simulation.Model;
import view.Canvas;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public abstract class KeyAction {
	private Model myModel;
	private Map<String, Force> myForces;
	public static final int INCREASE_FACTOR = 10;
	private Canvas myCanvas;

	/**
	 * Creates a keyAction object that knows the model and the canvas where the simulation
	 * takes place.  A map of string to Force is also created so that the keyAction has a 
	 * map that conatains all the forces and labels for the forces.
	 * @param model: passes in the model where the simulation takes place
	 */
	public KeyAction(Model model)
	{
		myModel = model;
		myForces = model.getPhysics().getForces();
		myCanvas = model.getCanvas();
		
	}
	
	/**
	 * This is an abstract method that is used in the subclasses to carry out the action
	 * that happens based on a certain press of a button.
	 */
	public abstract void performAction();
	/**
	 * 
	 * @return: the model of the simulation
	 */
	public Model getModel()
	{
		return myModel;
	}
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
	 * @return: the constant that the bounds are increased by
	 */
	public int getIncreaseFactor()
	{
		return INCREASE_FACTOR;
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
		getModel().getCanvas().loadAssembly();
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
	/**
	 * creates a ClearAssembly that has the model where the simulation takes place
	 * @param model: the model where the simulation takes place
	 */
	public ClearAssembly(Model model) {
		super(model);
	}

	/**
	 * Overrides the performAction from KeyAction
	 * calls the clear method from the model.  This clears the list of masses and
	 * the list of springs that exist in the model
	 */
	@Override
	public void performAction() {
		getModel().clear();
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * Extends KeyAction
 * Toggles the gravity on or off when "g" is pressed
 *
 */
class ToggleGravity extends KeyAction
{
	/**
	 * Creates a ToggleGravity object with the model where the simulation takes place
	 * @param model: the model where the simulation takes place
	 */
	public ToggleGravity(Model model) {
		super(model);
	}

	/**
	 * Overrides performAction from KeyAction
	 * If the gravity is on, it is turned off
	 * If the gravity is off, it is turned on
	 */
	@Override
	public void performAction() {
		if(getForces().get("gravity") != null)
		{
			((Gravity)(getForces().get("gravity"))).toggleForce();
		}
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *Toggles the viscosity on and off when "v" is pressed
 */
class ToggleViscosity extends KeyAction
{
	/**
	 * creates a ToggleViscosity object that has the model where the simulation takes place
	 * @param model: the model where the simulation takes place
	 */
	public ToggleViscosity(Model model) {
		super(model);
	}

	/**
	 * Overrides the performAction from KeyAction
	 * If the viscosity is on, it is turned off
	 * If the viscosity is off, it is turned on
	 */
	@Override
	public void performAction() {
		if(getForces().get("viscosity") != null)
		{
			((Viscosity)(getForces().get("viscosity"))).toggleForce();
		}
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *Toggles the center of mass on and off when "m" is pressed
 */
class ToggleCenterOfMass extends KeyAction
{
	/**
	 * creates a ToggleCenterOfMass object that has the model where the simulation takes place
	 * @param model
	 */
	public ToggleCenterOfMass(Model model) {
		super(model);
	}
	/**
	 * Overrides the performAction from KeyAction
	 * If the center of mass is on, it is turned off
	 * If the center of mass is off, it is turned on
	 */
	@Override
	public void performAction() {
		if(getForces().get("centermass") != null)
		{
			((CenterOfMass)(getForces().get("centermass"))).toggleForce();
		}
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *Toggles the wall repulsion on and off when "1", "2", "3", or "4" is pressed for that specific wall
 */
class ToggleWallRepulsion extends KeyAction
{
	private int myID;
	/**
	 * creates a ToggleWallRepulsion object which knows which wall to toggle
	 * @param model: the model where the simulation takes place
	 * @param id: the ID of the specific wall that is being toggled
	 */
	public ToggleWallRepulsion(Model model, int id) {
		super(model);
		myID = id;
	}
	@Override
	public void performAction() {
		if(getForces().get("wall") != null)
		{
			((WallRepulsion)(getForces().get("wall"))).toggleWalls(myID);
		}
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends KeyAction
 *Increases the size of the bounds if the up arrow is pressed
 */
class Increase extends KeyAction
{
	public Increase(Model model) {
		super(model);
	}

	/**
	 * if the up arrow is pressed, increase the width and the height of the dimensions of the canvas by 10
	 */
	@Override
	public void performAction() {
		Dimension temp = getCanvas().getSize();
		double width = temp.getWidth();
		double height = temp.getHeight();
		temp.setSize(width + getIncreaseFactor(), height + getIncreaseFactor());
	}
}
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * Extends KeyAction
 * Decreases the size of the bounds if the down arrow is pressed
 *
 */
class Decrease extends KeyAction
{
	public Decrease(Model model) {
		super(model);
	}

	/**
	 * if the down arrow is pressed, decrease the width and the height of the dimension of the canvas by 10
	 */
	@Override
	public void performAction() {
		Dimension temp = getCanvas().getSize();
		double width = temp.getWidth();
		double height = temp.getHeight();
		temp.setSize(width - getIncreaseFactor(), height - getIncreaseFactor());
	}
}









