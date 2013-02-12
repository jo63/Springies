package physicsForces;


import util.Location;
import util.Vector;
import simulation.Mass;

public class Bounce extends Force {
	
	public Bounce(Vector bounce) {
		super(bounce);
	}
	
//	public void massInitialize(Mass m)
//	{
//		 final double IMPULSE_MAGNITUDE = 2;
//		 	if (m.getLeft() < 0) {
//		 		this.setDirection(DIRECTIONS[1]);
//	            this.setMagnitude(IMPULSE_MAGNITUDE);
//	        }
//	        else if (m.getRight() > getBounds().width) {
//	        	this.setDirection(DIRECTIONS[3]);
//	            this.setMagnitude(IMPULSE_MAGNITUDE);
//	        }
//	        
//	        if (m.getBottom() >= getBounds().height ) {
//	        	this.setDirection(DIRECTIONS[2]);
//	            this.setMagnitude(IMPULSE_MAGNITUDE);
//	        }
//	        if (m.getTop() < 0) {
//	        	this.setDirection(DIRECTIONS[0]);
//	            this.setMagnitude(IMPULSE_MAGNITUDE);
//	        }
//	        //impulse scale angle calculation is off. 
//	        this.scale(m.getVelocity().getRelativeMagnitude(this));
//	}
	
	public void massInitialize(Mass m)
	{
		if(m.getLeft() < 0)
		{
			m.setCenter(new Location(5, m.getY()));
		}
		else if(m.getRight() > getBounds().width)
		{
			m.setCenter(new Location(getBounds().width-5, m.getY()));
		}
		if(m.getBottom() >= getBounds().height)
		{
			m.setCenter(new Location(m.getX(), getBounds().height-5));
		}
		else if(m.getTop() < 0)
		{
			m.setCenter(new Location(m.getX(), 5));
		}
	}
}
