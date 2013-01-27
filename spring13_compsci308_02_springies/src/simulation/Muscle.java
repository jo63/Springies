/**
 * 
 */
package simulation;

import java.awt.Dimension;

import util.Vector;

/**
 * @author junho
 *
 */
public class Muscle extends Spring {

	private double myAmplitude;
	
	/**
	 * @param start
	 * @param end
	 * @param length
	 * @param kVal
	 */
	public Muscle(Mass start, Mass end, double length, double kVal, double amplitude) {
		super(start, end, length, kVal);
		myAmplitude = amplitude;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void update (double elapsedTime, Dimension bounds) {
		
		super.getStart().applyForce(new Vector());
		//super.getStart().update(elapsedTime, bounds);
		
        super.update(elapsedTime, bounds);
    }
	
	

}
