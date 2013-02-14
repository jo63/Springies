package controller;

import java.awt.Dimension;
import java.util.Map;

import physicsForces.*;
import simulation.Model;
import view.Canvas;

public abstract class KeyAction {
	private Model myModel;
	private Map<String, Force> myForces;
	public static final int INCREASE_FACTOR = 10;
	private Canvas myCanvas;

	public KeyAction(Model model)
	{
		myModel = model;
		myForces = model.getPhysics().getForces();
		myCanvas = model.getCanvas();
		
	}
	
	public abstract void performAction();
	public Model getModel()
	{
		return myModel;
	}
	public Map<String, Force> getForces()
	{
		return myForces;
	}
	public int getIncreaseFactor()
	{
		return INCREASE_FACTOR;
	}
	public Canvas getCanvas()
	{
		return myCanvas;
	}
}


class LoadAssembly extends KeyAction
{
	public LoadAssembly(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		getModel().getCanvas().loadAssembly();
	}
}
class ClearAssembly extends KeyAction
{
	public ClearAssembly(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		getModel().clear();
	}
}
class ToggleGravity extends KeyAction
{

	public ToggleGravity(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		if(getForces().get("gravity") != null)
		{
			((Gravity)(getForces().get("gravity"))).toggleForce();
		}
	}
}
class ToggleViscosity extends KeyAction
{

	public ToggleViscosity(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		if(getForces().get("viscosity") != null)
		{
			((Viscosity)(getForces().get("viscosity"))).toggleForce();
		}
	}
}
class ToggleCenterOfMass extends KeyAction
{

	public ToggleCenterOfMass(Model model) {
		super(model);
	}
	@Override
	public void performAction() {
		if(getForces().get("centermass") != null)
		{
			((CenterOfMass)(getForces().get("centermass"))).toggleForce();
		}
	}
}
class ToggleWallRepulsion extends KeyAction
{
	private int myID;
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
class Increase extends KeyAction
{
	public Increase(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		Dimension temp = getCanvas().getSize();
		double width = temp.getWidth();
		double height = temp.getHeight();
		temp.setSize(width + getIncreaseFactor(), height + getIncreaseFactor());
	}
}
class Decrease extends KeyAction
{
	public Decrease(Model model) {
		super(model);
	}

	@Override
	public void performAction() {
		Dimension temp = getCanvas().getSize();
		double width = temp.getWidth();
		double height = temp.getHeight();
		temp.setSize(width - getIncreaseFactor(), height - getIncreaseFactor());
	}
}









