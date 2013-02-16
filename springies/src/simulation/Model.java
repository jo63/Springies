package simulation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import controller.Controller;

import physicsForces.CenterOfMass;
import physicsForces.Force;

import util.Sprite;
import view.Canvas;


/**
 * XXX.
 * 
 * @author Robert C. Duvall, Ryan Fishel, and Kevin Oh
 */
public class Model {
    // bounds and input for game
    private Canvas myView;
    // simulation state
    private List<Mass> myMasses;
    private List<Spring> mySprings;
    private Physics myPhysics;
    private Controller myController;

    
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model (Canvas canvas) {
        myView = canvas;
        myMasses = new ArrayList<Mass>();
        mySprings = new ArrayList<Spring>();
        myPhysics = new Physics();
        myController = new Controller(this);
       
    }
    /**
     * 
     * @param physics: Passes in a physics object
     * sets the myPhysics instance variable so that the physics for the simulation
     * are created
     */
    public void setPhysics(Physics physics)
    {
    	myPhysics = physics;
    }
    /**
     * Returns the myPhysics instance variable
     * @return the physics of the simulation
     */
    public Physics getPhysics()
    {
    	return myPhysics;
    }
    /**
     * returns the instance of canvas
     * @return the canvas that the simulation is taking place on
     */
    public Canvas getCanvas()
    {
    	return myView;
    }
    /**
     * Draw all elements of the simulation.
     */
    public void paint (Graphics2D pen) {
        for (Spring s : mySprings) {
            s.paint(pen);
        }
        for (Mass m : myMasses) {
            m.paint(pen);
        }
        
      //  myPhysics.getCenterOfMass().draw(pen);
    }
    
    /**
     * returns the list of all the masses that exist
     * @return the list of masses in the simulation
     */
    public List<Mass> getMasses()
    {
    	return myMasses;
    }
    
    /**
     * returns the list of all the springs that exist
     * @return the list of the springs in the simulation
     */
    public List<Spring> getSprings()
    {
    	return mySprings;
    }

    /**
     * Update simulation for this moment, given the time since the last moment.
     */
    public void update (double elapsedTime) {
        Dimension bounds = myView.getSize();
        myPhysics.update(myMasses, bounds);
        myController.performAction();
        
        for (Spring s : mySprings) {
            s.update(elapsedTime, bounds);
        }
        
        for (Mass m : myMasses) {
            m.applyForce(myPhysics.getEnvironmentVector(m));
            m.update(elapsedTime, bounds);
        }
       
    }
    /**
     * Add given mass to this simulation.
     */
    private void add(Mass mass){
        myMasses.add(mass);
    }
    /**
     * Add given spring to this simulation.
     */
    private void add(Spring spring){
        mySprings.add(spring);
    }
    /**
     * Add given force to this simulation's physics.
     */
    public void add(String type, Force force){
    	myPhysics.addForce(type, force);
    }
    /**
     * clears the list of masses and the list of springs
     */
    public void clear(){
    	myMasses = new ArrayList<Mass>();
        mySprings = new ArrayList<Spring>();
    }

}
