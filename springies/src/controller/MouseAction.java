package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import simulation.Mass;
import simulation.Model;
import simulation.Spring;
import util.Location;
import view.Canvas;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Deals with adding and removing a spring and a mass when the mouse is clicked and released.  Also, if the mouse is dragged, the 
 *mass will move to the mouse position causing the spring to rotate, extend, or contract
 */
public class MouseAction {
	private boolean isCreated;
	private int myMouseButton;
	private Canvas myCanvas;
	private Model myModel;
	private Spring mySpring;  
	private Mass myMass;
	/**
	 * creates a MouseAction object which sets the sets the state to be that a spring and a mass have not yet been created
	 * with a mouse click
	 * @param model: the model where the simulation takes place
	 */
	public MouseAction(Model model) {
		myModel = model;
		myCanvas = model.getCanvas();
		isCreated = false;
	}

	/**
	 * sets the mouse button to be the button that was clicked
	 * @param button: the button that gets clicked
	 */
	public void setMouseButton(int button) {
		myMouseButton = button;
	}
	
	public void performAction() {
		switch(myMouseButton) {
			case MouseEvent.BUTTON1: createMassSpring(); break;
			case MouseEvent.NOBUTTON: removeSpringMass(); break;
			default: break;
		}
		 
	}
	/**
	 * creates a mass and a spring if there is a mouse click.  If the mouse is being 
	 * clicked and dragged, move the mass to the mouse position and rotate, extend, 
	 * or contract the spring to keep it connected to the two masses that it was connected to.
	 */
	private void createMassSpring() {
		Point mouse = myCanvas.getLastMousePosition();
		if (!isCreated) {
			List<Mass> masses = myModel.getMasses();
			Mass tempMass = new Mass(0, 0, 0); 
			Double temp = Double.MAX_VALUE;
			for (Mass m : masses) {
				Double dist = mouse.distance(new Location(m.getX(), m.getY()));
				if(dist < temp) {
					tempMass = m;
					temp = dist;
				}
			}
			myMass = new Mass(mouse.getX(), mouse.getY(), 0);
			mySpring = new Spring(tempMass, myMass, temp, 0);
			myModel.add(myMass);
			myModel.add(mySpring);
			isCreated = true; }
		else {
			myMass.setCenter(new Location(mouse.getX(), mouse.getY()));
		}
		
	}
	/**
	 * remove the spring and the mass from the model if the mouse is released
	 */
	private void removeSpringMass() {
		if (isCreated) {
			myModel.getSprings().remove(mySpring);
			myModel.getMasses().remove(myMass);
			isCreated = false;
		}
	}

}
