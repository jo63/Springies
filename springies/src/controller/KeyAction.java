package controller;

import java.util.Map;

import physicsForces.*;
import simulation.Model;
import view.Canvas;

public abstract class KeyAction {
	private Model myModel;
	private Map<String, Force> myForces;

	public KeyAction(Model model)
	{
		myModel = model;
		myForces = model.getPhysics().getForces();
		
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

	public ToggleWallRepulsion(Model model) {
		super(model);
	}
	@Override
	public void performAction() {
		//TODO: toggle the appropriate
	}
}







