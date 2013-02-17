package physicsForces;

import simulation.Mass;

public class TopWall extends WallRepulsion {

public static final int MY_DIRECTION = 90;
	
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
