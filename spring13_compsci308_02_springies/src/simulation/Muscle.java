/**
 * 
 */
package simulation;

import java.awt.Dimension;

import util.Vector;

/**
 * @author junho
 * ryan
 *
 */
public class Muscle extends Spring {

	private double myAmplitude;
	private double initLength;
	private double myLength;
	/**
	 * @param start
	 * @param end
	 * @param length
	 * @param kVal
	 */
	public Muscle(Mass start, Mass end, double length, double kVal, double amplitude) {
		super(start, end, length, kVal);
		myAmplitude = amplitude;
		initLength = length;
		myLength = length;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void update (double elapsedTime, Dimension bounds) {
		
		setLength(elapsedTime);		
        super.update(elapsedTime, bounds);
    }
	
	public void setLength(double time){
		myLength = initLength*Math.sin(time)*myAmplitude;
	}


}
