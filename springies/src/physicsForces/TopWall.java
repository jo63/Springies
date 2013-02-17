package physicsForces;

import simulation.Mass;
/**
 * 
 * @author Ryan Fishel and Kevin Oh
 *Wall repulsion for top wall
 */
public class TopWall extends WallRepulsion {

public static final int MY_DIRECTION = 90;
/**
 * sets the magnitude and exponent for the top wall
 * @param magnitude is the magnitude of the force
 * @param exponent is the amount by which the wall repulsion decays with distance
 */
	public TopWall(double magnitude, double exponent) {
		super(magnitude, exponent);
	}

	@Override
	public double returnDirection() {
		return MY_DIRECTION;
	}

	@Override
	public double distanceFromWall(Mass mass) {
		return mass.getY();
	}
}
