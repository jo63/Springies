/**
 * 
 */
package simulation;

import java.awt.Dimension;

/**
 * @author junho
 * ryan
 *
 */

public class FixedMass extends Mass {

	/**
	 * @param x
	 * @param y
	 * @param mass
	 */
	public FixedMass(double x, double y, double mass) {
		super(x, y, mass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(double elapsedTime, Dimension bounds) {
		return;
	}
	
}
