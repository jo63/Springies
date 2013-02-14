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
		mySpring = new Spring(tempMass, new Mass(mouse.getX(), mouse.getY(), 0), temp, 0);
		getModel().add(mySpring);
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
	}
}