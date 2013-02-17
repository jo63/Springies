package physicsForces;

import simulation.Mass;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Wall repulsion for left wall
 */
public class LeftWall extends WallRepulsion {

	public static final int MY_DIRECTION = 360;
	/**
	 * sets the magnitude and exponent for the left wall
	 * @param magnitude is the magnitude of the force
	 * @param exponent is the amount by which the wall repulsion decays with distance
	 */
	public LeftWall(double magnitude, double exponent) {
		super(magnitude, exponent);
	}

	@Override
	public double returnDirection() {
		return MY_DIRECTION;
	}

	@Override
	public double distanceFromWall(Mass mass) {
		return mass.getX();
	}

}
