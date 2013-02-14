package controller;

import java.awt.Point;

import simulation.Model;

public abstract class MouseAction {
	
	private Model myModel;
	
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
		setMousePosition(getModel().getCanvas().getMousePosition());
		
		//getModel().
	}	
	
}

class RemoveSpring extends MouseAction {
	
	public RemoveSpring(Model model)
	{
		super(model);
	}
	
	@Override
	public void performAction(){
		
	}
}