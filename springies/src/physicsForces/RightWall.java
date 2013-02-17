package physicsForces;

import simulation.Mass;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Wall repulsion for right wall
 */
public class RightWall extends WallRepulsion {

	public static final int MY_DIRECTION = 180;
	/**
	 * sets the magnitude and exponent for the right wall
	 * @param magnitude is the magnitude of the force
	 * @param exponent is the amount by which the wall repulsion decays with distance
	 */
	public RightWall(double magnitude, double exponent) {
		super(magnitude, exponent);
	}

	@Override
	public double returnDirection() {
		return MY_DIRECTION;
	}

	@Override
	public double distanceFromWall(Mass mass) {
		return getBounds().getWidth() - mass.getX();
	}

}
