package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import simulation.Mass;
import simulation.Model;
import simulation.Spring;
import util.Location;

public abstract class MouseAction {

	private Model myModel;
	private Spring mySpring; //getter and setter. 
	private Mass myMass;

	public MouseAction(Model model)
	{
		myModel = model;
	}
	public void setSpring(Spring spring)
	{
		mySpring = spring;
	}
	public void setMass(Mass mass)
	{
		myMass = mass;
	}
	public Model getModel()
	{
		return myModel;
	}
	public Spring getSpring()
	{
		return mySpring;
	}
	public Mass getMass()
	{
		return myMass;
	}

	public abstract void performAction();

}

class NewSpringHandler extends MouseAction {
	private boolean isCreated;
	private int myMouseButton;
	
	public NewSpringHandler(Model model)
	{
		super(model);
		isCreated = false;
	}
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
	 * 
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
