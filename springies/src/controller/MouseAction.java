package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import simulation.Mass;
import simulation.Model;
import simulation.Spring;
import util.Location;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *
 */
public abstract class MouseAction {

	private Model myModel;
	private Spring mySpring; //getter and setter. 
	private Mass myMass;
	/**
	 * creates a MouseAction object
	 * @param model: The model where the simulation takes place
	 */
	public MouseAction(Model model)
	{
		myModel = model;
	}
	/**
	 * sets a spring when the mouse is clicked
	 * @param spring: passes in a spring to be placed
	 */
	public void setSpring(Spring spring)
	{
		mySpring = spring;
	}
	/**
	 * 
	 * @param mass: sets a mass in the position of a mouse click
	 */
	public void setMass(Mass mass)
	{
		myMass = mass;
	}
	/**
	 * 
	 * @return: the model where the simulation takes place
	 */
	public Model getModel()
	{
		return myModel;
	}
	/**
	 * 
	 * @return: the Spring that is created on a mouse click
	 */
	public Spring getSpring()
	{
		return mySpring;
	}
	/**
	 * 
	 * @return: the mass that is created when the mouse is clicked
	 */
	public Mass getMass()
	{
		return myMass;
	}

	/**
	 * Performs the action of creating or removing a spring based on whether the mouse was clicked or released
	 */
	public abstract void performAction();

}

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Extends MouseAction
 *Deals with adding and removing a spring and a mass when the mouse is clicked and released.  Also, if the mouse is dragged, the 
 *mass will move to the mouse position causing the spring to rotate, extend, or contract
 */
class NewSpringHandler extends MouseAction {
	private boolean isCreated;
	private int myMouseButton;
	/**
	 * creates a NewSpringHandler object which sets the sets the state to be that a spring and a mass have not yet been created
	 * with a mouse click
	 * @param model: the model where the simulation takes place
	 */
	public NewSpringHandler(Model model)
	{
		super(model);
		isCreated = false;
	}
	/**
	 * sets the mouse button to be the button that was clicked
	 * @param button: the button that gets clicked
	 */
	public void setMouseButton(int button)
	{
		myMouseButton = button;
	}
	@Override
	public void performAction() {
		switch(myMouseButton)
		{
			case MouseEvent.BUTTON1: createMassSpring(); break;
			case MouseEvent.NOBUTTON: removeSpringMass(); break;
			default: break;
		}
		 
	}
	/**
	 * creates a mass and a spring if there is a mouse click.  If the mouse is being clicked and dragged, move the mass to the mouse
	 * position and rotate, extend, or contract the spring to keep it connected to the two masses that it was connected to.
	 */
	private void createMassSpring()
	{
		Point mouse = getModel().getCanvas().getMousePosition();
		if(!isCreated){
			List<Mass> masses = getModel().getMasses();
			Mass tempMass = new Mass(0,0,0); 
			Double temp = 1000.0;
			for(Mass m : masses)
			{
				Double dist = mouse.distance(new Location(m.getX(), m.getY()));
				if(dist < temp){
					tempMass = m;
					temp = dist;
				}
			}
			setMass(new Mass(mouse.getX(), mouse.getY(), 0));
			setSpring(new Spring(tempMass, getMass(), temp, 0));
			getModel().add(getMass());
			getModel().add(getSpring());
			isCreated = true;
		}
		else{
			getMass().setCenter(new Location(mouse.getX(), mouse.getY()));
		}
	}
	/**
	 * remove the spring and the mass from the model if the mouse is released
	 */
	private void removeSpringMass()
	{
		if(isCreated){
			getModel().getSprings().remove(getSpring());
			getModel().getMasses().remove(getMass());
			isCreated = false;
		}
	}

}
