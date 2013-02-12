package simulation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import physicsForces.CenterOfMass;
import physicsForces.Force;

import util.Sprite;
import view.Canvas;


/**
 * XXX.
 * 
 * @author Robert C. Duvall
 */
public class Model {
    // bounds and input for game
    private Canvas myView;
    // simulation state
    private List<Mass> myMasses;
    private List<Spring> mySprings;
    private Physics myPhysics;

    
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model (Canvas canvas) {
        myView = canvas;
        myMasses = new ArrayList<Mass>();
        mySprings = new ArrayList<Spring>();
        myPhysics = new Physics();
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
     * Update simulation for this moment, given the time since the last moment.
     */
    public void update (double elapsedTime) {
        Dimension bounds = myView.getSize();
        myPhysics.update(myMasses, bounds);
        
        for (Spring s : mySprings) {
            s.update(elapsedTime, bounds);
        }
        
        for (Mass m : myMasses) {
            m.applyForce(myPhysics.getEnvironmentVector(m));
            m.update(elapsedTime, bounds);
        }
        //key = "n" myView.newWindow();
       
    }

    public void add(Sprite sprite)
    {
    	if(sprite instanceof Mass)
    		add((Mass)sprite);
    	else if(sprite instanceof Spring)
    		add((Spring)sprite);
    }
    /**
     * Add given mass to this simulation.
     */
    private void add(Mass mass) {
        myMasses.add(mass);
    }
    /**
     * Add given spring to this simulation.
     */
    private void add(Spring spring) {
        mySprings.add(spring);
    }
    /**
     * Add given force to this simulation's physics.
     */
    public void add(String type, Force force)
    {
    	myPhysics.addForce(type, force);
    }
    
    public void setPhysics(Physics physics)
    {
    	myPhysics = physics;
    }
    public Physics getPhysics()
    {
    	return myPhysics;
    }


}