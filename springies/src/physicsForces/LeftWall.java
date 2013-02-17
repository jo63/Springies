package physicsForces;

import simulation.Mass;

public class LeftWall extends WallRepulsion {

	public static final int MY_DIRECTION = 360;
	
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
