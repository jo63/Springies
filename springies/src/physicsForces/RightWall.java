package physicsForces;

import simulation.Mass;

public class RightWall extends WallRepulsion{

	public static final int MY_DIRECTION = 180;
	
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
