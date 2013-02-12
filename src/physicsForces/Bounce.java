package physicsForces;


import util.Vector;
import simulation.Mass;

public class Bounce extends Force {
	
	public Bounce(Vector bounce) {
		super(bounce);
	}
	
	public void massInitialize(Mass m)
	{
		 final double IMPULSE_MAGNITUDE = 2;
		 	if (m.getLeft() < 0) {
		 		this.setDirection(DIRECTIONS[1]);
	            this.setMagnitude(IMPULSE_MAGNITUDE);
	        }
	        else if (m.getRight() > getBounds().width) {
	        	this.setDirection(DIRECTIONS[3]);
	            this.setMagnitude(IMPULSE_MAGNITUDE);
	        }
	        
	        if (m.getBottom() >= getBounds().height ) {
	        	this.setDirection(DIRECTIONS[2]);
	            this.setMagnitude(IMPULSE_MAGNITUDE);
	        }
	        if (m.getTop() < 0) {
	        	this.setDirection(DIRECTIONS[0]);
	            this.setMagnitude(IMPULSE_MAGNITUDE);
	        }
	        //impulse scale angle calculation is off. 
	        this.scale(m.getVelocity().getRelativeMagnitude(this));
	}
}
