package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;


/**
 * XXX.
 * 
 * @author Robert C. Duvall
 */
public class Mass extends Sprite {    
    // reasonable default values
    public static final Dimension DEFAULT_SIZE = new Dimension(16, 16);
    public static final Pixmap DEFUALT_IMAGE = new Pixmap("mass.gif");

    private double myMass;
    private Vector myAcceleration;
    private Physics myPhysics;


    /**
     * XXX.
     */
    public Mass (double x, double y, double mass) {
        super(DEFUALT_IMAGE, new Location(x, y), DEFAULT_SIZE);
        myMass = mass;
        myAcceleration = new Vector();

    }
	public double distanceFromCenterOfMass()
	{
		return new Location(myPhysics.getCenterOfMass().getCenterOfMassPosition().getX(), myPhysics.getCenterOfMass().getCenterOfMassPosition().getY()).distance(getX(),getY());
	}
	
	

    public double getAngleForCOM()
    {
		double distFromCenterOfMass = distanceFromCenterOfMass();
		double xDiff = getX() - myPhysics.getCenterOfMass().getCenterOfMassPosition().getX();
		double yDiff = getY() - myPhysics.getCenterOfMass().getCenterOfMassPosition().getY();
		return 180 + Math.toDegrees((Math.tan((yDiff)/(xDiff)))); //why 180?
    }

    public void setPhysics(Physics physics)
    {
    	myPhysics = physics;
    	myPhysics.getViscosity().setDirection(this.getVelocity().getDirection());
    }

    public double getMass()
    {
    	return myMass;
    }
    
    /**
     * XXX.
     */
    @Override
    public void update (double elapsedTime, Dimension bounds) {
    	
        applyForce(getBounce(bounds));
        applyForce(myPhysics.getGravity().getGravity());
        applyForce(myPhysics.getViscosity().getViscosity());
    	double magnitude = myPhysics.getCenterOfMass().getMagnitude()/Math.pow(distanceFromCenterOfMass(),myPhysics.getCenterOfMass().getExponent());
        applyForce(new Vector(getAngleForCOM(), magnitude));
        
        // convert force back into Mover's velocity
        getVelocity().sum(myAcceleration);
        myAcceleration.reset();
        // move mass by velocity
        super.update(elapsedTime, bounds);
    }

    /**
     * XXX.
     */
    @Override
    public void paint (Graphics2D pen) {
        pen.setColor(Color.BLACK);
        pen.fillOval((int)getLeft(), (int)getTop(), (int)getWidth(), (int)getHeight());
    }

    /**
     * Use the given force to change this mass's acceleration.
     */
    public void applyForce (Vector force) {
        myAcceleration.sum(force);
    }

    /**
     * Convenience method.
     */
    public double distance (Mass other) {
        // this is a little awkward, so hide it
        return new Location(getX(), getY()).distance(new Location(other.getX(), other.getY()));
    }

    // check for move out of bounds
    private Vector getBounce (Dimension bounds) {
        final double IMPULSE_MAGNITUDE = 2;
        Vector impulse = new Vector();
        if (getLeft() < 0) {
            impulse = new Vector(RIGHT_DIRECTION, IMPULSE_MAGNITUDE);
        }
        else if (getRight() > bounds.width) {
            impulse = new Vector(LEFT_DIRECTION, IMPULSE_MAGNITUDE);
        }
        
        if (getBottom() >= bounds.height ) {
        
            impulse = new Vector(UP_DIRECTION, IMPULSE_MAGNITUDE);
        }
        if (getTop() < 0) {
            impulse = new Vector(DOWN_DIRECTION, IMPULSE_MAGNITUDE);
        }
        //impulse scale angle calculation is off. 
        	impulse.scale(getVelocity().getRelativeMagnitude(impulse));
        return impulse;
    }
}

