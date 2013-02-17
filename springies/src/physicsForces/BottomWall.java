package physicsForces;

import simulation.Mass;

public class BottomWall extends WallRepulsion {

	public static final int MY_DIRECTION = 270;
	
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
