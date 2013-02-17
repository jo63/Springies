package simulation;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import controller.Controller;
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
    private Dimension myBounds;

    
    /**
     * Create a game of the given size with the given display for its shapes.
     */
    public Model (Canvas canvas) {
        myView = canvas;
        myMasses = new ArrayList<Mass>();
        mySprings = new ArrayList<Spring>();
        myPhysics = new Physics();
        myBounds = new Dimension();
        myController = new Controller(this);
    }
    /**
     * Returns the myPhysics instance variable
     * @return the physics of the simulation
     */
    public Physics getPhysics(){
    	return myPhysics;
    }
    /**
     * returns the instance of canvas
     * @return the canvas that the simulation is taking place on
     */
    public Canvas getCanvas() {
    	return myView;
    }
    public Dimension getBounds() {
    	return myBounds;
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
    public List<Mass> getMasses() {
    	return myMasses;
    }
    
    /**
     * returns the list of all the springs that exist
     * @return the list of the springs in the simulation
     */
    public List<Spring> getSprings() {
    	return mySprings;
    }

    /**
     * Update simulation for this moment, given the time since the last moment.
     */
    public void update (double elapsedTime) {
        myBounds = myView.getSize();
        myPhysics.update(myMasses, myBounds);

        myController.performAction();
        
        for (Spring s : mySprings) {
            s.update(elapsedTime, myBounds);
        }
        
        for (Mass m : myMasses) {
            m.applyForce(myPhysics.getEnvironmentVector(m));
            m.update(elapsedTime, myBounds);
        }
       
    }
    /**
     * Add given mass or spring to this simulation.
     */
    public void add(Sprite sprite) {
       if(sprite instanceof Mass) {
    	   myMasses.add((Mass) sprite);
       }
       else if (sprite instanceof Spring) {
    	   mySprings.add((Spring) sprite);
       }
    }
    /**
     * Add given force to this simulation's physics.
     */
    public void add(String type, Force force) {
    	myPhysics.addForce(type, force);
    }
    /**
     * clears the list of masses and the list of springs
     */
    public void clear() {
    	myMasses = new ArrayList<Mass>();
        mySprings = new ArrayList<Spring>();
    }

}
