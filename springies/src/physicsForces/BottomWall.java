package physicsForces;

import simulation.Mass;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Wall repulsion for bottom wall
 */
public class BottomWall extends WallRepulsion {

	public static final int MY_DIRECTION = 270;
	
	/**
	 * sets the magnitude and exponent for the bottom wall
	 * @param magnitude is the magnitude of the force
	 * @param exponent is the amount by which the wall repulsion decays with distance
	 */
	public BottomWall(double magnitude, double exponent) {
		super(magnitude, exponent);
	}

	@Override
	public double returnDirection() {
		return MY_DIRECTION;
	}

	@Override
	public double distanceFromWall(Mass mass) {
		return getBounds().getHeight() - mass.getY();
	}
}
