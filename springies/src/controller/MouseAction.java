package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import simulation.Mass;
import simulation.Model;
import simulation.Spring;
import util.Location;

public abstract class MouseAction {

	private Model myModel;
	protected Spring mySpring;
	protected Mass myMass;
	private Point mousePosition;

	public MouseAction(Model model)
	{
		myModel = model;
	}

	public Model getModel()
	{
		return myModel;
	}

	public Point getMousePosition()
	{
		return mousePosition;
	}

	public void setMousePosition(Point position)
	{
		mousePosition = position;
	}

	public abstract void performAction();

}

class CreateSpring extends MouseAction {

	public CreateSpring(Model model)
	{
		super(model);
	}

	@Override
	public void performAction() {
		Point mouse = getModel().getCanvas().getMousePosition();
		setMousePosition(mouse);
		boolean isCreated = false;
		if(!isCreated){
			List<Mass> masses = getModel().getMasses();
			Mass tempMass = new Mass(0.0,0.0,0.0); 
			Double temp = 1000.0;
			for(Mass m : masses)
			{
				Double dist = getMousePosition().distance(new Location(m.getX(), m.getY()));
				if(dist < temp){
					tempMass = m;
					temp = dist;
				}
			}
			myMass = new Mass(mouse.getX(), mouse.getY(), 0);
			mySpring = new Spring(tempMass, myMass, temp, 0);
			getModel().add(myMass);
			getModel().add(mySpring);
			isCreated = true;
		}
		else{
			myMass.setCenter(new Location(mouse.getX(), mouse.getY()));
		}
		 
	}	

}

class RemoveSpring extends MouseAction {

	public RemoveSpring(Model model)
	{
		super(model);
	}

	@Override
	public void performAction(){
		getModel().getSprings().remove(mySpring);
		getModel().getMasses().remove(myMass);
	}
}