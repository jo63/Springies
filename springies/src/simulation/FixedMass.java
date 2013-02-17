/**
 * 
 */
package simulation;

import java.awt.Dimension;

/**
 * 
 * @author Ryan Fishel and Kevin Oh
 * 
 */

public class FixedMass extends Mass {

	/**
	 * creates a fixed mass at the specified position.
	 * @param x The x position of the fixed mass
	 * @param y the y position of the fixed mass
	 * @param mass the actual mass of the fixed mass
	 */
	public FixedMass(double x, double y, double mass) {
		super(x, y, mass);
		// TODO Auto-generated constructor stub
	}

	/**
	 * overrides the update method so the fixed mass never gets updated.
	 */
	@Override
	public void update(double elapsedTime, Dimension bounds) {
		return;
	}
	
}
